package com.selenium.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  public static WebDriver driver;
  
  public void browserSetUp(String browser) {
	  
	  if(browser.equals("headless")) {
		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
		   ChromeOptions options = new ChromeOptions();
	       options.addArguments("headless");
	       driver = new ChromeDriver(options);
	  }else {
			  if(browser.equals("chrome")) {
			    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
				driver = new ChromeDriver();
			  } else if(browser.equals("firefox")){
				    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//BrowserDrivers///geckodriver.exe");
					driver = new FirefoxDriver();
			  } 	
			  driver.manage().window().maximize();
	  }
  }
  
  public void launchApplication(String appName) {
	  driver.get(appName);
  }
	
  public WebElement waitForElement(WebElement element, By locator, int waitTime) {
	  WebDriverWait wait=new WebDriverWait(driver, waitTime);
	  element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	  return element;
  }
  
  public void waitForPageLoad(int pageLoadTime) {
	  driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
  }
  
  public void closeApplication() {
	  driver.close();
  }
}
