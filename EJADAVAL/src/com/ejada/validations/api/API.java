package com.ejada.validations.api;

import com.appiancorp.suiteapi.expression.annotations.Category;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.complex.NumericValidationConfig;
import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.core.ArabicLanguageValidator;
import com.ejada.validations.core.DateValidator;
import com.ejada.validations.core.EnglishLanguageValidator;
import com.ejada.validations.core.FloatValidator;
import com.ejada.validations.core.LengthValidator;
import com.ejada.validations.core.NumericValidator;
import com.ejada.validations.core.RequiredValidator;
import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.result.ValidationResult;

public class API {

	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldLength(
			@Parameter String fieldName,
			@Parameter String field,
			@Parameter String operator,
			@Parameter Integer length) throws WrongOperatorException{
		
		if(Language.getByCode(operator) == null)
			throw new WrongOperatorException(operator);
		
		ValidationResult result = new LengthValidator(
				new LengthValidationConfig(
						length,
						LengthOperator.getByCode(operator),
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, fieldName);
		
		return result.is_valid() ;	
	}
	
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldEnglish(
			@Parameter String fieldName,
			@Parameter String field) throws WrongOperatorException{
		
		ValidationResult result = new EnglishLanguageValidator(
				new EnglishValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, fieldName);
		
		return result.is_valid() ;	
	}
	
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldArabic(
			@Parameter String fieldName,
			@Parameter String field) throws WrongOperatorException{
		
		ValidationResult result = new ArabicLanguageValidator(
				new ArabicValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, fieldName);
		
		return result.is_valid() ;	
	}
	
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldDate(
			@Parameter String fieldName,
			@Parameter String field) throws WrongOperatorException{
		
		ValidationResult result = new DateValidator(
				new DateValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, fieldName);
		
		return result.is_valid() ;	
	}
	
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldFloat(
			@Parameter String fieldName,
			@Parameter String field) throws WrongOperatorException{
		
		ValidationResult result = new FloatValidator(
				new FloatValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, fieldName);
		
		return result.is_valid() ;	
	}
	
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldNumeric(
			@Parameter String fieldName,
			@Parameter String field) throws WrongOperatorException{
		
		ValidationResult result = new NumericValidator(
				new NumericValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, fieldName);
		
		return result.is_valid() ;	
	}
	
	@Function
	@Category("category.name.TextFunctions")
	public Boolean validateFieldRequired(
			@Parameter String fieldName,
			@Parameter String field) throws WrongOperatorException{
		
		ValidationResult result = new RequiredValidator(
				new RequiredValidationConfig(
						Language.getByCode(Language.English.getValue())
						)
				).validate(field, fieldName);
		
		return result.is_valid() ;	
	}
	
	
}
