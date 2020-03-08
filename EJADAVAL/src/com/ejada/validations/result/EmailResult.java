package com.ejada.validations.result;

import com.ejada.validations.nationalization.Language;

/**
 * The Class EmailResult.
 */
public class EmailResult implements ValidationResult{

	/**
	 * The message.
	 */
	private final String message = "" ;
	
	/**
	 * The code.
	 */
	private final String code = "" ;
	
	/**
	 * The field name.
	 */
	private String fieldName ;
	
	/**
	 * The valid.
	 */
	private boolean valid;

	/**
	 * Instantiates a new email result.
	 *
	 * @param valid the valid
	 * @param fieldName the field name
	 * @param lang the lang
	 */
	public EmailResult(boolean valid, String fieldName, Language lang) {
		super();
		this.valid = valid ;
		this.fieldName = fieldName ;
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
