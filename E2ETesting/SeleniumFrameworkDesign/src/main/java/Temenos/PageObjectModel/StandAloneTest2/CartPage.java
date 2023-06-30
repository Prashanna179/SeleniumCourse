package Temenos.PageObjectModel.StandAloneTest2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Temenos.UtlityMethods.UtlityMethods;

public class CartPage extends UtlityMethods {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[text()='Checkout']")
	WebElement checkOutButton;
	
	public CheckoutPage toCheckOut()
	{
		checkOutButton.click();
		return new CheckoutPage(driver);
	}

	
}
