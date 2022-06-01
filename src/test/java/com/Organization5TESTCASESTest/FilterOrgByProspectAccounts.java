package com.Organization5TESTCASESTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sdet34L1.genericUtility.BaseClass;
import com.sdet34L1.genericUtility.ExcelUtility;
import com.sdet34L1.genericUtility.FileUtility;
import com.sdet34L1.genericUtility.IconstantPath;
import com.sdet34L1.genericUtility.JavaUtility;
import com.sdet34L1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterOrgByProspectAccounts extends BaseClass {
	@Test
	public void main() throws EncryptedDocumentException, IOException {

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
		
	

		//Filter Organization By Prospect Accounts
		driver.findElement(By.xpath("//td[@align='center']/a[text()='Organizations']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='viewname']"));
		WebDriverUtility.initializeSelect(dropdown);
		WebDriverUtility.dropDownHandlebyVisibleText(dropdown, "Prospect Accounts");
		driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
		
		//logout from Application
		WebElement administratorpic = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webDriverUtility.initializeActions(driver);
		webDriverUtility.mouseHoveractions(administratorpic, driver);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
