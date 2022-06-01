package com.sdet34L1.genericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.POMRepository.HomePage;
import com.vtiger.POMRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains implementation of all basic configuration annotations
 * @author Admin
 *
 */

public class BaseClass {
	
	public int randomNumber;
	public String password;
	public String username;
	public String browser;
	public long longtimeout;
	public WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public JavaUtility jutil;
	public static WebDriver staticdriver;
	
	public WebDriverUtility webDriverUtility ;
	
	/**
	 * In this annotation we open database,
	 * excel file,
	 * property file
	 */
	@BeforeSuite(groups = "baseclass")
	public void beforesuite1Test()
	{
		//open property file
		try {
			FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//open excel file
		try {
			ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * In this annotation we fetch the common data from property file,
	 * create the instance for all generic utility,
	 * launch browser,
	 * do browser settings,
	 * create instance for common object repository class
	 */
	//@Parameters("browser")
	@BeforeClass(groups = "baseclass")
	public void beforeclass1Test(/*String browser*/)
	{
		
		//create instance for all generic utility
		jutil = new JavaUtility();
		String url = FileUtility.getDataFromPropertyFile("url");
		String timeout = FileUtility.getDataFromPropertyFile("timeout");
		username = FileUtility.getDataFromPropertyFile("username");
		password = FileUtility.getDataFromPropertyFile("password");
		//browser = FileUtility.getDataFromPropertyFile("browser");
		longtimeout = jutil.stringToLong(timeout);
		randomNumber = jutil.getRandomnumber(10000);
		
		//To fetch from cmd prompt (command :- mvn test -DBROWSER=chrome -DUSERNAME=admin -DPASSWORD=root)
		browser = System.getProperty("BROWSER");
		username = System.getProperty("USERNAME");
		password = System.getProperty("PASSWORD");
		
        //launch browser instance
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
			default:
				System.out.println("pls specify proper broser key");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			
		}
		//browser setting(maximize, implicit wait, action class initialization, explicit wait)
		webDriverUtility= new WebDriverUtility(driver);
		WebDriverUtility.browserSetting(longtimeout, driver);
		webDriverUtility.initializeActions(driver);
		WebDriverUtility.explicitlyWait(driver, longtimeout);
		
		//create the instance for common object repository
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		
		//navigate to the application
		WebDriverUtility.navigateApp(url, driver);
	
		
	}
	
	/**
	 * In this annotation we do login action
	 */
	
	@BeforeMethod(groups = "baseclass")
	public void beforeMethod1Test()
	{
		loginpage.loginAction(username, password);
	}
	/**
	 * In this annotation we do signout action
	 */
	@AfterMethod(groups = "baseclass")
	public void afterMethod1Test()
	{
		homepage.signout(driver,webDriverUtility);
	}
	/**
	 * In this annotation we will close the browser instance
	 */
	@AfterClass(groups = "baseclass")
	public void afterClass1Test()
	{
		WebDriverUtility.quitBrowser(driver);
	}
	/**
	 * In this annotation we will close the excel sheet,
	 * close database,
	 * save excel data
	 */
	@AfterSuite(groups = "baseclass")
	public void aftersuite1Test()
	{
		
		ExcelUtility.saveExcelData(password);
		ExcelUtility.closeExcel();
		//close database connection code outside try/catch block
	}

}
