package com.ejada.validations.nationalization;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;

import com.ejada.validations.config.ConfigReader;
import com.ejada.validations.exceptions.ValidationConfigNotFound;
import com.ejada.validations.params.LangParam;
import com.ejada.validations.params.ParamType;

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

	/**
	 * The Constant EMAIL_ERROR_KEY.
	 */
	public static final String EMAIL_ERROR_KEY = "com.ejada.translations.emailerror";

	/**
	 * Gets the translation.
	 *
	 * @param key            the key
	 * @param languageBundle the language bundle
	 * @return the translation
	 * @throws ValidationConfigNotFound the validation config not found
	 */
	public static String getTranslation(String key, LangParam<?> languageBundle) throws ValidationConfigNotFound {

		if (languageBundle.getType() == ParamType.Language) {
			String file = "";
			try {
				Language lang = (Language) languageBundle.getValue();
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
		} else {
			try {
				File file = (File) languageBundle.getValue();
				return ConfigReader.read(file, key);
			} catch (IOException e) {
				throw new ValidationConfigNotFound(
						((URLClassLoader) (Thread.currentThread().getContextClassLoader())).getURLs().toString());
			}
		}

	}

}
