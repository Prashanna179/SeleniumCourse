package Temenos.PageObjectModel.StandAloneTest2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Temenos.UtlityMethods.UtlityMethods;

public class OrderPage extends UtlityMethods {

	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProductPresentInOrderPage(String s)
	{
		Boolean b  = driver.findElement(By.xpath("//tbody")).getText().contains(s);
		return b;
	}

	
}
