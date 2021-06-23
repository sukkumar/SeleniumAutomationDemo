package com.selenium.actions;

import com.selenium.base.BasePage;
import com.selenium.pages.LoginPage;


public class LoginActions extends BasePage {
	
	LoginPage objLoginPage ;
	
	public LoginActions() {
		objLoginPage = new LoginPage();
	}
	
	public void login(String userName, String passWord){
		driver.findElement(objLoginPage.userName_TxtBox).sendKeys(userName);
		driver.findElement(objLoginPage.passWord_TxtBox).sendKeys(passWord);
		driver.findElement(objLoginPage.login_Btn).click();
		waitForPageLoad(10);
	}
}
