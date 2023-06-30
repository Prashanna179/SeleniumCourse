package Temenos.ChromeDevTools;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetGeoLocation {

	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//40 3
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		/*Map<String,Object>coordinates = new HashMap<String,Object>();
		//40 3
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);*/
		
		devTools.send(Emulation.setGeolocationOverride(Optional.of((Number)40),
                Optional.of((Number)3),
                Optional.of((Number)1)));
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		
		driver.findElement(By.xpath("//h3[text()='Netflix - Watch TV Shows Online, Watch Movies Online']")).click();

	}

}
