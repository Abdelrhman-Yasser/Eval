package com.ejada.validations.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

public class ConfigWriter {

	private static final String configFile = "config.properties" ;

	private ConfigWriter() {} 
	
	public static void write(String key, String value) throws IOException {
		Properties props = ConfigReader.getProp();
		props.setProperty(key, value);
		FileOutputStream writer = new FileOutputStream(configFile) ;
	    props.store(writer,"Configuration has been updated " + LocalDateTime.now());
	    writer.close();
	}
	
}
