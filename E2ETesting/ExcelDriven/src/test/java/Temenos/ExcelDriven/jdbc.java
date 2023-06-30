package Temenos.ExcelDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jdbc {

	@Test
	public void loginApp() throws SQLException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		String s[] = getDataFromDb("name","location");
		driver.findElement(By.id("username")).sendKeys(s[0]);
		driver.findElement(By.id("password")).sendKeys(s[1]);
	}
	
	public  String[] getDataFromDb(String name , String location) throws SQLException {
		
		String a[] = new String[2];
		String host="localhost";
		String port = "3306";
		//Connecting database to the server from java application 
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host +":" + port + "/qadb", "root", "Password@179");
		
		//Connection URL syntax 
		//"jdbc:mysql://"+host+":"+port+"/databasename";
		
		Statement s = con.createStatement();
		
		ResultSet r = s.executeQuery("select * from employee where id =1");
		while(r.next())
		{
		a[0]=r.getString(name);
		a[1]=r.getString(location);
		}
		
		return a;
		}

	@Test(dataProvider = "giveDataFromDb")
	//public void loginAppUsingDataProvider(String name , String location) throws SQLException
	public void loginAppUsingDataProvider(HashMap<String,String> h) throws SQLException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		//driver.findElement(By.id("username")).sendKeys(name);
		//driver.findElement(By.id("password")).sendKeys(location);
		
		driver.findElement(By.id("username")).sendKeys(h.get("name"));
		driver.findElement(By.id("password")).sendKeys(h.get("password"));
		
		
	}
	
		@DataProvider
		//public  Object[][] giveDataFromDb() throws SQLException {
		public  Object[] giveDataFromDb() throws SQLException {
		
		//First Implementation
			
	   // Object o[][]= {{"Dhivyan","Dhivyan@179"},{"Letchu","Letchu@179"}};
	   // return o;
			
		//Second Implementation - HashMap
			
		HashMap<String,String> h =  new HashMap<String,String>();
		ArrayList<HashMap> l = new ArrayList<HashMap>();
		String host="localhost";
		String port = "3306"; 
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host +":" + port + "/qadb", "root", "Password@179");
		
		Statement s = con.createStatement();
		
		ResultSet r = s.executeQuery("select * from employee");
		while(r.next())
		{
		h.put("name",r.getString("name"));
		h.put("password",r.getString("location"));
		l.add(h);
		h=new HashMap<String,String>();
		}
		
		System.out.println(l);
		
		Object o[] =  new Object[l.size()];
		int j=0;
		for(HashMap<String,String> i : l)
		{
			o[j]=i;
			j++;
		}
		//Object o[] = {l.get(0),l.get(1),l.get(2)};
		return o;
}
		
}
	
	

