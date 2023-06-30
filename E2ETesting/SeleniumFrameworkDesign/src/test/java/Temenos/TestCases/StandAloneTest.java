package Temenos.TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		String s = "zara coat 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*****Login Page*****/
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("prashannarg@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Password@179");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		/*****Product Page*****/
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(s)).findFirst().orElse(null);
		prod.findElement(By.xpath("//*[text()=' Add To Cart']")).click();
		
		
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		/*****Cart Page*****/
		driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart']/..)[1]")).click();
		driver.findElement(By.xpath("//*[text()='Checkout']")).click();
		
		
		/*****CheckOut Page*****/
		
		WebElement country = driver.findElement(By.xpath("//*[@placeholder='Select Country']"));
		
		/*Country Autocomplete Search
		/country.sendKeys("India");
		Thread.sleep(2000);
		country.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		country.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		country.sendKeys(Keys.ENTER);
		Thread.sleep(2000);*/
		
		country.sendKeys("India");
		driver.findElement(By.xpath("//*[text()=' India']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'action__submit')]")).click();
		
		/*****Confirmation Page*****/
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Thankyou for the order. ']")).getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();
	}
	
}
