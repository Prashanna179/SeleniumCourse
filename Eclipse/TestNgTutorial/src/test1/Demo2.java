package test1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2 {

	@Test(groups= {"Smoke"})
	public void Letchu()
	{
		System.out.println("Letchu");
	}
	
	@BeforeTest
	public void Surya()
	{
		System.out.println("Surya");
	}

	
}
