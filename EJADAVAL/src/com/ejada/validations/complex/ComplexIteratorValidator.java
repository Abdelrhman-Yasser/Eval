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
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.params.ParamType;
import com.ejada.validations.result.RequiredResult;
import com.ejada.validations.result.ValidationResult;

public class ComplexIteratorValidator {

	/**
	 * The Constant dot.
	 */
	private static final String dot = ".";

	private Set<String> keysCollectedVal;
	private Set<String> keysCollectedObj;
	private HashMap<String, Language> reqLabelLang;

	public ComplexIteratorValidator() {
		keysCollectedVal = new HashSet<String>();
		keysCollectedObj = new HashSet<String>();
		reqLabelLang = new HashMap<String, Language>();
	}

	public ArrayList<ValidationResult> validate(JsonObject obj, HashMap<String, ArrayList<ValidationConfig>> configs)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException,
			ValidationConfigNotFound {

		ArrayList<ValidationResult> results = new ArrayList<ValidationResult>();
		dfs(obj, "", -1, configs, results);

		collectRequired(configs);
		checkNotFoundFields(results);

		return results;
	}

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

	private void checkNotFoundFields(ArrayList<ValidationResult> results) throws ValidationConfigNotFound {
		for (String key : keysCollectedVal) {
			if (!keysCollectedObj.contains(key)) {
				results.add(new RequiredResult(false, key, reqLabelLang.get(key)));
			}
		}
	}

	private void excuteValidations(String field, String fieldName, ArrayList<ValidationConfig> config,
			ArrayList<ValidationResult> results) throws ValidationNotSupportedException, MissingParameterException,
			WrongOperatorException, ValidationConfigNotFound {
		results.addAll(ComplexValidator.validate(field, fieldName, config));
	}

	private void collectRequired(HashMap<String, ArrayList<ValidationConfig>> mapping) {
		for (Entry<String, ArrayList<ValidationConfig>> val : mapping.entrySet()) {
			if (ContainsRequired(val.getValue(), val.getKey())) {
				keysCollectedVal.add(val.getKey());
			}
		}
	}

	private boolean ContainsRequired(ArrayList<ValidationConfig> config, String key) {
		boolean res = false;
		for (ValidationConfig val : config)
			if (val.getClass() == RequiredValidationConfig.class) {
				reqLabelLang.put(key, (Language) val.getParam(ParamType.Language).getValue());
				res = true;
			}
		return res;
	}

}
