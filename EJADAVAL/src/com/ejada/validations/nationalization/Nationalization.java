package com.ejada.validations.nationalization;

import java.io.IOException;

import com.ejada.validations.config.ConfigReader;
import com.ejada.validations.config.ConfigWriter;

public class Nationalization {

	private Nationalization() {}

	public static final String ARABIC_ERROR_KEY = "com.ejada.translations.arabicerror";
	
	public static final String ENGLISH_ERROR_KEY = "com.ejada.translations.englisherror" ;
	
	public static final String DATE_ERROR_KEY = "com.ejada.translations.dateerror" ;
	
	public static final String LENGTH_ERROR_KEY = "com.ejada.translations.lengtherror" ;
	
	public static final String FLOAT_ERROR_KEY = "com.ejada.translations.floaterror" ;
	
	public static final String NUMERIC_ERROR_KEY = "com.ejada.translations.numbererror" ;
	
	public static final String REQUIRED_ERROR_KEY = "com.ejada.translations.requirederror" ;
	
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
	
	public static void setArabicTranslation(String key, String value) throws IOException {
		String file = ConfigWriter.ARABIC_TRANSLATION;		
		ConfigWriter.write(file, key, value);
	}

	public static void setEnglishTranslation(String key, String value) throws IOException {
		String file = ConfigWriter.ENGLISH_TRANSLATION;		
		ConfigWriter.write(file, key, value);
	}
	

}
