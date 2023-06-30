package Temenos.GlobalTest;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Temenos.PageObjectModel.StandAloneTest2.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver ;
	public LoginPage loginPage;
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;
	}
	
	public  WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Temenos\\PropertiesFile\\config.properties");
		prop.load(file);
		
		
		//Checking for Global Parameters form maven commands as well as Config Properties file
		String browserName = System.getProperty("browser")!=null?System.getProperty("browser"): prop.getProperty("browser");
		
		System.out.println(browserName);
		if(browserName.contains("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless"))
			{
			option.addArguments("headless");
		
			}
			driver = new ChromeDriver(option);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if (browserName.contains("firefox"))
		{
			FirefoxOptions option = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			if(browserName.contains("headless"))
			{
				option.addArguments("headless");
			}
			driver = new FirefoxDriver(option);	
		}
		else if(browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	 public List<HashMap<String, String>> getJsonToHashMap(String FilePath) throws IOException
	{
		//Json to jsonString
		String jsonContent = FileUtils.readFileToString(new File(FilePath),StandardCharsets.UTF_8);
		
		//String to HashMap -> Jackson DataBind dependency need to add in pom
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	 public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
		{
		 	
			TakesScreenshot ts = 	(TakesScreenshot)driver;
			File source =	ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName +".png"));
			return System.getProperty("user.dir") + "\\reports\\" + testCaseName +".png";
		}
	
	@AfterMethod(alwaysRun=true)
	public void closeWindow()
	{
		driver.close();
	}
	
	
}
