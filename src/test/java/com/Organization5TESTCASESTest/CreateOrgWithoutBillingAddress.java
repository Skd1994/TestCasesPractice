package com.Organization5TESTCASESTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sdet34L1.genericUtility.BaseClass;
import com.sdet34L1.genericUtility.ExcelUtility;
import com.sdet34L1.genericUtility.FileUtility;
import com.sdet34L1.genericUtility.IconstantPath;
import com.sdet34L1.genericUtility.JavaUtility;
import com.sdet34L1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithoutBillingAddress extends BaseClass{
	@Test
	public  void main() throws EncryptedDocumentException, IOException {

		JavaUtility jutil = new JavaUtility();
		//path of properties file
		FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		//path of excel file
		ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		
		
		//fetch the data by using key
		String url = FileUtility.getDataFromPropertyFile("url");
		String username = FileUtility.getDataFromPropertyFile("username");
		String password = FileUtility.getDataFromPropertyFile("password") ;
		String timeout = FileUtility.getDataFromPropertyFile("timeout");
		String browser = FileUtility.getDataFromPropertyFile("browser");
		
		
		long longtimeout = jutil.stringToLong(timeout);
		int randomNumber = jutil.getRandomnumber(1000);
		

		WebDriver driver = null;
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			default:
			System.out.println("please specify proper browser key");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		WebDriverUtility.navigateApp(url, driver);
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.browserSetting(longtimeout, driver);
		
		
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//create organization without billing address
		driver.findElement(By.xpath("//td[@align='center']/a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		String OrganizationName = ExcelUtility.getdataFromExcel("organization", 6, 1);
		OrganizationName = OrganizationName+randomNumber;
		
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrganizationName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String Orgwithoutbillingaddress = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		System.out.println(Orgwithoutbillingaddress+" Updated Today");
	
		//logout from Application
		WebElement administratorpic = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility webdriverutility=new WebDriverUtility(driver);
		webdriverutility.initializeActions(driver);
		webdriverutility.mouseHoveractions(administratorpic, driver);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}
	

}
