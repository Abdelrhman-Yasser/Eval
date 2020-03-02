package com.ejada.validations.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;


public class ConfigReader {

	public static final String CONFIG_FILE = "config.properties" ;
	public static final String ARABIC_TRANSLATION = "translationsAra.properties" ;
	public static final String ENGLISH_TRANSLATION = "translationsEng.properties" ;
	
	private ConfigReader() throws IOException {} 
	
	public static String read(String file, String key) throws IOException {		
		Properties prop = new Properties() ;
		FileInputStream ip= new FileInputStream(file) ;
		prop.load(new InputStreamReader(ip, Charset.forName("UTF-8")));
		return prop.getProperty(key) ;
	}
	
	public static Properties getProp(String file) throws IOException {
		Properties prop = new Properties() ;
		FileInputStream ip= new FileInputStream(file) ;
		prop.load(new InputStreamReader(ip, Charset.forName("UTF-8")));
		return prop ;
	}
	
}
