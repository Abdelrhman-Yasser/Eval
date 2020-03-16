package com.ejada.validations.complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;

import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.exceptions.ValidationNotSupportedException;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.RequiredResult;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class ComplexIteratorValidator.
 */
public class ComplexIteratorValidator {

	/**
	 * The Constant dot.
	 */
	private static final String dot = ".";

	/**
	 * The keys collected from validations.
	 */
	private Set<String> keysCollectedVal;

	/**
	 * The keys collected from JSON Object.
	 */
	private Set<String> keysCollectedObj;

	/**
	 * The language of required labels.
	 */
	private HashMap<String, LangParam<?>> reqLabelLang;

	/**
	 * Instantiates a new complex iterator validator.
	 */
	public ComplexIteratorValidator() {
		keysCollectedVal = new HashSet<String>();
		keysCollectedObj = new HashSet<String>();
		reqLabelLang = new HashMap<String, LangParam<?>>();
	}

	/**
	 * Validate.
	 *
	 * @param obj     the JSON object to be validated
	 * @param configs the validation configurations
	 * @return the array list
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound        the validation configuration not
	 *                                         found
	 */
	public ArrayList<ValidationResult> validate(JsonObject obj, HashMap<String, ArrayList<ValidationConfig>> configs)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException,
			ValidationConfigNotFound {

		ArrayList<ValidationResult> results = new ArrayList<ValidationResult>();

		/*******************************************************************
		 *
		 * Traverse JSON object as a Tree structure and validates each
		 * 
		 * object based on validation configurations
		 * 
		 ********************************************************************/
		dfs(obj, "", -1, configs, results);

		/*******************************************************************
		 *
		 * Collect keys that don't appear in JSON Object and it's required
		 * 
		 * to validate it and populate errors
		 * 
		 ********************************************************************/
		collectRequired(configs);
		checkNotFoundFields(results);

		return results;
	}

	/**
	 * Dfs.
	 *
	 * @param obj     the JSON object to be validated
	 * @param key     the key label of object
	 * @param order   the iteration order of iterative objects
	 * @param mapping the validation configurations of each object in JSON object
	 * @param results the validation results
	 * 
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound        the validation configuration not
	 *                                         found
	 */
	private void dfs(JsonValue obj, String key, int order, HashMap<String, ArrayList<ValidationConfig>> mapping,
			ArrayList<ValidationResult> results) throws ValidationNotSupportedException, MissingParameterException,
			WrongOperatorException, ValidationConfigNotFound {

		// collect keys of objects traversed to be checked later for misssing objects
		if (key != "")
			keysCollectedObj.add(key);

		/****************************************************************
		 * 
		 * Traversing JSON array objects and check validation on each
		 * 
		 * each item in the array recursively
		 * 
		 **************************************************************/
		if (obj.getValueType().equals(ValueType.ARRAY)) {

			JsonArray list = (JsonArray) obj;
			ArrayList<ValidationConfig> valConfig = mapping.getOrDefault(key, new ArrayList<ValidationConfig>());

			// validate item in the array
			excuteValidations(list.toString(), key, valConfig, results);

			// recurse on current item
			for (int i = 0; i < list.size(); i++) {
				JsonValue jsonValue = list.get(i);
				dfs(jsonValue, key, i, mapping, results);
			}

		}
		/****************************************************************
		 * 
		 * Traversing JSON object by fetching all keys in them and
		 * 
		 * iterate on them to validate simple objects
		 * 
		 **************************************************************/
		else if (obj.getValueType().equals(ValueType.OBJECT)) {
			JsonObject parent = (JsonObject) obj;
			ArrayList<ValidationConfig> valConfig = mapping.getOrDefault(key, new ArrayList<ValidationConfig>());
			excuteValidations(parent.toString(), key + "[" + order + "]", valConfig, results);
			for (String child : parent.keySet()) {
				String labelName = key + (!key.isEmpty() ? dot : "") + child;
				dfs(parent.get(child), labelName, 0, mapping, results);
			}
		}
		/**************************************************************
		 * 
		 * Validate simple objects using complex validator that
		 * 
		 * validates a field with multiple validation configuration
		 * 
		 * and populate errors
		 * 
		 **************************************************************/
		else if (obj.getValueType().equals(ValueType.STRING)) {
			JsonString parent = (JsonString) obj;
			ArrayList<ValidationConfig> valConfig = mapping.getOrDefault(key, new ArrayList<ValidationConfig>());
			excuteValidations(parent.toString(), key + "[" + order + "]", valConfig, results);
		}
	}

	/**
	 * Check required fields that don't appear in JSON object.
	 *
	 * @param results the validation results
	 * @throws ValidationConfigNotFound the validation configuration not found
	 * 
	 */
	private void checkNotFoundFields(ArrayList<ValidationResult> results) throws ValidationConfigNotFound {
		for (String key : keysCollectedVal) {
			if (!keysCollectedObj.contains(key)) {
				results.add(new RequiredResult(false, key, reqLabelLang.get(key)));
			}
		}
	}

	/**
	 * Execute validations on each field using complex validator.
	 *
	 * @param field     the JSON object to be validated
	 * @param fieldName the key label of object
	 * @param config    the validation configurations
	 * @param results   the results of validations
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound        the validation config not found
	 */
	private void excuteValidations(String field, String fieldName, ArrayList<ValidationConfig> config,
			ArrayList<ValidationResult> results) throws ValidationNotSupportedException, MissingParameterException,
			WrongOperatorException, ValidationConfigNotFound {
		results.addAll(ComplexValidator.validate(field, fieldName, config));
	}

	/**
	 * Collect required objects from validation configurations.
	 *
	 * @param mapping configurations of each key in JSON object
	 * 
	 */
	private void collectRequired(HashMap<String, ArrayList<ValidationConfig>> mapping) {
		for (Entry<String, ArrayList<ValidationConfig>> val : mapping.entrySet()) {
			if (ContainsRequired(val.getValue(), val.getKey())) {
				keysCollectedVal.add(val.getKey());
			}
		}
	}

	/**
	 * Check configurations contain a required configuration.
	 *
	 * @param config the validations configuration to check.
	 * @param key    Key label of object
	 * @return true, if contains a required validation.
	 */
	private boolean ContainsRequired(ArrayList<ValidationConfig> config, String key) {
		boolean res = false;
		for (ValidationConfig val : config)
			if (val.getClass() == RequiredValidationConfig.class) {
				reqLabelLang.put(key, (LangParam<?>) val.getParam(ParamType.Language));
				res = true;
			}
		return res;
	}

}
