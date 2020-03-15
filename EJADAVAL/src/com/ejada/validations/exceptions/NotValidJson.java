package com.ejada.validations.exceptions;

/**
 * The Class NotValidJson.
 */
public class NotValidJson extends Exception {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -5907076201391054970L;

	/**
	 * Instantiates a new not valid json.
	 */
	public NotValidJson() {
		super("Validation configurations is not valid JSON");
	}

	/**
	 * Instantiates a new not valid json.
	 *
	 * @param message the message
	 */
	public NotValidJson(String message) {
		super(message);
	}

	/**
	 * Instantiates a new not valid json.
	 *
	 * @param cause the cause
	 */
	public NotValidJson(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new not valid json.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public NotValidJson(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new not valid json.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public NotValidJson(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
