package com.ejada.validations.unittest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.complex.ComplexValidator;
import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.complex.NumericValidationConfig;
import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.complex.ValidationConfig;
import com.ejada.validations.complex.ValidationType;
import com.ejada.validations.core.ArabicLanguageValidator;
import com.ejada.validations.core.DateValidator;
import com.ejada.validations.core.EnglishLanguageValidator;
import com.ejada.validations.core.FloatValidator;
import com.ejada.validations.core.LengthValidator;
import com.ejada.validations.core.NumericValidator;
import com.ejada.validations.core.RequiredValidator;
import com.ejada.validations.core.ValidatorFactory;
import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.result.ValidationResult;

class ValidationsTests {
	
	@Test
	void sanityArabic1() {
		ArabicLanguageValidator val = (ArabicLanguageValidator) ValidatorFactory.getValidator(ValidationType.ArabicLang) ;
		val.setConfig(new ArabicValidationConfig());
		assertEquals(val.validate("احمد","test").is_valid(), true);
	}
	
	@Test
	void sanityArabic2() {
		ArabicLanguageValidator val = (ArabicLanguageValidator) ValidatorFactory.getValidator(ValidationType.ArabicLang) ;
		val.setConfig(new ArabicValidationConfig());
		assertEquals(val.validate("اح1123مد","test").is_valid(), false);
	}
	
	@Test
	void sanityArabic3() {
		ArabicLanguageValidator val = (ArabicLanguageValidator) ValidatorFactory.getValidator(ValidationType.ArabicLang) ;
		val.setConfig(new ArabicValidationConfig());
		assertEquals(val.validate("احمد  hamad","test").is_valid(),  false);
	}
	
	@Test
	void sanityArabic4() {
		ArabicLanguageValidator val = (ArabicLanguageValidator) ValidatorFactory.getValidator(ValidationType.ArabicLang) ;
		val.setConfig(new ArabicValidationConfig());
		assertEquals(val.validate(" ","test").is_valid(),  true);
	}
	
	@Test
	void sanityEnglish1() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory.getValidator(ValidationType.EnglishLang) ;
		val.setConfig(new EnglishValidationConfig());
		assertEquals(val.validate("اح1123مد","test").is_valid(), false);
	}
	
	@Test
	void sanityEnglish2() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory.getValidator(ValidationType.EnglishLang) ;
		val.setConfig(new EnglishValidationConfig());
		assertEquals(val.validate("احمد","test").is_valid(), false);
	}
	
	@Test
	void sanityEnglish3() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory.getValidator(ValidationType.EnglishLang) ;
		val.setConfig(new EnglishValidationConfig());
		assertEquals(val.validate("اح1123مد","test").is_valid(), false);
	}
	
	@Test
	void sanityEnglish4() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory.getValidator(ValidationType.EnglishLang) ;
		val.setConfig(new EnglishValidationConfig());
		assertEquals(val.validate("احمد  حامد","test").is_valid(),  false);
	}
	
	@Test
	void sanityEnglish5() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory.getValidator(ValidationType.EnglishLang) ;
		val.setConfig(new EnglishValidationConfig());
		assertEquals(val.validate("احمد  hamad","test").is_valid(),  false);
	}
	
	@Test
	void sanityEnglish6() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory.getValidator(ValidationType.EnglishLang) ;
		val.setConfig(new EnglishValidationConfig());
		assertEquals(val.validate(" ","test").is_valid(),  true);
	}
	
	@Test
	void sanityDate1() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date) ;
		val.setConfig(new DateValidationConfig());
		assertEquals(val.validate("32/02/2012","test").is_valid(), false);
	}
	
	@Test
	void sanityDate2() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date) ;
		val.setConfig(new DateValidationConfig());
		assertEquals(val.validate("31/20/2012","test").is_valid(), false);
	}
	
	@Test
	void sanityDate3() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date) ;
		val.setConfig(new DateValidationConfig());
		assertEquals(val.validate("31/20/19991","test").is_valid(), false);
	}
	
	@Test
	void sanityDate4() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date) ;
		val.setConfig(new DateValidationConfig());
		assertEquals(val.validate("2012/02/20","test").is_valid(), false);
	}
	
	@Test
	void sanityDate5() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date) ;
		val.setConfig(new DateValidationConfig());
		assertEquals(val.validate("28/02/2011","test").is_valid(), true);
	}
	
	@Test
	void sanityDate6() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date) ;
		val.setConfig(new DateValidationConfig());
		assertEquals(val.validate("31/01/2012","test").is_valid(), true);
	}
	
	@Test
	void sanityDate7() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date) ;
		val.setConfig(new DateValidationConfig());
		assertEquals(val.validate("30/04/2012","test").is_valid(), true);
	}
	
	@Test
	void sanityDate8() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date) ;
		val.setConfig(new DateValidationConfig());
		assertEquals(val.validate("Ahmed hamad","test").is_valid(), false);
	}
	
	@Test
	void sanityLengthLessBad() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length) ;
		val.setConfig(new LengthValidationConfig(1,LengthOperator.LESS));
		assertEquals(val.validate("Ahmed hamad","test").is_valid(), false);

	}
	
	@Test
	void sanityLengthLessGOOD() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length) ;
		val.setConfig(new LengthValidationConfig(50,LengthOperator.LESS));
		assertEquals(val.validate("Ahmed hamad","test").is_valid(), true);
	}
	
	@Test
	void sanityLengthGreaterBad() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length) ;
		val.setConfig(new LengthValidationConfig(1,LengthOperator.GREATER));
		assertEquals(val.validate("a","test").is_valid(), false);
	}
	
	@Test
	void sanityLengthGreaterGOOD() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length) ;
		val.setConfig(new LengthValidationConfig(5,LengthOperator.GREATER));
		assertEquals(val.validate("Ahmed hamad","test").is_valid(), true);

	}
	
	@Test
	void sanityLengthEqualGOOD() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length) ;
		val.setConfig(new LengthValidationConfig(5,LengthOperator.EQUAL));
		assertEquals(val.validate("Ahmed","test").is_valid(), true);
	}
	
	@Test
	void sanityLengthEqualBAD() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length) ;
		val.setConfig(new LengthValidationConfig(7,LengthOperator.EQUAL));		
		assertEquals(val.validate("Ahmed","test").is_valid(), false);
	}
	
	@Test
	void sanityNumericBad1() {
		NumericValidator val = (NumericValidator) ValidatorFactory.getValidator(ValidationType.Number) ;
		val.setConfig(new NumericValidationConfig());
		assertEquals(val.validate("Ahmed","test").is_valid(), false);
	}
	
	@Test
	void sanityNumericBad2() {
		NumericValidator val = (NumericValidator) ValidatorFactory.getValidator(ValidationType.Number) ;
		val.setConfig(new NumericValidationConfig());
		assertEquals(val.validate("12123909124.1230412309423409","test").is_valid(), false);

	}
	
	@Test
	void sanityNumericGood() {
		NumericValidator val = (NumericValidator) ValidatorFactory.getValidator(ValidationType.Number) ;
		val.setConfig(new NumericValidationConfig());
		assertEquals(val.validate("121239091241230412309423409","test").is_valid(), true);

	}
	
	@Test
	void sanityFloatGood1() {
		FloatValidator val = (FloatValidator) ValidatorFactory.getValidator(ValidationType.Float) ;
		val.setConfig(new FloatValidationConfig());
		assertEquals(val.validate("1.12","test").is_valid(), true);

	}
	
	@Test
	void sanityFloatGood2() {
		FloatValidator val = (FloatValidator) ValidatorFactory.getValidator(ValidationType.Float) ;
		val.setConfig(new FloatValidationConfig());
		assertEquals(val.validate("112","test").is_valid(), true);

	}
	
	@Test
	void sanityFloatBad() {
		FloatValidator val = (FloatValidator) ValidatorFactory.getValidator(ValidationType.Float) ;
		val.setConfig(new FloatValidationConfig());
		assertEquals(val.validate("112..98","test").is_valid(), false);
	}
	
	@Test
	void sanityRequiredBad1() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required) ;
		val.setConfig(new RequiredValidationConfig());
		assertEquals(val.validate("null","test").is_valid(), false);
	}
	
	@Test
	void sanityRequiredBad2() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required) ;
		val.setConfig(new RequiredValidationConfig());
		assertEquals(val.validate("Null","test").is_valid(), false);
	}
	
	@Test
	void sanityRequiredBad3() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required) ;
		val.setConfig(new RequiredValidationConfig());
		assertEquals(val.validate("   ","test").is_valid(), false);
	}
	
	@Test
	void sanityRequiredBad4() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required) ;
		val.setConfig(new RequiredValidationConfig());
		assertEquals(val.validate("{}","test").is_valid(), false);
	}
	
	@Test
	void sanityRequiredGood() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required) ;
		val.setConfig(new RequiredValidationConfig());
		assertEquals(val.validate("{{id:\"123\"}}","test").is_valid(), true);
	}
	
	@Test
	void sanityComplex1() {
		ArrayList<ValidationConfig> confgs = new ArrayList<ValidationConfig>() ;
		confgs.add(new RequiredValidationConfig());
		confgs.add(new ArabicValidationConfig());
		confgs.add(new LengthValidationConfig(10, LengthOperator.GREATER));
		ComplexValidator val = new ComplexValidator();
		ArrayList<ValidationResult> results = val.validate(" ","test", confgs);
		assertFalse(results.get(0).is_valid());
		assertTrue(results.get(1).is_valid());
		assertFalse(results.get(2).is_valid());
	}
	
	@Test
	void sanityComplex2() {
		ArrayList<ValidationConfig> confgs = new ArrayList<ValidationConfig>() ;
		confgs.add(new RequiredValidationConfig());
		confgs.add(new ArabicValidationConfig());
		confgs.add(new LengthValidationConfig(10, LengthOperator.GREATER));
		ComplexValidator val = new ComplexValidator();
		ArrayList<ValidationResult> results = val.validate("Ahmedkhaled","test", confgs);
		assertTrue(results.get(0).is_valid());
		assertFalse(results.get(1).is_valid());
		assertTrue(results.get(2).is_valid());
	}
	
	@Test
	void sanityComplex3() {
		ArrayList<ValidationConfig> confgs = new ArrayList<ValidationConfig>() ;
		confgs.add(new RequiredValidationConfig());
		confgs.add(new ArabicValidationConfig());
		confgs.add(new LengthValidationConfig(10, LengthOperator.GREATER));
		ComplexValidator val = new ComplexValidator();
		ArrayList<ValidationResult> results = val.validate("احمد حامد","test", confgs);
		assertTrue(results.get(0).is_valid());
		assertTrue(results.get(1).is_valid());
		assertFalse(results.get(2).is_valid());
	}

}
