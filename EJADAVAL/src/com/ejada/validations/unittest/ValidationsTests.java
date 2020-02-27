package com.ejada.validations.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ejada.validations.core.ValidatorFactory;

class ValidationsTests {
	
	@Test
	void sanityArabic1() {
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate("احمد").is_valid(), true);
		
	}
	
	@Test
	void sanityArabic2() {
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate("اح1123مد").is_valid(), false);
	}
	
	@Test
	void sanityArabic3() {
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate("احمد  hamad").is_valid(),  false);
	}
	
	@Test
	void sanityArabic4() {
		assertEquals(ValidatorFactory.getArabicLanguageValidator().validate(" ").is_valid(),  true);

	}
	
	@Test
	void sanityEnglish1() {
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("اح1123مد").is_valid(), false);

	}
	
	@Test
	void sanityEnglish2() {
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("احمد").is_valid(), false);

	}
	
	@Test
	void sanityEnglish3() {
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("اح1123مد").is_valid(), false);

	}
	
	@Test
	void sanityEnglish4() {
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("احمد  حامد").is_valid(),  false);

	}
	
	@Test
	void sanityEnglish5() {
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate("احمد  hamad").is_valid(),  false);

	}
	
	@Test
	void sanityEnglish6() {
		assertEquals(ValidatorFactory.getEnglishLanguageValidator().validate(" ").is_valid(),  true);

	}
	
	@Test
	void sanityDate1() {
		assertEquals(ValidatorFactory.getDateValidator().validate("32/02/2012").is_valid(), false);
	}
	
	@Test
	void sanityDate2() {
		assertEquals(ValidatorFactory.getDateValidator().validate("31/20/2012").is_valid(), false);
	}
	
	@Test
	void sanityDate3() {
		assertEquals(ValidatorFactory.getDateValidator().validate("31/20/19991").is_valid(), false);
	}
	
	@Test
	void sanityDate4() {
		assertEquals(ValidatorFactory.getDateValidator().validate("2012/02/20").is_valid(), false);
	}
	
	@Test
	void sanityDate5() {
		assertEquals(ValidatorFactory.getDateValidator().validate("28/02/2011").is_valid(), true);
	}
	
	@Test
	void sanityDate6() {
		assertEquals(ValidatorFactory.getDateValidator().validate("31/01/2012").is_valid(), true);
	}
	
	@Test
	void sanityDate7() {
		assertEquals(ValidatorFactory.getDateValidator().validate("30/04/2012").is_valid(), true);
	}
	
	@Test
	void sanityDate8() {
		assertEquals(ValidatorFactory.getDateValidator().validate("Ahmed hamad").is_valid(), false);

	}
	

}
