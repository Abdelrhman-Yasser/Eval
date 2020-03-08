package com.ejada.validations.exceptions;

/**
 * The Class WrongOperatorException.
 */
public class WrongOperatorException extends Exception {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new wrong operator exception.
	 */
	public WrongOperatorException() {
	}

	/**
	 * Instantiates a new wrong operator exception.
	 *
	 * @param operator the operator
	 */
	public WrongOperatorException(String operator) {
		super(operator + " is not valid operator");
	}

	/**
	 * Instantiates a new wrong operator exception.
	 *
	 * @param cause the cause
	 */
	public WrongOperatorException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new wrong operator exception.
	 *
	 * @param operator the operator
	 * @param cause the cause
	 */
	public WrongOperatorException(String operator, Throwable cause) {
		super(operator + " is not valid operator", cause);
	}

	/**
	 * Instantiates a new wrong operator exception.
	 *
	 * @param operator the operator
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public WrongOperatorException(String operator, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(operator + " is not valid operator", cause, enableSuppression, writableStackTrace);
	}

}
