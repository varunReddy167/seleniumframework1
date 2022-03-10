package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener{

	ExtentReports extent= ExtentReporter.getExtentReport();
	ExtentTest ts;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
		
		String TestName=result.getName();
		
		 ts=extent.createTest(TestName+"Execution started");
		 extentTest.set(ts);
		
	}

	public void onTestSuccess(ITestResult result) {
		String TestName=result.getName();
	//	ts.log(Status.PASS, TestName+"got passed");
		extentTest.get().log(Status.PASS, TestName+"got passed");
	}

	public void onTestFailure(ITestResult result) {
		
		String TestName=result.getName();
		//ts.fail(result.getThrowable()+TestName);
		extentTest.get().fail(result.getThrowable()+TestName);;
		
		WebDriver driver = null;
		String testMethodName = result.getName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String ScreenshotFilePath=takeScreenshot(testMethodName,driver);
			//extentTest.get().addScreenCaptureFromPath(ScreenshotFilePath(testMethodName, driver)
					extentTest.get().addScreenCaptureFromPath(ScreenshotFilePath, testMethodName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
