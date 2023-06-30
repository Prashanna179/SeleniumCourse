import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//*[text()=' User']/..")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='Okay']")).click();

		Select a = new Select(driver.findElement(By.xpath("//*[@data-style='btn-info']")));
		a.selectByVisibleText("Consultant");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.id("signInBtn")).click();

		String items[] = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };

		addItems(driver, items);

	}

	public static void addItems(WebDriver driver, String[] items)

	{
		List<WebElement> ListofItems = driver.findElements(By.xpath("//h4[@class='card-title']"));
		List<String> itemsArrayList = Arrays.asList(items);
		int j = 0;
		for (WebElement i : ListofItems) 
		{
			String productName = i.getText();
			if (itemsArrayList.contains(productName)) 
			{
				driver.findElements(By.xpath("//button[text()='Add ']")).get(j).click();
			}
			j++;
		}

	}

}
