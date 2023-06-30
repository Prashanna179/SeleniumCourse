package Temenos.GlobalTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportsNG.getReportObject();
	//ThreadLocal extentTest = new ThreadLocal();
	//To avoid concurrency thread local class is used
	ThreadLocal<ExtentTest> t = new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		//Create an entry for Html report 
		test = extent.createTest(result.getMethod().getMethodName());
		t.set(test); //unique thread id created
	  }
	
	@Override
	public void onTestSuccess(ITestResult result) {
	   // test.log(Status.PASS, result.getMethod().getMethodName() + " Testcase is passed" );
		t.get().log(Status.PASS, result.getMethod().getMethodName() + " Testcase is passed" );
	  }
	
	@Override
	public void onTestFailure(ITestResult result) {
		t.get().fail(result.getThrowable());
		 
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 /**Attach Screenshot Step**/
		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//attaching screenshot to the report
		t.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName() );
	  }
	
	@Override
	public void onFinish(ITestContext context) {
	   extent.flush();
	  }
	
	
	
}
