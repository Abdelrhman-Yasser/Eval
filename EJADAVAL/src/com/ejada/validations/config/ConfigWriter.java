package com.ejada.validations.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Properties;

public class ConfigWriter {

	public static final String CONFIG_FILE = "config.properties" ;
	public static final String ARABIC_TRANSLATION = "translationsAra.properties" ;
	public static final String ENGLISH_TRANSLATION = "translationsEng.properties" ;

	private ConfigWriter() {} 
	
	public static void write(String file, String key, String value) throws IOException {
		Properties props = ConfigReader.getProp(file);
		props.setProperty(key, value);
		FileOutputStream writer = new FileOutputStream(file) ;
	    props.store(new OutputStreamWriter(writer, "UTF-8"),"Configuration has been updated " + LocalDateTime.now());
	    writer.close();
	}
	
}
