import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {

	public static void main(String[] args) throws IOException {
		

		
		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//driver.switchTo().newWindow(WindowType.TAB);
		//or
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> n = driver.getWindowHandles();
		Iterator<String> nn = n.iterator();
		
		String parentWindow = nn.next();
		String childWindow = nn.next();
		
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElement(By.xpath("(//h2//a[contains(@href,'https://courses.rahulshettyacademy.com/p/')])[1]")).getText();
		
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.name("name")).sendKeys(courseName);
		
		//screenshot
		File file = driver.findElement(By.name("name")).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\prashanna.ramesh\\name.png"));
		
		//get height
		System.out.println(driver.findElement(By.name("name")).getRect().getDimension().getHeight());
		System.out.println(driver.findElement(By.name("name")).getRect().getDimension().getWidth());
			
	}

}
