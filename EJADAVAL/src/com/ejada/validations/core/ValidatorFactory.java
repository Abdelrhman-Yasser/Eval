package com.ejada.validations.core;

import com.ejada.validations.core.enums.LengthOperator;

public class ValidatorFactory {
	
	private static ArabicLanguageValidator arabicLanguageValidator;

	public synchronized static ArabicLanguageValidator getArabicLanguageValidator () {
		if(arabicLanguageValidator == null)
			arabicLanguageValidator = new ArabicLanguageValidator() ;
		return arabicLanguageValidator ;
	}
	
	private static EnglishLanguageValidator EnglishLanguageValidator;

	public synchronized static EnglishLanguageValidator getEnglishLanguageValidator () {
		if(EnglishLanguageValidator == null)
			EnglishLanguageValidator = new EnglishLanguageValidator() ;
		return EnglishLanguageValidator ;
	}
	
	private static DateValidator dateValidator;

	public synchronized static DateValidator getDateValidator () {
		if(dateValidator == null)
			dateValidator = new DateValidator() ;
		return dateValidator ;
	}
	
	private static LengthValidator lengthValidator;

	public synchronized static LengthValidator getLengthValidator (LengthOperator op, int length) {
		if(lengthValidator == null)
			lengthValidator = new LengthValidator(op, length) ;
		else {
			lengthValidator.setLength(length);
			lengthValidator.setOperator(op);
		}
		return lengthValidator ;
	}
	
	private static NumericValidator numericValidator;

	public synchronized static NumericValidator getNumericValidator () {
		if(numericValidator == null)
			numericValidator = new NumericValidator() ;
		return numericValidator ;
	}
}