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
import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.complex.EmailValidationConfig;
import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.complex.JsonValidationConfig;
import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.complex.NumericValidationConfig;
import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.core.ArabicLanguageValidator;
import com.ejada.validations.core.DateValidator;
import com.ejada.validations.core.EmailValidator;
import com.ejada.validations.core.EnglishLanguageValidator;
import com.ejada.validations.core.FloatValidator;
import com.ejada.validations.core.JsonValidator;
import com.ejada.validations.core.LengthValidator;
import com.ejada.validations.core.NumericValidator;
import com.ejada.validations.core.RequiredValidator;
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
	 * @throws WrongOperatorException   the wrong operator exception
	 * @throws ValidationConfigNotFound
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldLength(@Parameter String field, @Parameter String operator, @Parameter Integer length)
			throws WrongOperatorException, ValidationConfigNotFound {

		if (LengthOperator.getByCode(operator) == null)
			throw new WrongOperatorException(operator);

		ValidationResult result = new LengthValidator(new LengthValidationConfig(length,
				LengthOperator.getByCode(operator), Language.getByCode(Language.English.getValue()))).validate(field,
						"");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is in English form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldEnglish(@Parameter String field) throws ValidationConfigNotFound {

		ValidationResult result = new EnglishLanguageValidator(
				new EnglishValidationConfig(Language.getByCode(Language.English.getValue()))).validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is in Arabic form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 * @throws s
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldArabic(@Parameter String field) throws ValidationConfigNotFound {

		ValidationResult result = new ArabicLanguageValidator(
				new ArabicValidationConfig(Language.getByCode(Language.English.getValue()))).validate(field, "");

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
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldDate(@Parameter String field, @Parameter String dateFormat)
			throws ValidationConfigNotFound {

		ValidationResult result = new DateValidator(
				new DateValidationConfig(dateFormat, Language.getByCode(Language.English.getValue()))).validate(field,
						"");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is a decimal number.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldFloat(@Parameter String field) throws ValidationConfigNotFound {

		ValidationResult result = new FloatValidator(
				new FloatValidationConfig(Language.getByCode(Language.English.getValue()))).validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is a whole number.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldNumeric(@Parameter String field) throws ValidationConfigNotFound {

		ValidationResult result = new NumericValidator(
				new NumericValidationConfig(Language.getByCode(Language.English.getValue()))).validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is not empty or null.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldRequired(@Parameter String field) throws ValidationConfigNotFound {

		ValidationResult result = new RequiredValidator(
				new RequiredValidationConfig(Language.getByCode(Language.English.getValue()))).validate(field, "");

		return result.is_valid();
	}

	/**
	 * This function validate a given text field is in valid email form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 * @throws ValidationConfigNotFound
	 * 
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldEmail(@Parameter String field) throws ValidationConfigNotFound {

		ValidationResult result = new EmailValidator(
				new EmailValidationConfig(Language.getByCode(Language.English.getValue()))).validate(field, "");

		return result.is_valid();
	}

	/**
	 * Validate json object.
	 *
	 * @param sc         the service content of Appian
	 * @param objJson    the json object to be valdiated
	 * @param configJson the validation configuration json
	 * @param language   the language of results returned
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
	public String[] validateJsonObject(ContentService sc, @Parameter String objJson, @Parameter long configJson,
			@Parameter String language) throws ValidationConfigNotFound, NotValidJson, ValidationNotSupportedException,
			MissingParameterException, WrongOperatorException, NotSupportedLanguage, URISyntaxException {

		if (Language.getByCode(language) == null)
			throw new NotSupportedLanguage(language);

		JsonObject config;
		try {
			Document[] configJsonFile = sc.download(configJson, ContentConstants.VERSION_CURRENT, false);
			config = Json.createReader(new FileInputStream(new File(configJsonFile[0].getInternalFilename())))
					.readObject();
		} catch (FileNotFoundException | InvalidContentException | InvalidVersionException | PrivilegeException e) {
			throw new ValidationConfigNotFound();
		} catch (JsonParsingException e) {
			throw new NotValidJson();
		}

		JsonValidationConfig valConfig = new JsonValidationConfig(config, Language.getByCode(language));

		JsonValidator validator = ValidatorFactory.getJsonValidator();

		validator.setConfig(valConfig);

		ArrayList<ValidationResult> valResults = validator.validate(objJson);

		Set<String> unique = new HashSet<String>();
		for (int i = 0; i < valResults.size(); i++) {
			unique.add(valResults.get(i).toString());
		}

		String[] results = unique.toArray(new String[0]);
		Arrays.sort(results, Collections.reverseOrder());

		return results;
	}

}
