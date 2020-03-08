package com.ejada.validations.api;

import com.appiancorp.suiteapi.expression.annotations.Category;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.complex.EmailValidationConfig;
import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.complex.NumericValidationConfig;
import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.core.ArabicLanguageValidator;
import com.ejada.validations.core.DateValidator;
import com.ejada.validations.core.EmailValidator;
import com.ejada.validations.core.EnglishLanguageValidator;
import com.ejada.validations.core.FloatValidator;
import com.ejada.validations.core.LengthValidator;
import com.ejada.validations.core.NumericValidator;
import com.ejada.validations.core.RequiredValidator;
import com.ejada.validations.core.enums.LengthOperator;
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
	 * @param Field value to be validated
	 * @param Operator type must be ("LESS THAN","GREATER THAN","EQUAL")
	 * @param Length that will be used in comparing
	 * @return Validation result
	 * @throws WrongOperatorException the wrong operator exception
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldLength(
			@Parameter String field,
			@Parameter String operator,
			@Parameter Integer length) throws WrongOperatorException{
		
		if(LengthOperator.getByCode(operator) == null)
			throw new WrongOperatorException(operator);
		
		ValidationResult result = new LengthValidator(
				new LengthValidationConfig(
						length,
						LengthOperator.getByCode(operator),
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, "");
		
		return result.is_valid() ;	
	}
	
	/**
	 * This function validate a given text field is in English form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldEnglish(
			@Parameter String field){
		
		ValidationResult result = new EnglishLanguageValidator(
				new EnglishValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, "");
		
		return result.is_valid() ;	
	}
	
	/**
	 * This function validate a given text field is in Arabic form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldArabic(
			@Parameter String field) {
		
		ValidationResult result = new ArabicLanguageValidator(
				new ArabicValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, "");
		
		return result.is_valid() ;	
	}
	
	/**
	 * This function validate a given field is in date form.
	 *
	 * @param Field value to be validated
	 * @param Date format to validate on eg.(dd/MM/yyyy) all formats can be found in Appian datetext documentation
	 * @return Validation result
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldDate(
			@Parameter String field,
			@Parameter String dateFormat){
		
		ValidationResult result = new DateValidator(
				new DateValidationConfig(
						dateFormat,
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, "");
		
		return result.is_valid() ;	
	}
	
	/**
	 * This function validate a given text field is a decimal number.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldFloat(
			@Parameter String field){
		
		ValidationResult result = new FloatValidator(
				new FloatValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, "");
		
		return result.is_valid() ;	
	}
	
	/**
	 *This function validate a given text field is a whole number.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldNumeric(
			@Parameter String field){
		
		ValidationResult result = new NumericValidator(
				new NumericValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, "");
		
		return result.is_valid() ;	
	}
	
	/**
	 * This function validate a given text field is not empty or null.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldRequired(
			@Parameter String field){
		
		ValidationResult result = new RequiredValidator(
				new RequiredValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, "");
		
		return result.is_valid() ;	
	}
	
	/**
	 * This function validate a given text field is in valid email form.
	 *
	 * @param Field value to be validated
	 * @return Validation result
	 */
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldEmail(
			@Parameter String field){
		
		ValidationResult result = new EmailValidator(
				new EmailValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, "");
		
		return result.is_valid() ;	
	}
	
	
}
