package com.ejada.validations.complex;

import java.util.ArrayList;
import java.util.HashMap;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;

import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.exceptions.ValidationNotSupportedException;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;

/**
 * The Class ValidationSerializer.
 */
public class ValidationSerializer {

	/**
	 * The Constant dot.
	 */
	private static final String dot = ".";

	/**
	 * The Constant ValidationPointer.
	 */
	private static final String ValidationPointer = "childs";

	/**
	 * The Constant ValidationKeyPointer.
	 */
	private static final String ValidationKeyPointer = "key";

	/**
	 * The Constant ValuePointer.
	 */
	private static final String ValuePointer = "validations";

	/**
	 * The Constant ValidationTypePointer.
	 */
	private static final String ValidationTypePointer = "type";

	/**
	 * The Constant ValidationParamPointer.
	 */
	private static final String ValidationParamPointer = "params";

	/**
	 * Serialzie validations.
	 *
	 * @param config the config
	 * @return the hash map
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 */
	public static HashMap<String, ArrayList<ValidationConfig>> serialzieValidations(JsonValidationConfig config)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		HashMap<String, ArrayList<ValidationConfig>> mapping = new HashMap<String, ArrayList<ValidationConfig>>();

		JsonObject configObject = (JsonObject) config.getParam(ParamType.Json).getValue();

		LangParam<?> lang = (LangParam<?>) config.getParam(ParamType.Language);

		dfs(configObject, lang, "", mapping);

		return mapping;
	}

	/**
	 * Dfs.
	 *
	 * @param validations the validations
	 * @param lang        the lang
	 * @param key         the key
	 * @param mapping     the mapping
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 */
	private static void dfs(JsonValue validations, LangParam<?> lang, String key,
			HashMap<String, ArrayList<ValidationConfig>> mapping)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException {
		if (validations.getValueType().equals(ValueType.ARRAY)) {
			JsonArray list = (JsonArray) validations;
			for (JsonValue jsonValue : list) {
				dfs(jsonValue, lang, key, mapping);
			}
		} else if (validations.getValueType().equals(ValueType.OBJECT)) {

			JsonObject parent = (JsonObject) validations;

			JsonString keyObj = parent.getJsonString(ValidationKeyPointer);
			if (keyObj == null)
				throw new MissingParameterException(key + (!key.isEmpty() ? dot : "") + ValidationKeyPointer);

			JsonValue validationList = parent.get(ValidationPointer);
			if (validationList == null)
				throw new MissingParameterException(key + (!key.isEmpty() ? dot : "") + ValidationPointer);

			JsonArray valueObj = parent.getJsonArray(ValuePointer);
			if (valueObj == null)
				throw new MissingParameterException(key + (!key.isEmpty() ? dot : "") + ValuePointer);

			String labelName = key + (!key.isEmpty() ? dot : "") + keyObj.getString();

			buildValidations(valueObj, lang, labelName, mapping);
			dfs(validationList, lang, labelName, mapping);
		}
	}

	/**
	 * Builds the validations.
	 *
	 * @param validations the validations
	 * @param lang        the lang
	 * @param key         the key
	 * @param mapping     the mapping
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 */
	private static void buildValidations(JsonArray validations, LangParam<?> lang, String key,
			HashMap<String, ArrayList<ValidationConfig>> mapping)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException {
		for (JsonObject validation : validations.getValuesAs(JsonObject.class)) {
			buildValidation(validation, lang, key, mapping);
		}
	}

	/**
	 * Builds the validation.
	 *
	 * @param validations the validations
	 * @param lang        the lang
	 * @param key         the key
	 * @param mapping     the mapping
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 */
	private static void buildValidation(JsonObject validations, LangParam<?> lang, String key,
			HashMap<String, ArrayList<ValidationConfig>> mapping)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		JsonObject ParamsObj = validations.getJsonObject(ValidationParamPointer);
		if (ParamsObj == null)
			throw new MissingParameterException(key + dot + ValuePointer + dot + ValidationParamPointer);

		JsonString TypeObj = validations.getJsonString(ValidationTypePointer);
		if (TypeObj == null)
			throw new MissingParameterException(key + dot + ValuePointer + dot + ValidationTypePointer);

		ValidationType type = ValidationType.getByCode(TypeObj.getString());

		ArrayList<ValidationConfig> labelConfig = mapping.getOrDefault(key, new ArrayList<ValidationConfig>());
		switch (type) {
		case ArabicLang:
			labelConfig.add(new ArabicValidationConfig(ParamsObj, lang));
			mapping.put(key, labelConfig);
			break;
		case Date:
			labelConfig.add(new DateValidationConfig(ParamsObj, lang));
			mapping.put(key, labelConfig);
			break;
		case Email:
			labelConfig.add(new EmailValidationConfig(ParamsObj, lang));
			mapping.put(key, labelConfig);
			break;
		case EnglishLang:
			labelConfig.add(new EnglishValidationConfig(ParamsObj, lang));
			mapping.put(key, labelConfig);
			break;
		case Float:
			labelConfig.add(new FloatValidationConfig(ParamsObj, lang));
			mapping.put(key, labelConfig);
			break;
		case Length:
			labelConfig.add(new LengthValidationConfig(ParamsObj, lang));
			mapping.put(key, labelConfig);
			break;
		case Number:
			labelConfig.add(new NumericValidationConfig(ParamsObj, lang));
			mapping.put(key, labelConfig);
			break;
		case Required:
			labelConfig.add(new RequiredValidationConfig(ParamsObj, lang));
			mapping.put(key, labelConfig);
			break;
		default:
			throw new ValidationNotSupportedException(TypeObj.getString());
		}

	}
}
