import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ScrollandJS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,700)");
		
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		
		
		List<WebElement> values =  driver.findElements(By.xpath("//*[@class='tableFixHead']//td[4]"));
		
		int sum=0;
		for(WebElement n : values)
		{
			sum = sum + Integer.parseInt(n.getText());
			
		}
		System.out.println(sum);
		Assert.assertEquals(Integer.parseInt( driver.findElement(By.xpath(" //*[text()=' Total Amount Collected: 296 ']")).getText().split(":")[1].trim()), sum);
		
		
		System.out.println(driver.findElements(By.xpath("//*[@name='courses']//tr")).size());
		System.out.println(driver.findElements(By.xpath("//*[@name='courses']//th")).size());
		
		
		System.out.println(driver.findElement(By.xpath("//*[@name='courses']//tr[3]")).getText());
			
		driver.findElement(By.xpath(" //*[@id='autocomplete']")).sendKeys("Uni");
		Thread.sleep(1000);
		driver.findElement(By.xpath(" //*[@id='autocomplete']")).sendKeys(Keys.DOWN);
		
		//driver.findElement(By.xpath("//*[text()='United Kingdom (UK)'])[1]")).click();
		
		System.out.println(driver.findElement(By.xpath(" //*[@id='autocomplete']")).getAttribute("value"));
	
	
		//Autocomplete
		/*driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='fsw_inputBox searchCity inactiveWidget ']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Lon");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='London, Canada']/..")).click();
		*/
		}

}
