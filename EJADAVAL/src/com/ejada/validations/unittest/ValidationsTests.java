package com.ejada.validations.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ejada.validations.core.ValidatorFactory;
import com.ejada.validations.core.enums.LengthOperator;

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
	
	@Test
	void sanityLengthLessBad() {
		assertEquals(ValidatorFactory.getLengthValidator(LengthOperator.LESS,1).validate("Ahmed hamad").is_valid(), false);

	}
	
	@Test
	void sanityLengthLessGOOD() {
		assertEquals(ValidatorFactory.getLengthValidator(LengthOperator.LESS,50).validate("Ahmed hamad").is_valid(), true);

	}
	
	@Test
	void sanityLengthGreaterBad() {
		assertEquals(ValidatorFactory.getLengthValidator(LengthOperator.GREATER,1).validate("a").is_valid(), false);

	}
	
	@Test
	void sanityLengthGreaterGOOD() {
		assertEquals(ValidatorFactory.getLengthValidator(LengthOperator.GREATER,5).validate("Ahmed hamad").is_valid(), true);

	}
	
	@Test
	void sanityLengthEqualGOOD() {
		assertEquals(ValidatorFactory.getLengthValidator(LengthOperator.EQUAL,5).validate("Ahmed").is_valid(), true);

	}
	
	@Test
	void sanityLengthEqualBAD() {
		assertEquals(ValidatorFactory.getLengthValidator(LengthOperator.EQUAL,7).validate("Ahmed").is_valid(), false);

	}
	
	@Test
	void sanityNumericBad1() {
		assertEquals(ValidatorFactory.getNumericValidator().validate("Ahmed").is_valid(), false);

	}
	
	@Test
	void sanityNumericBad2() {
		assertEquals(ValidatorFactory.getNumericValidator().validate("12123909124.1230412309423409").is_valid(), false);

	}
	
	@Test
	void sanityNumericGood() {
		assertEquals(ValidatorFactory.getNumericValidator().validate("121239091241230412309423409").is_valid(), true);

	}
	
	@Test
	void sanityFloatGood1() {
		assertEquals(ValidatorFactory.getFloatValidator().validate("1.12").is_valid(), true);

	}
	
	@Test
	void sanityFloatGood2() {
		assertEquals(ValidatorFactory.getFloatValidator().validate("112").is_valid(), true);

	}
	
	@Test
	void sanityFloatBad() {
		assertEquals(ValidatorFactory.getFloatValidator().validate("112..98").is_valid(), false);
	}
	
	@Test
	void sanityRequiredBad1() {
		assertEquals(ValidatorFactory.getRequiredValidator().validate("null").is_valid(), false);
	}
	
	@Test
	void sanityRequiredBad2() {
		assertEquals(ValidatorFactory.getRequiredValidator().validate("Null").is_valid(), false);
	}
	
	@Test
	void sanityRequiredBad3() {
		assertEquals(ValidatorFactory.getRequiredValidator().validate("   ").is_valid(), false);
	}
	
	@Test
	void sanityRequiredBad4() {
		assertEquals(ValidatorFactory.getRequiredValidator().validate("{}").is_valid(), false);
	}
	
	@Test
	void sanityRequiredGood() {
		assertEquals(ValidatorFactory.getRequiredValidator().validate("{{id:\"123\"}}").is_valid(), true);
	}

}
