package com.ejada.validations.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ejada.validations.core.ValidatorFactory;

class ValidationsTests {
	
	@Test
	void sanityArabic() {
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate("احمد").is_valid(), true);
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate("اح1123مد").is_valid(), false);
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate("احمد  حامد").is_valid(),  true);
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate("احمد  hamad").is_valid(),  false);
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate(" ").is_valid(),  true);
	}


	@Test
	void sanityEnglish() {
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("Ahmed hamad").is_valid(), true);
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("اح1123مد").is_valid(), false);
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("احمد").is_valid(), false);
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("اح1123مد").is_valid(), false);
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("احمد  حامد").is_valid(),  false);
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("احمد  hamad").is_valid(),  false);
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate(" ").is_valid(),  true);
	}

}
