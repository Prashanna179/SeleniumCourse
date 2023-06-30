import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WindowsHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(co);
		
		//Course Program
		
		/*driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		Set<String> windows = driver.getWindowHandles(); //parent id and child id
		String name[]=new String[windows.size()];
		int j=0;
		for(String a : windows)
		{
			name[j]=a;
			j++;
		}
		
		driver.switchTo().window(name[1]);
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		
		String emailID=driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("@")[1].split(" ")[0].trim();
		
		driver.switchTo().window(name[0]);
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		*/
		
		//Example Program
		
		driver.get("https://the-internet.herokuapp.com/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[text()='Multiple Windows']"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
		
		
		
	}

}
