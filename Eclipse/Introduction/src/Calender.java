import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
	//	Actions a = new Actions(driver);
	//	a.moveToElement(driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"))).build().perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).sendKeys("03/30/2023");
		
		
		//driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']/..")).click();
		
		while(!driver.findElement(By.xpath("//*[@class='flatpickr-current-month']")).getText().contains("December"))
		{
			driver.findElement(By.xpath("(//*[@class='flatpickr-next-month']//*)[1]")).click();
		}
		
		List<WebElement> day = driver.findElements(By.xpath("//*[contains(@class,'flatpickr-day ')]"));
		for(WebElement n : day)
		{
			if(n.getText().equalsIgnoreCase("23"))
			{
				n.click();
			}
		}
		

	}

}
