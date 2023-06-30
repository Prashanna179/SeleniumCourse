import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class StreamsProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']/..")).click();
		List<WebElement> items = driver.findElements(By.xpath("//tbody//tr//td[1]"));
		/*List<String> orginalList = new ArrayList<String>();
		for(WebElement a : items)
		{
			String name = a.getText();
			orginalList.add(name);
		}*/
		//instead of above codes , we can use streams for optimization.
		
		List<String> orginalList = items.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = orginalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(orginalList.equals(sortedList));
		
		List<String> price;
		//price of beans.
		do
		{
			
		items = driver.findElements(By.xpath("//tbody//tr//td[1]"));
		price = items.stream().filter(s->s.getText().contains("Rice")).map(s->s.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		
		}while(price.size()<1);
		
		//filtering table 
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Beans");
		 List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

	        //1 results

	       List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Beans")).

	        collect(Collectors.toList());

	       //1 result

	       Assert.assertEquals(veggies.size(), filteredList.size());
		

	}

}
