package test1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo7Parameters {

	@Parameters({"URL"})
	@Test
	public void ABC8(String urlName)
	{
		System.out.println("ABC8");
		System.out.println(urlName);
	}
	
	@Test
	public void ABC9()
	{
		System.out.println("ABC9");
	}
	
	@Test
	public void ABC10()
	{
		System.out.println("ABC10");
	}
}
