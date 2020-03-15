package com.ejada.validations.exceptions;

/**
 * The Class NotSupportedLanguage.
 */
public class NotSupportedLanguage extends Exception {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -9130404474010469062L;

	/**
	 * Instantiates a new not supported language.
	 */
	public NotSupportedLanguage() {

	}

	/**
	 * Instantiates a new not supported language.
	 *
	 * @param lang the lang
	 */
	public NotSupportedLanguage(String lang) {
		super(lang + " is not supported language");
	}

	/**
	 * Instantiates a new not supported language.
	 *
	 * @param cause the cause
	 */
	public NotSupportedLanguage(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new not supported language.
	 *
	 * @param lang  the lang
	 * @param cause the cause
	 */
	public NotSupportedLanguage(String lang, Throwable cause) {
		super(lang + " is not supported language", cause);
	}

	/**
	 * Instantiates a new not supported language.
	 *
	 * @param lang               the lang
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public NotSupportedLanguage(String lang, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(lang + " is not supported language", cause, enableSuppression, writableStackTrace);
	}

}
