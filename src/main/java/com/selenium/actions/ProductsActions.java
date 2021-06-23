package com.selenium.actions;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.selenium.base.BasePage;
import com.selenium.pages.ProductsPage;


public class ProductsActions extends BasePage {
	
	ProductsPage objProductsPage ;
	
	public ProductsActions() {
		objProductsPage = new ProductsPage();
	}
	
	public void sortTheProducts(String sortBy) {
		WebElement sortDropDown = driver.findElement(objProductsPage.productFilter_DrpDwn);
		Select sortDropDownSel = new Select(sortDropDown);
		sortDropDownSel.selectByVisibleText(sortBy);
	}
	public void addProductToCart(String productName){
		driver.findElement(objProductsPage.addProduct(productName)).click();
		waitForPageLoad(5);
	}
	
	public void openCart() {
		WebElement cartLink = null;
		cartLink = waitForElement(cartLink, objProductsPage.cart_Link, 30);
		cartLink.click();
		waitForPageLoad(5);
	}

}
