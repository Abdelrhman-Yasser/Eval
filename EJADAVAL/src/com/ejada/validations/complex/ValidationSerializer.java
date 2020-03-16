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
	 * Serialize JSON validations to List of validation sonfigurations.
	 *
	 * @param config the configuration
	 * 
	 * @return the hash map
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * 
	 */
	public static HashMap<String, ArrayList<ValidationConfig>> serializeValidations(JsonValidationConfig config)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		HashMap<String, ArrayList<ValidationConfig>> mapping = new HashMap<String, ArrayList<ValidationConfig>>();

		JsonObject configObject = (JsonObject) config.getParam(ParamType.Json).getValue();

		LangParam<?> lang = (LangParam<?>) config.getParam(ParamType.Language);

		dfs(configObject, lang, "", mapping);

		return mapping;
	}

	/**
	 * Traverse JSON tree to validate objects.
	 *
	 * @param validations the validations
	 * @param lang        the language
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

		/***********************************************************
		 * 
		 * Traverse JSON arrays to recurse on each item and
		 * 
		 * validate it separately
		 * 
		 ***********************************************************
		 */
		if (validations.getValueType().equals(ValueType.ARRAY)) {
			JsonArray list = (JsonArray) validations;
			for (JsonValue jsonValue : list) {
				dfs(jsonValue, lang, key, mapping);
			}
		}
		/***********************************************************
		 * 
		 * 	Traverse JSON objects to recurse on each simple item and
		 * 
		 * 	validate it separately.
		 * 
		 *	JSON-SCHEMA:
		 *
		 *	OBJ{
		 *		key:OBJ-KEY
		 *		childs:[OBJ],
		 *		validations:[VALOBJ],
		 *	}
		 *
		 *
		 ***********************************************************
		 */
		else if (validations.getValueType().equals(ValueType.OBJECT)) {

			JsonObject parent = (JsonObject) validations;

			// fetch field value
			JsonString keyObj = parent.getJsonString(ValidationKeyPointer);
			if (keyObj == null)
				throw new MissingParameterException(key + (!key.isEmpty() ? dot : "") + ValidationKeyPointer);

			// fetch validation list
			JsonValue validationList = parent.get(ValidationPointer);
			if (validationList == null)
				throw new MissingParameterException(key + (!key.isEmpty() ? dot : "") + ValidationPointer);

			// fetch children of node
			JsonArray valueObj = parent.getJsonArray(ValuePointer);
			if (valueObj == null)
				throw new MissingParameterException(key + (!key.isEmpty() ? dot : "") + ValuePointer);

			// build label of object like foo.bar.field
			String labelName = key + (!key.isEmpty() ? dot : "") + keyObj.getString();

			// build validation from list of JSON validations
			buildValidations(valueObj, lang, labelName, mapping);

			// recurse on children
			dfs(validationList, lang, labelName, mapping);
		}
	}

	/**
	 * Builds the validations from JSON array of validations.
	 *
	 * @param validations the array of validations
	 * @param lang        the language
	 * @param key         the key label
	 * @param mapping     the mapping of configurations
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
	 * Builds a validation from JSON validation object.
	 *
	 * @param validations the validations
	 * @param lang        the language
	 * @param key         the key label
	 * @param mapping     the mapping of configurations
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 */
	private static void buildValidation(JsonObject validations, LangParam<?> lang, String key,
			HashMap<String, ArrayList<ValidationConfig>> mapping)
			throws ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		/***********************************************************
		*	VALIDATION-JSON-SCHEMA:
		*
		*	VAL-OBJ{
		*		type:VAL-TYPE
		*		params:[list of key:value parameters],
		*	}
		*
		*	validation types supported:
		*	---------------------------
		*		"Required"
		*		"Number"
		*		"Float"
		*		"Length"
		*		"ArabicLang"
		*		"EnglishLang"
		*		"Date"
		*		"Email"
		*
		*
		*	keys-supported:
		*	---------------
		*		"Length" --> number of length to compare with
		*		"Operator" --> operator values:{"LESS THAN", "GREATER THAN" , "EQUAL"}
		*		"Language" --> { "EN" , "AR" }
		*		"DateFormat" --> like dd/MM/yyyy
		*		
		*   some validations don't require parameters as : 
		*  	 	"Required"
		*		"Number"
		*		"Float"
		*		"ArabicLang"
		*		"EnglishLang"
		*		"Email"
		*
		***********************************************************
		*/
		// fetch validation object
		JsonObject ParamsObj = validations.getJsonObject(ValidationParamPointer);
		if (ParamsObj == null)
			throw new MissingParameterException(key + dot + ValuePointer + dot + ValidationParamPointer);

		// fetch type of validation
		JsonString TypeObj = validations.getJsonString(ValidationTypePointer);
		if (TypeObj == null)
			throw new MissingParameterException(key + dot + ValuePointer + dot + ValidationTypePointer);

		// change string validation type to it's enum
		ValidationType type = ValidationType.getByCode(TypeObj.getString());

		// fetch list of validations to this specific key label
		ArrayList<ValidationConfig> labelConfig = mapping.getOrDefault(key, new ArrayList<ValidationConfig>());
		
		/***************************************************************
		 * 
		 * 
		 * Construct validation using JSON object of Validation
		 * 
		 * 
		 ***************************************************************
		 */
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
