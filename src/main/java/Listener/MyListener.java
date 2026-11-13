package Listener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.Baseclass;

public class MyListener implements ITestListener ,ISuiteListener {
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	@Override 
	public void onStart(ISuite suite) {
		System.out.println("Suite onStart is executing");

		Date d = new Date();
		String newdate=d.toString().replace("", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./src/test/resources/Extentreports_"+newdate+".html");
		spark.config().setDocumentTitle("sauce_demo");
		spark.config().setReportName("testresults");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");
		
		Reporter.log("report config", true);
		
	}
	@Override
	public void onFinish(ISuite suite)
	{
		System.out.println("Suite onFinish is executing");
		report.flush();
		Reporter.log("report backup", true);
		 System.out.println("Extent report flushed successfully");
	}
	@Override
	public void onTestStart(ITestResult result)
	{
		test = report.createTest(result.getName());
		System.out.println("Test started :" + result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		Baseclass b =  (Baseclass) result.getInstance();
		WebDriver driver=b.driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File folder = new File("./src/test/resources/Screenshots");
		folder.mkdirs();
		File dest = new File("./src/test/resources/Screenshots/" + result.getName() + ".png");
	try {
		FileHandler.copy(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println("Test failed :" + result.getName());
		test.fail("test failed");
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test skipped :" + result.getName());
		test.skip("test skipped");
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test success :" + result.getName());
		test.pass("test passed");
	}

}
