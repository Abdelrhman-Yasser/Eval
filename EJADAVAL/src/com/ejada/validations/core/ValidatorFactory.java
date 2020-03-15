package com.ejada.validations.core;

import com.ejada.validations.complex.ValidationType;

/**
 * A factory for creating Validator objects.
 */
public class ValidatorFactory {

	/**
	 * The arabic language validator.
	 */
	private static ArabicLanguageValidator arabicLanguageValidator;

	/**
	 * Gets the arabic language validator.
	 *
	 * @return the arabic language validator
	 */
	private synchronized static ArabicLanguageValidator getArabicLanguageValidator() {
		if (arabicLanguageValidator == null)
			arabicLanguageValidator = new ArabicLanguageValidator();
		return arabicLanguageValidator;
	}

	/**
	 * The English language validator.
	 */
	private static EnglishLanguageValidator EnglishLanguageValidator;

	/**
	 * Gets the english language validator.
	 *
	 * @return the english language validator
	 */
	private synchronized static EnglishLanguageValidator getEnglishLanguageValidator() {
		if (EnglishLanguageValidator == null)
			EnglishLanguageValidator = new EnglishLanguageValidator();
		return EnglishLanguageValidator;
	}

	/**
	 * The date validator.
	 */
	private static DateValidator dateValidator;

	/**
	 * Gets the date validator.
	 *
	 * @return the date validator
	 */
	private synchronized static DateValidator getDateValidator() {
		if (dateValidator == null)
			dateValidator = new DateValidator();
		return dateValidator;
	}

	/**
	 * The length validator.
	 */
	private static LengthValidator lengthValidator;

	/**
	 * Gets the length validator.
	 *
	 * @return the length validator
	 */
	private synchronized static LengthValidator getLengthValidator() {
		if (lengthValidator == null)
			lengthValidator = new LengthValidator();
		return lengthValidator;
	}

	/**
	 * The numeric validator.
	 */
	private static NumericValidator numericValidator;

	/**
	 * Gets the numeric validator.
	 *
	 * @return the numeric validator
	 */
	private synchronized static NumericValidator getNumericValidator() {
		if (numericValidator == null)
			numericValidator = new NumericValidator();
		return numericValidator;
	}

	/**
	 * The float validator.
	 */
	private static FloatValidator floatValidator;

	/**
	 * Gets the float validator.
	 *
	 * @return the float validator
	 */
	private synchronized static FloatValidator getFloatValidator() {
		if (floatValidator == null)
			floatValidator = new FloatValidator();
		return floatValidator;
	}

	/**
	 * The required validator.
	 */
	private static RequiredValidator requiredValidator;

	/**
	 * Gets the required validator.
	 *
	 * @return the required validator
	 */
	private synchronized static RequiredValidator getRequiredValidator() {
		if (requiredValidator == null)
			requiredValidator = new RequiredValidator();
		return requiredValidator;
	}

	/**
	 * The email validator.
	 */
	private static EmailValidator emailValidator;

	/**
	 * Gets the email validator.
	 *
	 * @return the email validator
	 */
	private synchronized static EmailValidator getEmailValidator() {
		if (emailValidator == null)
			emailValidator = new EmailValidator();
		return emailValidator;
	}

	/**
	 * The json validator.
	 */
	private static JsonValidator jsonValidator;

	/**
	 * Gets the json validator.
	 *
	 * @return the json validator
	 */
	public synchronized static JsonValidator getJsonValidator() {
		if (jsonValidator == null)
			jsonValidator = new JsonValidator();
		return jsonValidator;
	}

	/**
	 * Gets the validator.
	 *
	 * @param type the type
	 * @return the validator
	 */
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
		default:
			break;
		}
		return null;
	}

}