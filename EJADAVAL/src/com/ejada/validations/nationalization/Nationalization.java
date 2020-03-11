package com.ejada.validations.nationalization;

import java.io.IOException;
import java.net.URLClassLoader;

import com.ejada.validations.config.ConfigReader;
import com.ejada.validations.exceptions.ValidationConfigNotFound;

/**
 * The Class Nationalization.
 */
public class Nationalization {

	/**
	 * Instantiates a new nationalization.
	 */
	private Nationalization() {
	}

	/**
	 * The Constant ARABIC_ERROR_KEY.
	 */
	public static final String ARABIC_ERROR_KEY = "com.ejada.translations.arabicerror";

	/**
	 * The Constant ENGLISH_ERROR_KEY.
	 */
	public static final String ENGLISH_ERROR_KEY = "com.ejada.translations.englisherror";

	/**
	 * The Constant DATE_ERROR_KEY.
	 */
	public static final String DATE_ERROR_KEY = "com.ejada.translations.dateerror";

	/**
	 * The Constant LENGTH_ERROR_KEY.
	 */
	public static final String LENGTH_ERROR_KEY = "com.ejada.translations.lengtherror";

	/**
	 * The Constant FLOAT_ERROR_KEY.
	 */
	public static final String FLOAT_ERROR_KEY = "com.ejada.translations.floaterror";

	/**
	 * The Constant NUMERIC_ERROR_KEY.
	 */
	public static final String NUMERIC_ERROR_KEY = "com.ejada.translations.numbererror";

	/**
	 * The Constant REQUIRED_ERROR_KEY.
	 */
	public static final String REQUIRED_ERROR_KEY = "com.ejada.translations.requirederror";

	public static final String EMAIL_ERROR_KEY = "com.ejada.translations.emailerror";

	/**
	 * Gets the translation.
	 *
	 * @param key  the key
	 * @param lang the lang
	 * @return the translation
	 * @throws ValidationConfigNotFound
	 */
	public static String getTranslation(String key, Language lang) throws ValidationConfigNotFound {
		String file = "";
		try {
			switch (lang) {
			case Arabic:
				file = ConfigReader.ARABIC_TRANSLATION;
				break;
			case English:
				file = ConfigReader.ENGLISH_TRANSLATION;
				break;
			default:
				break;
			}
			return ConfigReader.read(file, key);
		} catch (IOException e) {
			throw new ValidationConfigNotFound(
					((URLClassLoader) (Thread.currentThread().getContextClassLoader())).getURLs().toString());
		}
	}

}
