package com.sdet34L1.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.vtiger.POMRepository.HomePage;
import com.vtiger.POMRepository.LoginPage;

public class GetterandSetterForListener implements ITestListener {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public FileUtility fileUtility;
	public ExcelUtility excelUtility;
	public JavaUtility javaUtility;
	public WebDriverUtility webDriverUtility;
	public int randomNumber;
	public static String username;
	public static String password;
	public String browser;
	public String url;
	public long longTimeout;
	
	private static GetterandSetterForListener instance;
	
	private GetterandSetterForListener() {}
	
	public static GetterandSetterForListener getinstance()
	{
		if(instance==null) {
			instance=new GetterandSetterForListener();
			
		}
		return instance;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver)
	{
		this.driver=driver;
	}
	public LoginPage getLoginPage()
	{
		return loginPage;
	}
	public void setLoginPage(LoginPage loginpage) {
		this.loginPage=loginPage;
	}
	
	public FileUtility getFileUtility() {
		return fileUtility;
	}
	public void setFileUtility(FileUtility fileUtility) {
		this.fileUtility=fileUtility;
	}
	public ExcelUtility getExcelUtility() {
		return excelUtility;
	}
	public void setExcelUtility(ExcelUtility excelUtility) {
		this.excelUtility=excelUtility;
	}
	public JavaUtility getJavaUtility() {
		return javaUtility;
	}
	public void setJavaUtility(JavaUtility javaUtility) {
		this.javaUtility=javaUtility;
	}
	public WebDriverUtility getWebDriverUtility() {
		return webDriverUtility;
	}
	public void setWebDriverUtility(WebDriverUtility webDriverUtility) {
		this.webDriverUtility=webDriverUtility;
	}
	public int getRandomNumber() {
		return randomNumber;
	}
	public void setRandomNumber(int randomNumber) {
		this.randomNumber=randomNumber;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		GetterandSetterForListener.username=username;
	}
	public static String getPassword() {
		return password;
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		/*fileUtility = new FileUtility();
		excelUtility = new ExcelUtility();
		javaUtility = new JavaUtility();
		
		excelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		fileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		url = fileUtility.getDataFromPropertyFile("url");
		String timeout = FileUtility.getDataFromPropertyFile("timeout");
		username = FileUtility.getDataFromPropertyFile("userName");
		password = FileUtility.getDataFromPropertyFile("password");
		browser = FileUtility.getDataFromPropertyFile("browser");
		longTimeout = javaUtility.stringToLong(timeout);
		randomNumber = javaUtility.getRandomnumber(1000);*/
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public Object getHomePage() {
		// TODO Auto-generated method stub
		return null;
	}



}
	
	
