package com.ejada.validations.exceptions;

/**
 * The Class ValidationNotSupportedException.
 */
public class ValidationNotSupportedException extends Exception {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new validation not supported exception.
	 */
	public ValidationNotSupportedException() {
	}

	/**
	 * Instantiates a new validation not supported exception.
	 *
	 * @param validation the validation
	 */
	public ValidationNotSupportedException(String validation) {
		super(validation + " is not supported validation");
	}

	/**
	 * Instantiates a new validation not supported exception.
	 *
	 * @param cause the cause
	 */
	public ValidationNotSupportedException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new validation not supported exception.
	 *
	 * @param validation the validation
	 * @param cause      the cause
	 */
	public ValidationNotSupportedException(String validation, Throwable cause) {
		super(validation + " is not supported validation", cause);
	}

	/**
	 * Instantiates a new validation not supported exception.
	 *
	 * @param validation         the validation
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public ValidationNotSupportedException(String validation, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(validation + " is not supported validation", cause, enableSuppression, writableStackTrace);
	}

}
