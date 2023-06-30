package Temenos.ChromeDevTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.fetch.Fetch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), a->
		{
			if(a.getRequest().getUrl().contains("shetty"))
				{
				String mockedURL = a.getRequest().getUrl().replace("=shetty", "=BadGuy");
				devTools.send(Fetch.continueRequest(a.getRequestId(), Optional.of(mockedURL), Optional.of(a.getRequest().getMethod()), Optional.empty(), Optional.empty(),Optional.empty()));
				}
			else
			{
				devTools.send(Fetch.continueRequest(a.getRequestId(), Optional.of(a.getRequest().getUrl()) , Optional.of(a.getRequest().getMethod()), Optional.empty(), Optional.empty(),Optional.empty()));
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}

}
