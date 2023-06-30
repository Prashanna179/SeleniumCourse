package Temenos.PageObjectModel.StandAloneTest2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Temenos.UtlityMethods.UtlityMethods;

public class ProductPage extends UtlityMethods {

	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]")
	List<WebElement> products;
	
	
	public List<WebElement> getListOfProducts()
	{
		
		return products;
	}
	
	public CartPage getProductFromListOfProducts(String productName)
	{
		waitForElementToAppear(By.xpath("//div[contains(@class,'mb-3')]"));
		
		WebElement product = products.stream().filter(prod->prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		/**need clarification on why xpath only is not working here correctly whereas other locators techniques are working fine**/
		//System.out.println(product.findElement(By.xpath("//b")).getText());
		System.out.println(product.findElement(By.tagName("b")).getText());
		//product.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementToAppear(By.id("toast-container"));
		waitForElementToDisappear(driver.findElement(By.cssSelector(".ng-animating")));
		return new CartPage(driver);
	}
	
	
	

}
