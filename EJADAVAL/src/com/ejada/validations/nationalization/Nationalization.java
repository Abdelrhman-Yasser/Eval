package com.ejada.validations.nationalization;

import java.io.IOException;

import com.ejada.validations.config.ConfigReader;
import com.ejada.validations.config.ConfigWriter;

/**
 * The Class Nationalization.
 */
public class Nationalization {

	/**
	 * Instantiates a new nationalization.
	 */
	private Nationalization() {}

	/**
	 * The Constant ARABIC_ERROR_KEY.
	 */
	public static final String ARABIC_ERROR_KEY = "com.ejada.translations.arabicerror";
	
	/**
	 * The Constant ENGLISH_ERROR_KEY.
	 */
	public static final String ENGLISH_ERROR_KEY = "com.ejada.translations.englisherror" ;
	
	/**
	 * The Constant DATE_ERROR_KEY.
	 */
	public static final String DATE_ERROR_KEY = "com.ejada.translations.dateerror" ;
	
	/**
	 * The Constant LENGTH_ERROR_KEY.
	 */
	public static final String LENGTH_ERROR_KEY = "com.ejada.translations.lengtherror" ;
	
	/**
	 * The Constant FLOAT_ERROR_KEY.
	 */
	public static final String FLOAT_ERROR_KEY = "com.ejada.translations.floaterror" ;
	
	/**
	 * The Constant NUMERIC_ERROR_KEY.
	 */
	public static final String NUMERIC_ERROR_KEY = "com.ejada.translations.numbererror" ;
	
	/**
	 * The Constant REQUIRED_ERROR_KEY.
	 */
	public static final String REQUIRED_ERROR_KEY = "com.ejada.translations.requirederror" ;
	
	/**
	 * Gets the translation.
	 *
	 * @param key the key
	 * @param lang the lang
	 * @return the translation
	 */
	public static String getTranslation(String key, Language lang) {
		String file = "";		
		try {
			switch (lang) {
				case Arabic:
					file = ConfigReader.ARABIC_TRANSLATION ;
					break;
				case English:
					file = ConfigReader.ENGLISH_TRANSLATION ;
					break ;
				default:
					break ;
			}
			return ConfigReader.read(file,key);
		} catch (IOException e) {
			return null ;
		}
	}
	
	/**
	 * Sets the arabic translation.
	 *
	 * @param key the key
	 * @param value the value
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void setArabicTranslation(String key, String value) throws IOException {
		String file = ConfigWriter.ARABIC_TRANSLATION;		
		ConfigWriter.write(file, key, value);
	}

	/**
	 * Sets the english translation.
	 *
	 * @param key the key
	 * @param value the value
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void setEnglishTranslation(String key, String value) throws IOException {
		String file = ConfigWriter.ENGLISH_TRANSLATION;		
		ConfigWriter.write(file, key, value);
	}
	

}
