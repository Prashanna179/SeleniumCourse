package test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo4 {

	
	//@BeforeClass
	@AfterClass
	public void BeforeClassPitch()
	{
		System.out.println("pitch");
	}
	@Test
	public void Ball()
	{
		System.out.println("Ball");		
	}
	
	@BeforeMethod
	//@AfterMethod
	public void beforeMethodCricket()
	{
		System.out.println("Cricket");
	}

	@Test(groups= {"Smoke"})
	public void Bat()
	{
		System.out.println("Bat");		
	}
	

	@Test
	public void Stump()
	{
		System.out.println("Stump");		
	}
	
}
