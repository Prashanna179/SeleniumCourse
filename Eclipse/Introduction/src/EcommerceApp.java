import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EcommerceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Refer Section 8 : Code download [ Amazon products add to cart practical question]
		System.setProperty("webdriver.chrome.driver", "C:\\UserDrive\\Prashan\\drivers\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		System.out.println(co.getBrowserName());
		
		String names[]= {"Cucumber","Brocolli"};
		
	
		/*System.out.println(products.size());
		for(WebElement a : products)
		{
			System.out.println(a.getText());
		}*/
		
		//Convert Array into ArrayList
		List<String> L = Arrays.asList(names);
		
		System.out.println(L.get(0));
		
		for(int i=0;i<products.size();i++)
		{
			for(int j=0;j<names.length;j++)
			{
			String name = products.get(i).getText();
			
			if(name.contains(names[j]))
			{
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
			}
		}
		
		
		
	}

}
