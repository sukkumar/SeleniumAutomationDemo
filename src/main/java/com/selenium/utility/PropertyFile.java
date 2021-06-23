package com.selenium.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	Properties prop ;
	FileInputStream objfile;
	
	public PropertyFile(String propFilePath) throws IOException {
	   prop = new Properties(); 
	   objfile = new FileInputStream(propFilePath); 
	   prop.load(objfile); 
	}
	
		
	public String readProperty(String key) {
		
		return prop.getProperty(key);
		
	}
	
}
