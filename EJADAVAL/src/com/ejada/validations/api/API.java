package com.ejada.validations.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParsingException;

import com.appiancorp.suiteapi.common.exceptions.InvalidVersionException;
import com.appiancorp.suiteapi.common.exceptions.PrivilegeException;
import com.appiancorp.suiteapi.content.ContentConstants;
import com.appiancorp.suiteapi.content.ContentService;
import com.appiancorp.suiteapi.content.exceptions.InvalidContentException;
import com.appiancorp.suiteapi.expression.annotations.Category;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.appiancorp.suiteapi.knowledge.Document;
import com.appiancorp.suiteapi.type.TypedValue;
import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.complex.EmailValidationConfig;
import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.complex.JsonValidationConfig;
import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.complex.NumericValidationConfig;
import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.complex.ValidationType;
import com.ejada.validations.core.JsonValidator;
import com.ejada.validations.core.Validator;
import com.ejada.validations.core.ValidatorFactory;
import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.exceptions.NotSupportedLanguage;
import com.ejada.validations.exceptions.NotValidJson;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.exceptions.ValidationNotSupportedException;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class API.
 */
public class API {

	/**
	 * This function validate length of a given text field.
	 *
	 * @param Field    value to be validated
	 * @param Operator type must be ("LESS THAN","GREATER THAN","EQUAL")
	 * @param Length   that will be used in comparing
	 * @return Validation result
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws ValidationConfigNotFound
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldLength(@Parameter String field, @Parameter String operator, @Parameter Integer length)
			throws WrongOperatorException, ValidationConfigNotFound, ValidationNotSupportedException,
			MissingParameterException {

		if (LengthOperator.getByCode(operator) == null)
			throw new WrongOperatorException(operator);

		Validator validator = ValidatorFactory.getValidator(ValidationType.Length);

		validator.setConfig(new LengthValidationConfig(length, LengthOperator.getByCode(operator),
				Language.getByCode(Language.English.getValue())));

		ValidationResult result = validator.validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is in English form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldEnglish(@Parameter String field) throws ValidationConfigNotFound,
			ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		Validator validator = ValidatorFactory.getValidator(ValidationType.EnglishLang);

		validator.setConfig(new EnglishValidationConfig(Language.getByCode(Language.English.getValue())));

		ValidationResult result = validator.validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is in Arabic form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 * @throws s
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldArabic(@Parameter String field) throws ValidationConfigNotFound,
			ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		Validator validator = ValidatorFactory.getValidator(ValidationType.ArabicLang);

		validator.setConfig(new ArabicValidationConfig(Language.getByCode(Language.English.getValue())));

		ValidationResult result = validator.validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given field is in date form.
	 *
	 * @param Field value to be validated
	 * @param Date  format to validate on eg.(dd/MM/yyyy) all formats can be found
	 *              in Appian datetext documentation
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldDate(@Parameter String field, @Parameter String dateFormat)
			throws ValidationConfigNotFound, ValidationNotSupportedException, MissingParameterException,
			WrongOperatorException {

		Validator validator = ValidatorFactory.getValidator(ValidationType.Date);

		validator.setConfig(new DateValidationConfig(dateFormat, Language.getByCode(Language.English.getValue())));

		ValidationResult result = validator.validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is a decimal number.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldFloat(@Parameter String field) throws ValidationConfigNotFound,
			ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		Validator validator = ValidatorFactory.getValidator(ValidationType.Float);

		validator.setConfig(new FloatValidationConfig(Language.getByCode(Language.English.getValue())));

		ValidationResult result = validator.validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is a whole number.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldNumeric(@Parameter String field) throws ValidationConfigNotFound,
			ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		Validator validator = ValidatorFactory.getValidator(ValidationType.Number);

		validator.setConfig(new NumericValidationConfig(Language.getByCode(Language.English.getValue())));

		ValidationResult result = validator.validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is not empty or null.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldRequired(@Parameter String field) throws ValidationConfigNotFound,
			ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		Validator validator = ValidatorFactory.getValidator(ValidationType.Required);

		validator.setConfig(new RequiredValidationConfig(Language.getByCode(Language.English.getValue())));

		ValidationResult result = validator.validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is in valid email form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFoundSS
	 * @throws WrongOperatorException
	 * @throws MissingParameterException
	 * @throws ValidationNotSupportedException
	 * 
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldEmail(@Parameter String field) throws ValidationConfigNotFound,
			ValidationNotSupportedException, MissingParameterException, WrongOperatorException {

		Validator validator = ValidatorFactory.getValidator(ValidationType.Email);

		validator.setConfig(new EmailValidationConfig(Language.getByCode(Language.English.getValue())));

		ValidationResult result = validator.validate(field, "");

		return result.is_valid();
	}

	/**
	 * Validate json object.
	 *
	 * @param sc               the service content of Appian
	 * @param objJson          the json object to be valdiated
	 * @param configJson       the validation configuration document
	 * @param languageDocument the language bundle of results returned
	 * @return the string[]
	 * @throws ValidationConfigNotFound        the validation config not found
	 * @throws NotValidJson                    the not valid json
	 * @throws ValidationNotSupportedException the validation not supported
	 *                                         exception
	 * @throws MissingParameterException       the missing parameter exception
	 * @throws WrongOperatorException          the wrong operator exception
	 * @throws NotSupportedLanguage            the not supported language
	 * @throws URISyntaxException
	 */
	@Function
	@Category("category.name.TextFunctions")
	public String[] validateJsonObject(ContentService sc, @Parameter String objJson, @Parameter TypedValue configJson,
			@Parameter(required = false) TypedValue languageDocument)
			throws ValidationConfigNotFound, NotValidJson, ValidationNotSupportedException, MissingParameterException,
			WrongOperatorException, NotSupportedLanguage, URISyntaxException {

		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * 														   *			
		 * Parsing APPIAN inputs to Java Objects				   *
		 * 														   *
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 */
		JsonObject config;
		try {
			// Use APPIAN content service to fetch file from APPIAN  
			Document[] configJsonFile = sc.download((Long) configJson.getValue(), ContentConstants.VERSION_CURRENT,
					false);
			// Convert JSON file into json object 
			config = Json.createReader(new FileInputStream(new File(configJsonFile[0].getInternalFilename())))
					.readObject();
		} catch (FileNotFoundException | InvalidContentException | InvalidVersionException | PrivilegeException e) {
			// file not fount at APPIAN
			throw new ValidationConfigNotFound();
		} catch (JsonParsingException e) {
			// JSON file has incorrect format
			throw new NotValidJson();
		}

		/*******
		 * 
		 * trying to fetch translation file if it's sent from APPIAN otherwise 
		 * English will be used to populate error messages 
		 * 
		 * ******/
		File optionalTranslationFile = null;
		if (languageDocument != null) {
			try {
				// fetch translation bundle file from APPIAN
				Document[] trFile = sc.download((Long) languageDocument.getValue(), ContentConstants.VERSION_CURRENT,
						false);
				optionalTranslationFile = new File(trFile[0].getInternalFilename());
			} catch (PrivilegeException | InvalidContentException | InvalidVersionException e) {
				// translation file is passed but couldn't be found
				throw new ValidationConfigNotFound("Translation File");
			}
		}
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * 														     *			
		 * Building validators and set configuration for validations *
		 * 														     *
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 */
		JsonValidationConfig valConfig = new JsonValidationConfig(config, optionalTranslationFile);
		JsonValidator validator = ValidatorFactory.getJsonValidator();
		validator.setConfig(valConfig);
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * 														     *			
		 * validate JSON object using validators					 *
		 * 														     *
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 */
		ArrayList<ValidationResult> valResults = validator.validate(objJson);

		Set<String> unique = new HashSet<String>();
		for (int i = 0; i < valResults.size(); i++) {
			String str = valResults.get(i).toString() ;
			if(str != null)
				unique.add(str);
		}

		String[] results = unique.toArray(new String[0]);
		Arrays.sort(results, Collections.reverseOrder());
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		
		return results;
	}

}
