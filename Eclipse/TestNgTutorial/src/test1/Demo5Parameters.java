package test1;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo5Parameters {

	@Parameters({"URL"})
	@Test
	public void ABC1(String urlName)
	{
		System.out.println("ABC1");
		System.out.println(urlName);
	}
	
	@Test
	public void ABC2()
	{
		System.out.println("ABC2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void ABC3()
	{
		System.out.println("ABC3");
	}
	
	@Test
	public void ABC4()
	{
		System.out.println("ABC4");
	}
	
}
