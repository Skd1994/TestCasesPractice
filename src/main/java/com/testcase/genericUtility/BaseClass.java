package com.testcase.genericUtility;

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

import com.sdet34L1.genericUtility.ExcelUtility;
import com.sdet34L1.genericUtility.FileUtility;
import com.sdet34L1.genericUtility.IconstantPath;
import com.sdet34L1.genericUtility.JavaUtility;
import com.sdet34L1.genericUtility.WebDriverUtility;
import com.tescases.POMRepository.AddtoBasketPage;
import com.tescases.POMRepository.HTML5WebDevPage;
import com.tescases.POMRepository.ShopPage;
import com.tescases.POMRepository.ProceedtoCheckoutPage;
import com.tescases.POMRepository.HomePage;
import com.tescases.POMRepository.ThinkinginHTMLPage;
import com.tescases.POMRepository.ViewBasketPage;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public String browser;
	public long longtimeout;
	public WebDriver driver;
	public ShopPage shopPage;
	public AddtoBasketPage addtoBasketPage;
	public HTML5WebDevPage html5WebDevPage;
	public ProceedtoCheckoutPage proceedtoCheckoutPage;
	public HomePage homePage;
	public ThinkinginHTMLPage thinkinginHTMLPage;
	public ViewBasketPage viewBasketPage;
	
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
		browser = FileUtility.getDataFromPropertyFile("browser");
		longtimeout = jutil.stringToLong(timeout);
		
		//To fetch from cmd prompt (command :- mvn test -DBROWSER=chrome -DUSERNAME=admin -DPASSWORD=root)
		browser = System.getProperty("BROWSER");
		
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
		shopPage = new ShopPage(driver);
		addtoBasketPage = new AddtoBasketPage(driver);
		html5WebDevPage = new HTML5WebDevPage(driver);
		proceedtoCheckoutPage = new ProceedtoCheckoutPage(driver);
		homePage = new HomePage(driver);
		thinkinginHTMLPage = new ThinkinginHTMLPage(driver);
		viewBasketPage = new ViewBasketPage(driver);
		
		
		
		//navigate to the application
		WebDriverUtility.navigateApp(url, driver);
	
		
	}
	
	/**
	 * In this annotation we do login action
	 */
	
	@BeforeMethod(groups = "baseclass")
	public void beforeMethod1Test()
	{
		//loginpage.loginAction(username, password);
	}
	/**
	 * In this annotation we do signout action
	 */
	@AfterMethod(groups = "baseclass")
	public void afterMethod1Test()
	{
		//homepage.signout(driver,webDriverUtility);
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
		
		ExcelUtility.closeExcel();
		//close database connection code outside try/catch block
	}

}
