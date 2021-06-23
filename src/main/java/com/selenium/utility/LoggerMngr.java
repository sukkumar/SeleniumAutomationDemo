package com.selenium.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerMngr {
	
	public static Logger logger;
	
	public static void initiateLogger(String className) {
    	  
    	  logger= Logger.getLogger(className);   

    	  // configure log4j properties file
    	  PropertyConfigurator.configure(System.getProperty("user.dir")+"//Resources//Log4j.properties");
    	  
      }
}
