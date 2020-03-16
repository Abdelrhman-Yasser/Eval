package com.ejada.validations.result;

import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.nationalization.Nationalization;
import com.ejada.validations.params.LangParam;

/**
 * The Class ArabicLanguageResult.
 */
public class ArabicLanguageResult implements ValidationResult {

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
	 * Instantiates a new Arabic language result.
	 *
	 * @param valid     the valid
	 * @param fieldName the field name
	 * @param lang      the language
	 * @throws ValidationConfigNotFound the validation configuration not found
	 */
	public ArabicLanguageResult(boolean valid, String fieldName, LangParam<?> lang) throws ValidationConfigNotFound {
		super();
		this.valid = valid;
		this.fieldName = fieldName;
		this.message = Nationalization.getTranslation(Nationalization.ARABIC_ERROR_KEY, lang);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		if (!valid)
			return get_error_message();
		else
			return null;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	@Override
	public String get_error_message() {
		return fieldName + " " + message;
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
		return code;
	}

}
