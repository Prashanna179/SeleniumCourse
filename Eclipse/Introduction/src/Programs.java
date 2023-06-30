import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Programs {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//********************************************
		
		driver.get("https://laulxval2.temenosgroup.com:37681/FOPM");
		driver.manage().window().maximize();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//input[contains(@id,'USER_NAME')]")).sendKeys("KUMARAVEL");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@name,'PASSWORD')]")).sendKeys("aaaaaa");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		Thread.sleep(50000);
		driver.findElement(By.xpath("//a[contains(@id,'DF')]//span[text()='Instruments']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@class=\"tc-mm-leaf\"][not(@style=\"display: none;\")]//*[@title=\"Held Assets\"]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[text()='Selected Instruments *']/../../../..//*[text()='Search']/..")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[text()='RESET']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[contains(@name,'ENTITIES[1].INSTRUMENTFILTERCRITERIA[1].VALUES[1].VALUE') and @aria-label='Value']")).sendKeys("100040-001");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@title='Apply']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='100040-001']/..//a")).click();
		Thread.sleep(10000);
		
		
		//Assert.assertEquals("Stock",driver.findElement(By.xpath("//h2[text()='Stock']")).getText());
		//Thread.sleep(3000);
		
		Assert.assertEquals("Stock", driver.findElement(By.xpath("//h2[text()='Stock']")).getText(),"Stock Heading Verification failed");
		
		
		/*List<WebElement> general = driver.findElements(By.xpath("//*[text()='General']/../../.."));
		System.out.println(general.size());
		for(WebElement i : general)
		{
			System.out.println(i.getText());
		}
		*/
		
		
		System.out.println(driver.findElement(By.xpath("//*[text()='General']/../../..")).getText().contains("N_AI_instr_subtype1"));
		
		
		//******************************************************
		
		/*int a[]= {1,2,3,4,5};
		int b[];
		b = new int[5];
		int sum=0;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(i!=j)
				{
					sum=sum+a[j];
				}
			}
			b[i]=sum;
			sum=0;
		}
		
		for(int c=0;c<b.length;c++)
		{
			System.out.println(b[c]);
		}
		*/
	
	}
}
