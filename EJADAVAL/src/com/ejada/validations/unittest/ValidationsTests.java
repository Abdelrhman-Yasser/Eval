package com.ejada.validations.unittest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonObject;

import org.junit.jupiter.api.Test;

import com.ejada.validations.api.API;
import com.ejada.validations.complex.ArabicValidationConfig;
import com.ejada.validations.complex.ComplexValidator;
import com.ejada.validations.complex.DateValidationConfig;
import com.ejada.validations.complex.EmailValidationConfig;
import com.ejada.validations.complex.EnglishValidationConfig;
import com.ejada.validations.complex.FloatValidationConfig;
import com.ejada.validations.complex.LengthValidationConfig;
import com.ejada.validations.complex.NumericValidationConfig;
import com.ejada.validations.complex.RequiredValidationConfig;
import com.ejada.validations.complex.ValidationConfig;
import com.ejada.validations.complex.ValidationSerializer;
import com.ejada.validations.complex.ValidationType;
import com.ejada.validations.core.ArabicLanguageValidator;
import com.ejada.validations.core.DateValidator;
import com.ejada.validations.core.EmailValidator;
import com.ejada.validations.core.EnglishLanguageValidator;
import com.ejada.validations.core.FloatValidator;
import com.ejada.validations.core.LengthValidator;
import com.ejada.validations.core.NumericValidator;
import com.ejada.validations.core.RequiredValidator;
import com.ejada.validations.core.ValidatorFactory;
import com.ejada.validations.core.enums.LengthOperator;
import com.ejada.validations.exceptions.MissingParameterException;
import com.ejada.validations.exceptions.ValidationNotSupportedException;
import com.ejada.validations.exceptions.WrongOperatorException;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.nationalization.Nationalization;
import com.ejada.validations.result.ValidationResult;

/**
 * The Class ValidationsTests.
 */
class ValidationsTests {

	/**
	 * Sanity arabic 1.
	 */
	@Test
	void sanityArabic1() {
		ArabicLanguageValidator val = (ArabicLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.ArabicLang);
		val.setConfig(new ArabicValidationConfig(Language.English));
		assertEquals(val.validate("احمد", "test").is_valid(), true);
	}

	/**
	 * 
	 * Sanity arabic 2.
	 * 
	 */
	@Test
	void sanityArabic2() {
		ArabicLanguageValidator val = (ArabicLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.ArabicLang);
		val.setConfig(new ArabicValidationConfig(Language.English));
		assertEquals(val.validate("اح1123مد", "test").is_valid(), false);
	}

	/**
	 * 
	 * Sanity arabic 3.
	 * 
	 */
	@Test
	void sanityArabic3() {
		ArabicLanguageValidator val = (ArabicLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.ArabicLang);
		val.setConfig(new ArabicValidationConfig(Language.English));
		assertEquals(val.validate("احمد  hamad", "test").is_valid(), false);
	}

	/**
	 * Sanity arabic 4.
	 */
	@Test
	void sanityArabic4() {
		ArabicLanguageValidator val = (ArabicLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.ArabicLang);
		val.setConfig(new ArabicValidationConfig(Language.English));
		assertEquals(val.validate(" ", "test").is_valid(), true);
	}

	/**
	 * Sanity english 1.
	 */
	@Test
	void sanityEnglish1() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.EnglishLang);
		val.setConfig(new EnglishValidationConfig(Language.English));
		assertEquals(val.validate("اح1123مد", "test").is_valid(), false);
	}

	/**
	 * Sanity english 2.
	 */
	@Test
	void sanityEnglish2() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.EnglishLang);
		val.setConfig(new EnglishValidationConfig(Language.English));
		assertEquals(val.validate("احمد", "test").is_valid(), false);
	}

	/**
	 * Sanity english 3.
	 */
	@Test
	void sanityEnglish3() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.EnglishLang);
		val.setConfig(new EnglishValidationConfig(Language.English));
		assertEquals(val.validate("اح1123مد", "test").is_valid(), false);
	}

	/**
	 * Sanity english 4.
	 */
	@Test
	void sanityEnglish4() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.EnglishLang);
		val.setConfig(new EnglishValidationConfig(Language.English));
		assertEquals(val.validate("احمد  حامد", "test").is_valid(), false);
	}

	/**
	 * Sanity english 5.
	 */
	@Test
	void sanityEnglish5() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.EnglishLang);
		val.setConfig(new EnglishValidationConfig(Language.English));
		assertEquals(val.validate("احمد  hamad", "test").is_valid(), false);
	}

	/**
	 * Sanity english 6.
	 */
	@Test
	void sanityEnglish6() {
		EnglishLanguageValidator val = (EnglishLanguageValidator) ValidatorFactory
				.getValidator(ValidationType.EnglishLang);
		val.setConfig(new EnglishValidationConfig(Language.English));
		assertEquals(val.validate(" ", "test").is_valid(), true);
	}

	/**
	 * Sanity date 1.
	 */
	@Test
	void sanityDate1() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date);
		val.setConfig(new DateValidationConfig("dd/MM/yyyy", Language.English));
		assertEquals(val.validate("32/02/2012", "test").is_valid(), false);
	}

	/**
	 * Sanity date 2.
	 */
	@Test
	void sanityDate2() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date);
		val.setConfig(new DateValidationConfig("dd/MM/yyyy", Language.English));
		assertEquals(val.validate("31/20/2012", "test").is_valid(), false);
	}

	/**
	 * Sanity date 3.
	 */
	@Test
	void sanityDate3() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date);
		val.setConfig(new DateValidationConfig("dd/MM/yyyy", Language.English));
		assertEquals(val.validate("31/20/19991", "test").is_valid(), false);
	}

	/**
	 * Sanity date 4.
	 */
	@Test
	void sanityDate4() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date);
		val.setConfig(new DateValidationConfig("dd/MM/yyyy", Language.English));
		assertEquals(val.validate("2012/02/20", "test").is_valid(), false);
	}

	/**
	 * Sanity date 5.
	 */
	@Test
	void sanityDate5() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date);
		val.setConfig(new DateValidationConfig("dd/MM/yyyy", Language.English));
		assertEquals(val.validate("28/02/2011", "test").is_valid(), true);
	}

	/**
	 * Sanity date 6.
	 */
	@Test
	void sanityDate6() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date);
		val.setConfig(new DateValidationConfig("dd/MM/yyyy", Language.English));
		assertEquals(val.validate("31/01/2012", "test").is_valid(), true);
	}

	/**
	 * Sanity date 7.
	 */
	@Test
	void sanityDate7() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date);
		val.setConfig(new DateValidationConfig("dd/MM/yyyy", Language.English));
		assertEquals(val.validate("30/04/2012", "test").is_valid(), true);
	}

	/**
	 * Sanity date 8.
	 */
	@Test
	void sanityDate8() {
		DateValidator val = (DateValidator) ValidatorFactory.getValidator(ValidationType.Date);
		val.setConfig(new DateValidationConfig("dd/MM/yyyy", Language.English));
		assertEquals(val.validate("Ahmed hamad", "test").is_valid(), false);
	}

	/**
	 * Sanity email 1.
	 */
	@Test
	void sanityEmail1() {
		EmailValidator val = (EmailValidator) ValidatorFactory.getValidator(ValidationType.Email);
		val.setConfig(new EmailValidationConfig(Language.English));
		assertTrue(val.validate("user@domain.com", "test").is_valid());
	}

	/**
	 * Sanity email 2.
	 */
	@Test
	void sanityEmail2() {
		EmailValidator val = (EmailValidator) ValidatorFactory.getValidator(ValidationType.Email);
		val.setConfig(new EmailValidationConfig(Language.English));
		assertTrue(val.validate("user@domain.co.in", "test").is_valid());
	}

	/**
	 * Sanity email 3.
	 */
	@Test
	void sanityEmail3() {
		EmailValidator val = (EmailValidator) ValidatorFactory.getValidator(ValidationType.Email);
		val.setConfig(new EmailValidationConfig(Language.English));
		assertTrue(val.validate("user1@domain.com", "test").is_valid());
	}

	/**
	 * Sanity email 4.
	 */
	@Test
	void sanityEmail4() {
		EmailValidator val = (EmailValidator) ValidatorFactory.getValidator(ValidationType.Email);
		val.setConfig(new EmailValidationConfig(Language.English));
		assertTrue(val.validate("user.name@domain.com", "test").is_valid());
	}

	/**
	 * Sanity email 5.
	 */
	@Test
	void sanityEmail5() {
		EmailValidator val = (EmailValidator) ValidatorFactory.getValidator(ValidationType.Email);
		val.setConfig(new EmailValidationConfig(Language.English));
		assertTrue(val.validate("user#@domain.co.in", "test").is_valid());
	}

	/**
	 * Sanity email 6.
	 */
	@Test
	void sanityEmail6() {
		EmailValidator val = (EmailValidator) ValidatorFactory.getValidator(ValidationType.Email);
		val.setConfig(new EmailValidationConfig(Language.English));
		assertTrue(val.validate("user@domaincom", "test").is_valid());
	}

	/**
	 * Sanity email 7.
	 */
	@Test
	void sanityEmail7() {
		EmailValidator val = (EmailValidator) ValidatorFactory.getValidator(ValidationType.Email);
		val.setConfig(new EmailValidationConfig(Language.English));
		assertFalse(val.validate("user#domain.com", "test").is_valid());
	}

	/**
	 * Sanity email 8.
	 */
	@Test
	void sanityEmail8() {
		EmailValidator val = (EmailValidator) ValidatorFactory.getValidator(ValidationType.Email);
		val.setConfig(new EmailValidationConfig(Language.English));
		assertFalse(val.validate("@yahoo.com", "test").is_valid());
	}

	/**
	 * Sanity length less bad.
	 */
	@Test
	void sanityLengthLessBad() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length);
		val.setConfig(new LengthValidationConfig(1, LengthOperator.LESS, Language.English));
		assertEquals(val.validate("Ahmed hamad", "test").is_valid(), false);

	}

	/**
	 * Sanity length less GOOD.
	 */
	@Test
	void sanityLengthLessGOOD() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length);
		val.setConfig(new LengthValidationConfig(50, LengthOperator.LESS, Language.English));
		assertEquals(val.validate("Ahmed hamad", "test").is_valid(), true);
	}

	/**
	 * Sanity length greater bad.
	 */
	@Test
	void sanityLengthGreaterBad() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length);
		val.setConfig(new LengthValidationConfig(1, LengthOperator.GREATER, Language.English));
		assertEquals(val.validate("a", "test").is_valid(), false);
	}

	/**
	 * Sanity length greater GOOD.
	 */
	@Test
	void sanityLengthGreaterGOOD() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length);
		val.setConfig(new LengthValidationConfig(5, LengthOperator.GREATER, Language.English));
		assertEquals(val.validate("Ahmed hamad", "test").is_valid(), true);

	}

	/**
	 * Sanity length equal GOOD.
	 */
	@Test
	void sanityLengthEqualGOOD() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length);
		val.setConfig(new LengthValidationConfig(5, LengthOperator.EQUAL, Language.English));
		assertEquals(val.validate("Ahmed", "test").is_valid(), true);
	}

	/**
	 * Sanity length equal BAD.
	 */
	@Test
	void sanityLengthEqualBAD() {
		LengthValidator val = (LengthValidator) ValidatorFactory.getValidator(ValidationType.Length);
		val.setConfig(new LengthValidationConfig(7, LengthOperator.EQUAL, Language.English));
		assertEquals(val.validate("Ahmed", "test").is_valid(), false);
	}

	/**
	 * Sanity numeric bad 1.
	 */
	@Test
	void sanityNumericBad1() {
		NumericValidator val = (NumericValidator) ValidatorFactory.getValidator(ValidationType.Number);
		val.setConfig(new NumericValidationConfig(Language.English));
		assertEquals(val.validate("Ahmed", "test").is_valid(), false);
	}

	/**
	 * Sanity numeric bad 2.
	 */
	@Test
	void sanityNumericBad2() {
		NumericValidator val = (NumericValidator) ValidatorFactory.getValidator(ValidationType.Number);
		val.setConfig(new NumericValidationConfig(Language.English));
		assertEquals(val.validate("12123909124.1230412309423409", "test").is_valid(), false);

	}

	/**
	 * Sanity numeric good.
	 */
	@Test
	void sanityNumericGood() {
		NumericValidator val = (NumericValidator) ValidatorFactory.getValidator(ValidationType.Number);
		val.setConfig(new NumericValidationConfig(Language.English));
		assertEquals(val.validate("121239091241230412309423409", "test").is_valid(), true);

	}

	/**
	 * Sanity float good 1.
	 */
	@Test
	void sanityFloatGood1() {
		FloatValidator val = (FloatValidator) ValidatorFactory.getValidator(ValidationType.Float);
		val.setConfig(new FloatValidationConfig(Language.English));
		assertEquals(val.validate("1.12", "test").is_valid(), true);

	}

	/**
	 * Sanity float good 2.
	 */
	@Test
	void sanityFloatGood2() {
		FloatValidator val = (FloatValidator) ValidatorFactory.getValidator(ValidationType.Float);
		val.setConfig(new FloatValidationConfig(Language.English));
		assertEquals(val.validate("112", "test").is_valid(), true);

	}

	/**
	 * Sanity float bad.
	 */
	@Test
	void sanityFloatBad() {
		FloatValidator val = (FloatValidator) ValidatorFactory.getValidator(ValidationType.Float);
		val.setConfig(new FloatValidationConfig(Language.English));
		assertEquals(val.validate("112..98", "test").is_valid(), false);
	}

	/**
	 * Sanity required bad 1.
	 */
	@Test
	void sanityRequiredBad1() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required);
		val.setConfig(new RequiredValidationConfig(Language.English));
		assertEquals(val.validate("null", "test").is_valid(), false);
	}

	/**
	 * Sanity required bad 2.
	 */
	@Test
	void sanityRequiredBad2() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required);
		val.setConfig(new RequiredValidationConfig(Language.English));
		assertEquals(val.validate("Null", "test").is_valid(), false);
	}

	/**
	 * Sanity required bad 3.
	 */
	@Test
	void sanityRequiredBad3() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required);
		val.setConfig(new RequiredValidationConfig(Language.English));
		assertEquals(val.validate("   ", "test").is_valid(), false);
	}

	/**
	 * Sanity required bad 4.
	 */
	@Test
	void sanityRequiredBad4() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required);
		val.setConfig(new RequiredValidationConfig(Language.English));
		assertEquals(val.validate("{}", "test").is_valid(), false);
	}

	/**
	 * Sanity required good.
	 */
	@Test
	void sanityRequiredGood() {
		RequiredValidator val = (RequiredValidator) ValidatorFactory.getValidator(ValidationType.Required);
		val.setConfig(new RequiredValidationConfig(Language.English));
		assertEquals(val.validate("{{id:\"123\"}}", "test").is_valid(), true);
	}

	/**
	 * Sanity complex 1.
	 */
	@Test
	void sanityComplex1() {
		ArrayList<ValidationConfig> confgs = new ArrayList<ValidationConfig>();
		confgs.add(new RequiredValidationConfig(Language.English));
		confgs.add(new ArabicValidationConfig(Language.English));
		confgs.add(new LengthValidationConfig(10, LengthOperator.GREATER, Language.English));
		ComplexValidator val = new ComplexValidator();
		ArrayList<ValidationResult> results = val.validate(" ", "test", confgs);
		assertFalse(results.get(0).is_valid());
		assertTrue(results.get(1).is_valid());
		assertFalse(results.get(2).is_valid());
	}

	/**
	 * Sanity complex 2.
	 */
	@Test
	void sanityComplex2() {
		ArrayList<ValidationConfig> confgs = new ArrayList<ValidationConfig>();
		confgs.add(new RequiredValidationConfig(Language.English));
		confgs.add(new ArabicValidationConfig(Language.English));
		confgs.add(new LengthValidationConfig(10, LengthOperator.GREATER, Language.English));
		ComplexValidator val = new ComplexValidator();
		ArrayList<ValidationResult> results = val.validate("Ahmedkhaled", "test", confgs);
		assertTrue(results.get(0).is_valid());
		assertFalse(results.get(1).is_valid());
		assertTrue(results.get(2).is_valid());
	}

	/**
	 * Sanity complex 3.
	 */
	@Test
	void sanityComplex3() {
		ArrayList<ValidationConfig> confgs = new ArrayList<ValidationConfig>();
		confgs.add(new RequiredValidationConfig(Language.English));
		confgs.add(new ArabicValidationConfig(Language.English));
		confgs.add(new LengthValidationConfig(10, LengthOperator.GREATER, Language.English));
		ComplexValidator val = new ComplexValidator();
		ArrayList<ValidationResult> results = val.validate("احمد حامد", "test", confgs);
		assertTrue(results.get(0).is_valid());
		assertTrue(results.get(1).is_valid());
		assertFalse(results.get(2).is_valid());
	}

	/**
	 * Sanity nationalization 1.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	void sanityNationalization1() throws IOException {
		String msg = Nationalization.getTranslation(Nationalization.ENGLISH_ERROR_KEY, Language.English);
		assertEquals(msg, "must contain only English letters");
	}

	/**
	 * Sanity nationalization 2.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	void sanityNationalization2() throws IOException {
		String msg = Nationalization.getTranslation(Nationalization.ENGLISH_ERROR_KEY, Language.Arabic);
		assertEquals(msg, "ليس قيمة باللغة الانجليزية");
	}

	/**
	 * Sanity nationalization change english.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	void sanityNationalizationChangeEnglish() throws IOException {
		Nationalization.setEnglishTranslation("testChange", "value");
		String msg = Nationalization.getTranslation("testChange", Language.English);
		assertEquals(msg, "value");
	}

	/**
	 * Sanity nationalization change arabic.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	void sanityNationalizationChangeArabic() throws IOException {
		Nationalization.setArabicTranslation("testChange", "قيمة");
		String msg = Nationalization.getTranslation("testChange", Language.Arabic);
		assertEquals(msg, "قيمة");
	}

	/**
	 * Sanity API length.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void sanityAPILength() throws Exception {
		API api = new API();
		assertTrue(api.validateFieldLength("Asd", "EQUAL", 3));
	}

	@Test
	void sanityConfigurationSerialization1() throws FileNotFoundException, ValidationNotSupportedException,
			MissingParameterException, WrongOperatorException {
		File file = new File("json test cases/1.json");
		JsonObject obj = Json.createReader(new FileInputStream(file)).readObject();
		new ValidationSerializer();
		HashMap<String, ArrayList<ValidationConfig>> mapping = ValidationSerializer.serialzieValidations(obj,
				Language.English);
		assertEquals(mapping.get("RPINFO").contains(new RequiredValidationConfig(Language.English)), true);
		assertEquals(mapping.get("RPINFO.POI.POINUMBER").contains(new RequiredValidationConfig(Language.English)),
				true);
		assertEquals(mapping.get("RPINFO.POI.POINUMBER")
				.contains(new LengthValidationConfig(123, LengthOperator.LESS, Language.English)), true);
		assertEquals(mapping.get("RPINFO.POI.POINUMBER").contains(new ArabicValidationConfig(Language.English)), true);
		assertEquals(mapping.get("RPINFO.POI.POINUMBER").contains(new EmailValidationConfig(Language.English)), true);
		assertEquals(
				mapping.get("RPINFO.POI.POINUMBER").contains(new DateValidationConfig("yyyy/MM/dd", Language.English)),
				true);
		assertEquals(mapping.get("RPINFO.POI.POINUMBER").contains(new EmailValidationConfig(Language.English)), true);
		assertEquals(mapping.get("RPINFO.POI.POINUMBER").contains(new NumericValidationConfig(Language.English)), true);
		assertEquals(mapping.get("RPINFO.POI.POINUMBER").contains(new FloatValidationConfig(Language.English)), true);

	}

}
