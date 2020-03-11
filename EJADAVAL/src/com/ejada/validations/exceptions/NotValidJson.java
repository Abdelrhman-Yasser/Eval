package com.ejada.validations.exceptions;

public class NotValidJson extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5907076201391054970L;

	public NotValidJson() {
		super("Validation configurations is not valid JSON");
	}

	public NotValidJson(String message) {
		super(message);
	}

	public NotValidJson(Throwable cause) {
		super(cause);
	}

	public NotValidJson(String message, Throwable cause) {
		super(message, cause);
	}

	public NotValidJson(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
