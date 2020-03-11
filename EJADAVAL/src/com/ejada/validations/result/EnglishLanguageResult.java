package com.ejada.validations.result;

import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.nationalization.Language;
import com.ejada.validations.nationalization.Nationalization;

/**
 * The Class EnglishLanguageResult.
 */
public class EnglishLanguageResult implements ValidationResult {

	/**
	 * The message.
	 */
	private String message = "";

	/**
	 * The code.
	 */
	private final String code = "";

	/**
	 * The field name.
	 */
	private String fieldName;

	/**
	 * The valid.
	 */
	private boolean valid;

	/**
	 * Instantiates a new english language result.
	 *
	 * @param valid     the valid
	 * @param fieldName the field name
	 * @param lang      the lang
	 * @throws ValidationConfigNotFound
	 */
	public EnglishLanguageResult(boolean valid, String fieldName, Language lang) throws ValidationConfigNotFound {
		super();
		this.valid = valid;
		this.fieldName = fieldName;
		this.message = Nationalization.getTranslation(Nationalization.ENGLISH_ERROR_KEY, lang);
	}

	@Override
	public String toString() {
		if (!valid)
			return get_error_message();
		else
			return fieldName + " validated true";
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	@Override
	public String get_error_message() {
		return this.fieldName + " " + message;
	}

	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	@Override
	public boolean is_valid() {
		return valid;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	@Override
	public String get_error_code() {
		return this.code;
	}

}
