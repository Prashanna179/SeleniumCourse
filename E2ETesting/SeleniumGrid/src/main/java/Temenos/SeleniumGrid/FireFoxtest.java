package Temenos.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FireFoxtest {

	@Test
	public void HomePageCheck() throws MalformedURLException	
	{
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setBrowserName("firefox");
		caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		//caps.setPlatform(Platform.WIN10);
	
		
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.139:4444"),caps);
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Prashan");
	//	driver.close();
		
		
	}
}
