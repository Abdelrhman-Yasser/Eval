package com.ejada.validations.core;

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
}