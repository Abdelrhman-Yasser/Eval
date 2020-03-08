package com.ejada.validations.result;

import com.ejada.validations.nationalization.Language;

/**
 * The Class FloatResult.
 */
public class FloatResult implements ValidationResult {

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
	 * Instantiates a new float result.
	 *
	 * @param valid the valid
	 * @param fieldName the field name
	 * @param lang the lang
	 */
	public FloatResult(boolean valid, String fieldName,Language lang) {
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
