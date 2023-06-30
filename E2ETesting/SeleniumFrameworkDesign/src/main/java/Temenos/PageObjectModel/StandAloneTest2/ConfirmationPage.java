package Temenos.PageObjectModel.StandAloneTest2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Temenos.UtlityMethods.UtlityMethods;

public class ConfirmationPage extends UtlityMethods {

	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()=' Thankyou for the order. ']")
	WebElement confirmationHeader;
	
	public String toConfirm()
	{
		driver.findElement(By.cssSelector(".action__submit")).click();
		return confirmationHeader.getText();
		
	}
	
}
