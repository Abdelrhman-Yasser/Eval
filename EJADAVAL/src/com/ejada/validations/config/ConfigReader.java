package com.ejada.validations.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;


/**
 * The Class ConfigReader.
 */
public class ConfigReader {

	/**
	 * The Constant CONFIG_FILE.
	 */
	public static final String CONFIG_FILE = "config.properties" ;
	
	/**
	 * The Constant ARABIC_TRANSLATION.
	 */
	public static final String ARABIC_TRANSLATION = "translationsAra.properties" ;
	
	/**
	 * The Constant ENGLISH_TRANSLATION.
	 */
	public static final String ENGLISH_TRANSLATION = "translationsEng.properties" ;
	
	/**
	 * Instantiates a new config reader.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private ConfigReader() throws IOException {} 
	
	/**
	 * Read.
	 *
	 * @param file the file
	 * @param key the key
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String read(String file, String key) throws IOException {		
		Properties prop = new Properties() ;
		FileInputStream ip= new FileInputStream(file) ;
		prop.load(new InputStreamReader(ip, Charset.forName("UTF-8")));
		return prop.getProperty(key) ;
	}
	
	/**
	 * Gets the prop.
	 *
	 * @param file the file
	 * @return the prop
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties getProp(String file) throws IOException {
		Properties prop = new Properties() ;
		FileInputStream ip= new FileInputStream(file) ;
		prop.load(new InputStreamReader(ip, Charset.forName("UTF-8")));
		return prop ;
	}
	
}
