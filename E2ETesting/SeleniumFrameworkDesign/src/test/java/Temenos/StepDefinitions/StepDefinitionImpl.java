package Temenos.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Temenos.GlobalTest.BaseTest;
import Temenos.PageObjectModel.StandAloneTest2.CartPage;
import Temenos.PageObjectModel.StandAloneTest2.CheckoutPage;
import Temenos.PageObjectModel.StandAloneTest2.ConfirmationPage;
import Temenos.PageObjectModel.StandAloneTest2.LoginPage;
import Temenos.PageObjectModel.StandAloneTest2.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {

	public LoginPage loginpage;
	public ProductPage productpage ;
	public CartPage cartpage;
	public CheckoutPage checkoutpage;
	public ConfirmationPage confirmationpage;
	public String confirmMessage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		loginpage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username , String password)
	{
		 productpage = 	loginpage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName)
	{
	 cartpage =   productpage.getProductFromListOfProducts(productName);
	}
	
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) throws InterruptedException
	{
		cartpage.goToCartPage();
		checkoutpage = cartpage.toCheckOut();
		confirmationpage = checkoutpage.chooseCountry();
		confirmMessage = confirmationpage.toConfirm();
	}
	
	@Then("{string} message is displayed in Confirmation Page")
	public void Message_is_displayed_in_confirmation_page(String string)
	{
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} is displayed")
	public void error_msg_is_displayed() throws InterruptedException
	{
		Thread.sleep(1000);
		Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email or password."); 
		driver.close();
	}
}
