package com.ejada.validations.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static final String configFile = "config.properties" ;
	private static Properties prop ;

	private ConfigReader() throws IOException {} 
	
	public static synchronized Properties getConfigReader() throws IOException {
		if(prop == null) {
			prop = new Properties() ;
			InputStream stream = ConfigReader.class.getClassLoader().getResourceAsStream(configFile) ;
			prop.load(stream);
		}
		return prop ;
	}
	
}
