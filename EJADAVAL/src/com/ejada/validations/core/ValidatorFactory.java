package com.ejada.validations.core;

import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.complex.ValidationType;

public class ValidatorFactory {
	
	private static ArabicLanguageValidator arabicLanguageValidator;

	private synchronized static ArabicLanguageValidator getArabicLanguageValidator () {
		if(arabicLanguageValidator == null)
			arabicLanguageValidator = new ArabicLanguageValidator(new ArabicValidationConfig()) ;
		return arabicLanguageValidator ;
	}
	
	private static EnglishLanguageValidator EnglishLanguageValidator;
	
	private synchronized static EnglishLanguageValidator getEnglishLanguageValidator () {
		if(EnglishLanguageValidator == null)
			EnglishLanguageValidator = new EnglishLanguageValidator(new EnglishValidationConfig()) ;
		return EnglishLanguageValidator ;
	}
	
	private static DateValidator dateValidator;

	private synchronized static DateValidator getDateValidator () {
		if(dateValidator == null)
			dateValidator = new DateValidator(new DateValidationConfig()) ;
		return dateValidator ;
	}
	
	private static LengthValidator lengthValidator;

	private synchronized static LengthValidator getLengthValidator () {
		if(lengthValidator == null)
			lengthValidator = new LengthValidator() ;
		return lengthValidator ;
	}
	
	private static NumericValidator numericValidator;

	private synchronized static NumericValidator getNumericValidator () {
		if(numericValidator == null)
			numericValidator = new NumericValidator() ;
		return numericValidator ;
	}
	
	private static FloatValidator floatValidator;

	private synchronized static FloatValidator getFloatValidator () {
		if(floatValidator == null)
			floatValidator = new FloatValidator() ;
		return floatValidator ;
	}
	
	private static RequiredValidator requiredValidator;

	private synchronized static RequiredValidator getRequiredValidator () {
		if(requiredValidator == null)
			requiredValidator = new RequiredValidator() ;
		return requiredValidator ;
	}
	
	public static Validator getValidator(ValidationType type) {
		switch (type) {
			case ArabicLang:
				return getArabicLanguageValidator();
			case EnglishLang:
				return getEnglishLanguageValidator();
			case Date:
				return getDateValidator();
			case Float:
				return getFloatValidator();
			case Length:
				return getLengthValidator();
			case Number:
				return getNumericValidator();
			case Required:
				return getRequiredValidator();
		}
		return null;
	}
	
}