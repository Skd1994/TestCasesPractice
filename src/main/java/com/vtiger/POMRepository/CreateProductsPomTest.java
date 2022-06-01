package com.vtiger.POMRepository;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.sdet34L1.genericUtility.ExcelUtility;
import com.sdet34L1.genericUtility.FileUtility;
import com.sdet34L1.genericUtility.IconstantPath;
import com.sdet34L1.genericUtility.JavaUtility;
import com.sdet34L1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductsPomTest {
	public static void main(String[] args) throws IOException {

		
	JavaUtility jutil = new JavaUtility();
	
	
	FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
	ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		
		
		//fetch the data by using key
		String url = FileUtility.getDataFromPropertyFile("url");
		String username = FileUtility.getDataFromPropertyFile("username");
		String password = FileUtility.getDataFromPropertyFile("password") ;
		String timeout = FileUtility.getDataFromPropertyFile("timeout");
		String browser = FileUtility.getDataFromPropertyFile("browser");
		
		
		
		long longtimeout = jutil.stringToLong(timeout);
		int randomNumber = jutil.getRandomnumber(1000);
		
		
		
		
		
		
		WebDriver driver= null;
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(); 
		}
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
		WebDriverUtility.navigateApp(url, driver);
		

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		ProductPage productssPage = new ProductPage(driver);
		CreateNewProductPage createNewProductPage = new CreateNewProductPage(driver);
		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		
		login.loginAction(username, password);
		
		home.clickproduct(driver);
		
		productssPage.clickCreateProduct();
		
		String productName = ExcelUtility.getdataFromExcel("products", 2, 1)+randomNumber;
		
		createNewProductPage.enterProductName(productName);
		
		
		
		jutil.assertionThroughIfCondition(productInformationPage.getProductName(), productName, "products");
	
	   
		home.signout(driver, null);
		
		ExcelUtility.closeExcel();
		
		WebDriverUtility.quitBrowser(driver);
		
	}

}
