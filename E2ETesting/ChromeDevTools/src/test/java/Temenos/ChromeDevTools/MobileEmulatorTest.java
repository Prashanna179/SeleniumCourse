package Temenos.ChromeDevTools;



import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.openqa.selenium.devtools.v113.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v113.emulation.model.ScreenOrientation;
import org.openqa.selenium.devtools.v113.page.model.Viewport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//DevTools chromeDevTools = ((ChromeDriver) driver).getDevTools();
		
		DevTools devTools =  driver.getDevTools();
		
		//Create Session
		
		devTools.createSession();
		
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.<Number> empty(),
	            Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
	            Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
	            Optional.<Viewport> empty(), Optional.<DisplayFeature> empty()));
		
		
					
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//*[@class='navbar-toggler-icon']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[text()='Library']")).click();
		
		
		
		
		
	
		
		
		
		

	}

}
