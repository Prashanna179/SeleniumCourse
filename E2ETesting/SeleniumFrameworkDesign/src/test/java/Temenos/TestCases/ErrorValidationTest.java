package Temenos.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Temenos.GlobalTest.BaseTest;
import Temenos.GlobalTest.Retry;
import Temenos.PageObjectModel.StandAloneTest2.CartPage;
import Temenos.PageObjectModel.StandAloneTest2.CheckoutPage;
import Temenos.PageObjectModel.StandAloneTest2.ConfirmationPage;
import Temenos.PageObjectModel.StandAloneTest2.ProductPage;

public class ErrorValidationTest extends BaseTest{

	@Test(retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws InterruptedException, IOException
	{
	
	/*****Login Page*****/
	//LoginPage loginPage = launchApplication(); -> handled as beforeMethod in BaseTest
	ProductPage productpage = loginPage.loginApplication("prashannarg@gmail.com","Passwo@179");
	Thread.sleep(1000);
	Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email or password.");   
	
	}
	
	@Test
	public void confirmationMsgValidation() throws InterruptedException
	{
		String productName = "zara coat 3";
		
		/*****Login Page*****/
		//LoginPage loginPage = launchApplication(); -> handled as beforeMethod in BaseTest
		ProductPage productpage = loginPage.loginApplication("prashannarg@gmail.com","Password@179");
		
		/*****Product Page*****/
		productpage.getListOfProducts();
		CartPage cartpage = productpage.getProductFromListOfProducts(productName);
		
		/*****Cart Page*****/
		cartpage.goToCartPage();
		CheckoutPage checkoutpage = cartpage.toCheckOut();
		
		/*****CheckOut Page*****/
		ConfirmationPage confirmationpage = checkoutpage.chooseCountry();
		
		/*****Confirmation Page*****/
		String confirmMessage = confirmationpage.toConfirm();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
}
