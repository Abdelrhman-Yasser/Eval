package com.ejada.validations.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Properties;

/**
 * The Class ConfigWriter.
 */
public class ConfigWriter {

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
	 * Instantiates a new config writer.
	 */
	private ConfigWriter() {} 
	
	/**
	 * Write.
	 *
	 * @param file the file
	 * @param key the key
	 * @param value the value
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void write(String file, String key, String value) throws IOException {
		Properties props = ConfigReader.getProp(file);
		props.setProperty(key, value);
		FileOutputStream writer = new FileOutputStream(file) ;
	    props.store(new OutputStreamWriter(writer, "UTF-8"),"Configuration has been updated " + LocalDateTime.now());
	    writer.close();
	}
	
}
