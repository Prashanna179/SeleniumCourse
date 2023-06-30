package Temenos.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Temenos.GlobalTest.BaseTest;
import Temenos.PageObjectModel.StandAloneTest2.CartPage;
import Temenos.PageObjectModel.StandAloneTest2.CheckoutPage;
import Temenos.PageObjectModel.StandAloneTest2.ConfirmationPage;
import Temenos.PageObjectModel.StandAloneTest2.LoginPage;
import Temenos.PageObjectModel.StandAloneTest2.OrderPage;
import Temenos.PageObjectModel.StandAloneTest2.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{

		@Test(dataProvider= "giveData",groups="Purchase")
		
		public void SubmitOrder(HashMap<String,String> input) throws InterruptedException, IOException
		//public void SubmitOrder(String email,String password,String productName) throws InterruptedException, IOException
		{
		
		/*****Login Page*****/
		//LoginPage loginPage = launchApplication(); -> handled as beforeMethod in BaseTest
		//ProductPage productpage = loginPage.loginApplication(email,password);
		ProductPage productpage = loginPage.loginApplication(input.get("email"),input.get("password"));
		
		/*****Product Page*****/
		productpage.getListOfProducts();
		CartPage cartpage = productpage.getProductFromListOfProducts(input.get("productName"));
		
		/*****Cart Page*****/
		cartpage.goToCartPage();
		CheckoutPage checkoutpage = cartpage.toCheckOut();
		
		/*****CheckOut Page*****/
		ConfirmationPage confirmationpage = checkoutpage.chooseCountry();
		
		/*****Confirmation Page*****/
		String confirmMessage = confirmationpage.toConfirm();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		}
		
	
		@Test(dependsOnMethods= {"SubmitOrder"})
		public void validateOrderPage()
		{
			loginPage.loginApplication("prashannarg@gmail.com","Password@179");
			OrderPage orderpage = loginPage.goToOrdersPage();
			Assert.assertTrue(orderpage.verifyProductPresentInOrderPage("zara coat 3"));
		}
		
	
		
		@DataProvider
		public Object[][] giveData() throws IOException
		{
			/** First Way of Implementation**/
			/*Object o[][] = {{"prashannarg@gmail.com","Password@179","zara coat 3"},{"Dhivyan@gmail.com","Password@179","adidas original"}};
			return o;*/
			
			/**Second Way of Implementation**/
			
			 /* HashMap<String,String> h = new HashMap<String,String>();
			  h.put("email","prashannarg@gmail.com" ); h.put("password", "Password@179");
			  h.put("productName","zara coat 3");
			  
			  HashMap<String,String> h1 = new HashMap<String,String>();
			  h1.put("email","Dhivyan@gmail.com"); h1.put("password", "Password@179");
			  h1.put("productName","adidas original");
			  
			  Object o[][]= {{h},{h1}};
			  return o;*/
			 
			
			/**Third Way of Implementation**/
			//List of HashMap objects
			List<HashMap<String, String>> data = getJsonToHashMap(System.getProperty("user.dir")+"\\src\\test\\java\\Temenos\\Data\\PurchaseOrder.json");
			Object o[][] = {{data.get(0)},{data.get(1)}};
			return o;
		}
		
		
		
}

