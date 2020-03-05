package com.ejada.validations.core;

import com.ejada.validations.complex.ValidationType;

public class ValidatorFactory {
	
	private static ArabicLanguageValidator arabicLanguageValidator;

	private synchronized static ArabicLanguageValidator getArabicLanguageValidator () {
		if(arabicLanguageValidator == null)
			arabicLanguageValidator = new ArabicLanguageValidator() ;
		return arabicLanguageValidator ;
	}
	
	private static EnglishLanguageValidator EnglishLanguageValidator;
	
	private synchronized static EnglishLanguageValidator getEnglishLanguageValidator () {
		if(EnglishLanguageValidator == null)
			EnglishLanguageValidator = new EnglishLanguageValidator() ;
		return EnglishLanguageValidator ;
	}
	
	private static DateValidator dateValidator;

	private synchronized static DateValidator getDateValidator () {
		if(dateValidator == null)
			dateValidator = new DateValidator() ;
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
	
	private static EmailValidator emailValidator;
	
	private synchronized static EmailValidator getEmailValidator () {
		if(emailValidator == null)
			emailValidator = new EmailValidator() ;
		return emailValidator ;
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
			case Email:
				return getEmailValidator();
		}
		return null;
	}
	
}