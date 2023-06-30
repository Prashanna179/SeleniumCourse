package test1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo3 {
	
	@Test(enabled = false)
	public void PrakashLogin()
	{
		System.out.println("PrakashLogin");
	}
	
	@Test
	public void PrakashLogout()
	{
		System.out.println("PrakashLogout");
	}
	
	@Test(groups= {"Smoke"})
	public void Karthick()
	{
		System.out.println("Karthick");
	}
	
	
	@Test
	public void Raghul()
	{
		System.out.println("Raghul");
	}

	
	@Test(dependsOnMethods = {"Raghul"})
	public void Abzar()
	{
		System.out.println("Abzar");
	}

}

