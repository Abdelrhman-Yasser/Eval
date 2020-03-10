package com.ejada.validations.exceptions;

/**
 * The Class MissingParameterException.
 */
public class MissingParameterException extends Exception {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new missing parameter exception.
	 */
	public MissingParameterException() {
	}

	/**
	 * Instantiates a new missing parameter exception.
	 *
	 * @param parameter the parameter
	 */
	public MissingParameterException(String parameter) {
		super("Missing parameter : " + parameter);
	}

	/**
	 * Instantiates a new missing parameter exception.
	 *
	 * @param cause the cause
	 */
	public MissingParameterException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new missing parameter exception.
	 *
	 * @param parameter the parameter
	 * @param cause     the cause
	 */
	public MissingParameterException(String parameter, Throwable cause) {
		super("Missing parameter : " + parameter);
	}

	/**
	 * Instantiates a new missing parameter exception.
	 *
	 * @param parameter          the parameter
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public MissingParameterException(String parameter, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super("Missing parameter : " + parameter, cause, enableSuppression, writableStackTrace);
	}

}
