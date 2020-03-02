package com.ejada.validations.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static final String configFile = "config.properties" ;
	
	private ConfigReader() throws IOException {} 
	
	public static String read(String key) throws IOException {		
		Properties prop = new Properties() ;
		FileInputStream ip= new FileInputStream(configFile) ;
		prop.load(ip);
		return prop.getProperty(key) ;
	}
	
	public static Properties getProp() throws IOException {
		Properties prop = new Properties() ;
		FileInputStream ip= new FileInputStream(configFile) ;
		prop.load(ip);
		return prop ;
	}
	
}
