package com.ejada.validations.result;

/**
 * The Interface ValidationResult.
 */
public interface ValidationResult{
	
	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	String get_error_message() ;
	
	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	boolean is_valid() ;
	
	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	String get_error_code() ;
}
