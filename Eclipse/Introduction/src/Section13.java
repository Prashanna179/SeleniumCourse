import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Section13 {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		//co.setAcceptInsecureCerts(true);
		
		/*Proxy p = new Proxy();
		p.setHttpProxy("ipadress:4444");
		co.setCapability("proxy", p);*/
		

		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
	/*	driver.get("https://expired.badssl.com");
		
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\prashanna.ramesh\\screenshot.png"));
		
	*/	
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		//SoftAssertions
		/*SoftAssert a = new SoftAssert();
		
		a.assertTrue(false, "prashanna");
		System.out.println(driver.getTitle());
		a.assertTrue(false, "dhivyan");
		System.out.println(driver.getTitle());
		
		a.assertAll();*/
		
		
		List<WebElement> links = driver.findElements(By.xpath("//*[@class=' footer_top_agile_w3ls gffoot footer_style']//li//a"));
		//List<WebElement> links = driver.findElements(By.xpath("//*[text()='REST API']"));
			
		for(int i=1;i<links.size();i++)
		{
			
			String url = links.get(i).getAttribute("href");
			System.out.println(url);
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection)u.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int x = conn.getResponseCode();
			System.out.println(x);
			if(x>400)
			{
				System.out.println(url+"is broken");
			}
			
			else
			{
				System.out.println(url+"is not broken");
			}
		}	
		
	}

}
