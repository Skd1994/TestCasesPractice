package com.sdet34L1.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation  extends BaseClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("Reporter Name", "SKD ");
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("Unit Testing Tool", "TestNG");
		report.setSystemInfo("Build Management Tool", "Maven ");
		report.setSystemInfo("Automation Tool", "Selenium");
		
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart"+Thread.currentThread().getId());
		test = report.createTest(result.getMethod().getMethodName());

	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess"+Thread.currentThread().getId());
		test.log(Status.PASS, result.getMethod().getMethodName()+" is pass");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable()) ;
		result.getInstance();
		//WebDriverUtility webDriverUtility = new WebDriverUtility(BaseTestNGClass.staticdriver) ;
		//JavaUtility javaUtility = new JavaUtility();
		try {
			test.addScreenCaptureFromPath(new WebDriverUtility(BaseClass.class.cast(result.getMethod().getInstance()).driver).takeScreenShot(result.getMethod().getMethodName(), BaseClass.class.cast(result.getMethod().getInstance()).jutil));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish"+Thread.currentThread().getId());
		report.flush();
	
	}

}
