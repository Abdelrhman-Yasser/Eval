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
	 * The keys collected val.
	 */
	private Set<String> keysCollectedVal;

	/**
	 * The keys collected obj.
	 */
	private Set<String> keysCollectedObj;

	/**
	 * The req label lang.
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
	 * @param obj     the obj
	 * @param configs the configs
	 * @return the array list
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound        the validation config not found
	 */
	public ArrayList<ValidationResult> validate(JsonObject obj, HashMap<String, ArrayList<ValidationConfig>> configs)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException,
			ValidationConfigNotFound {

		ArrayList<ValidationResult> results = new ArrayList<ValidationResult>();
		dfs(obj, "", -1, configs, results);

		collectRequired(configs);
		checkNotFoundFields(results);

		return results;
	}

	/**
	 * Dfs.
	 *
	 * @param obj     the obj
	 * @param key     the key
	 * @param order   the order
	 * @param mapping the mapping
	 * @param results the results
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound        the validation config not found
	 */
	private void dfs(JsonValue obj, String key, int order, HashMap<String, ArrayList<ValidationConfig>> mapping,
			ArrayList<ValidationResult> results) throws ValidationNotSupportedException, MissingParameterException,
			WrongOperatorException, ValidationConfigNotFound {

		if (key != "")
			keysCollectedObj.add(key);

		if (obj.getValueType().equals(ValueType.ARRAY)) {
			JsonArray list = (JsonArray) obj;
			ArrayList<ValidationConfig> valConfig = mapping.getOrDefault(key, new ArrayList<ValidationConfig>());
			excuteValidations(list.toString(), key, valConfig, results);
			for (int i = 0; i < list.size(); i++) {
				JsonValue jsonValue = list.get(i);
				dfs(jsonValue, key, i, mapping, results);
			}
		} else if (obj.getValueType().equals(ValueType.OBJECT)) {
			JsonObject parent = (JsonObject) obj;
			ArrayList<ValidationConfig> valConfig = mapping.getOrDefault(key, new ArrayList<ValidationConfig>());
			excuteValidations(parent.toString(), key + "[" + order + "]", valConfig, results);
			for (String child : parent.keySet()) {
				String labelName = key + (!key.isEmpty() ? dot : "") + child;
				dfs(parent.get(child), labelName, 0, mapping, results);
			}
		} else if (obj.getValueType().equals(ValueType.STRING)) {
			JsonString parent = (JsonString) obj;
			ArrayList<ValidationConfig> valConfig = mapping.getOrDefault(key, new ArrayList<ValidationConfig>());
			excuteValidations(parent.toString(), key + "[" + order + "]", valConfig, results);
		}
	}

	/**
	 * Check not found fields.
	 *
	 * @param results the results
	 * @throws ValidationConfigNotFound the validation config not found
	 */
	private void checkNotFoundFields(ArrayList<ValidationResult> results) throws ValidationConfigNotFound {
		for (String key : keysCollectedVal) {
			if (!keysCollectedObj.contains(key)) {
				results.add(new RequiredResult(false, key, reqLabelLang.get(key)));
			}
		}
	}

	/**
	 * Excute validations.
	 *
	 * @param field     the field
	 * @param fieldName the field name
	 * @param config    the config
	 * @param results   the results
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
	 * Collect required.
	 *
	 * @param mapping the mapping
	 */
	private void collectRequired(HashMap<String, ArrayList<ValidationConfig>> mapping) {
		for (Entry<String, ArrayList<ValidationConfig>> val : mapping.entrySet()) {
			if (ContainsRequired(val.getValue(), val.getKey())) {
				keysCollectedVal.add(val.getKey());
			}
		}
	}

	/**
	 * Contains required.
	 *
	 * @param config the config
	 * @param key    the key
	 * @return true, if successful
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
