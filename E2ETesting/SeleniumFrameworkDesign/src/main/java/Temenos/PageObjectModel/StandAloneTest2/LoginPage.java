package Temenos.PageObjectModel.StandAloneTest2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Temenos.UtlityMethods.UtlityMethods;

public class LoginPage extends UtlityMethods {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Temenos\\PropertiesFile\\config.properties");
		prop.load(file);
		String url = prop.getProperty("defaultURL");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement loginbutton;
	
	@FindBy(xpath="//*[contains(@class,'error')]")
	WebElement ErrorMessage;
	
	
	public ProductPage loginApplication(String Email, String Password)
	{
		userEmail.sendKeys(Email);
		userPassword.sendKeys(Password);
		loginbutton.click();
		return new ProductPage(driver);
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(ErrorMessage);
		return ErrorMessage.getText();
		
	}
	
}
