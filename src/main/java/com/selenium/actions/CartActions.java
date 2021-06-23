package com.selenium.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.base.BasePage;
import com.selenium.pages.CartPage;


public class CartActions extends BasePage {
	
	CartPage objCartPage ;
	
	public CartActions() {
		objCartPage = new CartPage();
	}
	
	public void verifyInventory(ArrayList<String> itemsToShop) {
		List<WebElement> cartItems = driver.findElements(objCartPage.cartItemsName_Txt);
		
		for(String shoppingItem : itemsToShop)
		 {
			boolean itemStatus = false;
			for(WebElement cartItem : cartItems){
				if(cartItem.getText().equals(shoppingItem))
				{
					itemStatus = true;
				}
			}
			Assert.assertTrue(itemStatus,"The item "+shoppingItem+" is not found in cart");
		}
	}
	
	public void removeProductFromCart(String productName){
		driver.findElement(objCartPage.removeProduct(productName)).click();
		waitForPageLoad(5);
	}
	
	public void continueShopping() {
		WebElement continueShoppingBtn = null;
		continueShoppingBtn = waitForElement(continueShoppingBtn, objCartPage.continueShopping_Btn, 30);
		continueShoppingBtn.click();
		waitForPageLoad(5);
	}
	
	public void continueCheckOut() {
		driver.findElement(objCartPage.checkOut_Btn).click();
		driver.findElement(objCartPage.firstName_TxtBox).sendKeys("testUserFname");
		driver.findElement(objCartPage.lastName_TxtBox).sendKeys("testUserLname");
		driver.findElement(objCartPage.postalCode_TxtBox).sendKeys("12345");
		driver.findElement(objCartPage.continueCheckOut_Btn).click();
	}
	
	public void verifyItemsTotal() {

		String totalBefTax = driver.findElement(objCartPage.itemsTotalBefTax_Txt).getText();
	    Assert.assertEquals(itemsTotalFromCart(), Double.parseDouble(totalBefTax.substring(13)), "total price of items is incorrect");
	
	}
	public double itemsTotalFromCart() {
		List<WebElement> itemsPriceList = driver.findElements(By.className("inventory_item_price"));
		double totalPriceOfItems = 0;
		for(WebElement itemPrice : itemsPriceList) {
			String price = itemPrice.getText();
			totalPriceOfItems = totalPriceOfItems + Double.parseDouble(price.substring(1));
		}
		return totalPriceOfItems;
	}
	
	public void finishCheckOut() {
		driver.findElement(objCartPage.finishCheckOut_Btn);
	}
	
	
	
}
