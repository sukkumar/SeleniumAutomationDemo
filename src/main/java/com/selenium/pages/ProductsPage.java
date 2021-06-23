package com.selenium.pages;

import org.openqa.selenium.By;

public class ProductsPage {

	public By productFilter_DrpDwn = By.className("product_sort_container");
	public By addProduct(String product) {
		return By.xpath("//div[text() = '"+product+"']/ancestor::div[1]/following-sibling::div/button[text()='Add to cart']");
	}
    
	public By cart_Link = By.className("shopping_cart_link");
	
}
