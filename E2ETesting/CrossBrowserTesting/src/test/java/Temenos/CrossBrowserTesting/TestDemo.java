package Temenos.CrossBrowserTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestDemo {
	
	//@Test
	/*public void titleCheck() throws MalformedURLException
	{
		MutableCapabilities caps = new MutableCapabilities();
		
		WebDriver driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),caps);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
	}*/
	
	
	@Test
	public void titleCheck()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Assert.assertTrue(driver.getTitle().matches("Google"));  
	}

}
