package com.selenium.pages;

import org.openqa.selenium.By;

public class CartPage {

	public By cartItemsName_Txt = By.className("inventory_item_name");
	public By cartItemsPrice_Txt = By.className("inventory_item_price");
	
	public By removeProduct(String product) {
		return By.xpath("//div[text() = '"+product+"']/ancestor::div[1]/descendant::button");
	}
	
	public By continueShopping_Btn = By.id("continue-shopping");
	
	public By checkOut_Btn = By.id("checkout");
	public By firstName_TxtBox = By.id("first-name");
	public By lastName_TxtBox = By.id("last-name");
	public By postalCode_TxtBox = By.id("postal-code");
	
	public By continueCheckOut_Btn = By.id("continue");
	
	public By itemsTotalBefTax_Txt = By.xpath("//*[@class = 'summary_subtotal_label']");
	public By finishCheckOut_Btn = By.id("finish");

}
