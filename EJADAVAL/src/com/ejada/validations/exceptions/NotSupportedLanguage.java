package com.ejada.validations.exceptions;

public class NotSupportedLanguage extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9130404474010469062L;

	public NotSupportedLanguage() {

	}

	public NotSupportedLanguage(String lang) {
		super(lang + " is not supported language");
	}

	public NotSupportedLanguage(Throwable cause) {
		super(cause);
	}

	public NotSupportedLanguage(String lang, Throwable cause) {
		super(lang + " is not supported language", cause);
	}

	public NotSupportedLanguage(String lang, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(lang + " is not supported language", cause, enableSuppression, writableStackTrace);
	}

}
