package test1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1 {

		//@AfterSuite
		//@BeforeSuite
		//@AfterTest
		public void PrashanAfter()
		{
			System.out.println("PrashanAfter()");
		}
		@Test(groups= {"Smoke"})
		public void Prashan()
		{
		System.out.println("Prashanna");
		}
		
		
		@Test
		public void Dhivyan()
		{
			System.out.println("Dhivyan");
		}

}
