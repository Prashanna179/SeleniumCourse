package Temenos.PageObjectModel.StandAloneTest2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Temenos.UtlityMethods.UtlityMethods;

public class CheckoutPage extends UtlityMethods {
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public ConfirmationPage chooseCountry() throws InterruptedException
	{
		WebElement country = driver.findElement(By.xpath("//*[@placeholder='Select Country']"));
		country.sendKeys("India");
		driver.findElement(By.xpath("//*[text()=' India']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(1000);
		return new ConfirmationPage(driver);
	}
	
	
}
