package com.selenium.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.actions.CartActions;
import com.selenium.actions.LoginActions;
import com.selenium.actions.ProductsActions;
import com.selenium.base.BasePage;
import com.selenium.utility.Excel;
import com.selenium.utility.LoggerMngr;
import com.selenium.utility.PropertyFile;

public class SauceDemoTest extends BasePage {

	LoginActions objLoginActions;
	CartActions objCartActions;
	ProductsActions objProductsActions;
	Excel excel;
	PropertyFile objPropertyFile;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browser) throws IOException {
		objLoginActions = new LoginActions();
		objProductsActions = new ProductsActions();
		objCartActions = new CartActions();
		excel = new Excel(System.getProperty("user.dir")+"//TestData//MyContactForm.xlsx");
		objPropertyFile = new PropertyFile(System.getProperty("user.dir")+"//Resources//config.properties");
		excel = new Excel(System.getProperty("user.dir")+"//TestData//SauceTestData.xlsx");
		
		LoggerMngr.initiateLogger(this.getClass().getSimpleName());
		browserSetUp(browser);
		LoggerMngr.logger.info("Launch the application :");
		launchApplication(objPropertyFile.readProperty("url"));
	}
	
	
	@Test
	public void sacuceTest() throws InterruptedException {		
		LoggerMngr.logger.info("Login to application");
		objLoginActions.login(excel.readData("LoginData",1,0),excel.readData("LoginData",1,1));
		
		LoggerMngr.logger.info("Sort the items (Lowest Price sort)");
		objProductsActions.sortTheProducts(objPropertyFile.readProperty("filterProductsBy"));
		LoggerMngr.logger.info("Add two items to the shopping cart");
		ArrayList<String> itemsToShop = excel.readData("ProductsToAdd");
		for(String productName : itemsToShop) {
		   objProductsActions.addProductToCart(productName);
		}
		LoggerMngr.logger.info("Visit the shopping cart");
		objProductsActions.openCart();
		LoggerMngr.logger.info("Assert that the items that added are in the cart");
		objCartActions.verifyInventory(itemsToShop);
		LoggerMngr.logger.info("Remove an item and then continue shopping");
		String itemToRemove = objPropertyFile.readProperty("itemToRemove");
		objCartActions.removeProductFromCart(itemToRemove);
		itemsToShop.remove(itemToRemove);		
		objCartActions.continueShopping();
		String itemToAdd = objPropertyFile.readProperty("itemToAdd");
		itemsToShop.add(itemToAdd);
		LoggerMngr.logger.info("Add another item");
		objProductsActions.addProductToCart(itemToAdd);
		objProductsActions.openCart();
		LoggerMngr.logger.info("proceed to Checkout");
		objCartActions.continueCheckOut();
		LoggerMngr.logger.info("Assert that the items that added are in the cart");
		objCartActions.verifyInventory(itemsToShop);
		LoggerMngr.logger.info("Assert the total price");
		objCartActions.verifyItemsTotal();
		LoggerMngr.logger.info("Finish checkout");	
		objCartActions.finishCheckOut();
	}
	
	@AfterTest
	public void endOfTest() {
		driver.close();
	}
	
}
