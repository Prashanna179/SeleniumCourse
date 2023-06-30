package Temenos.UtlityMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Temenos.PageObjectModel.StandAloneTest2.OrderPage;

public class UtlityMethods {

	WebDriver driver;
	public UtlityMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}
	
	@FindBy(xpath = "(//i[@class='fa fa-shopping-cart']/..)[1]")
	WebElement cartButton;
	
	@FindBy(xpath="//*[@routerlink='/dashboard/myorders']")
	WebElement ordersButton;
	
	public void goToCartPage()
	{
		cartButton.click();
	}
	
	public OrderPage goToOrdersPage()
	{
		ordersButton.click();
		return new OrderPage(driver);
	}
}
