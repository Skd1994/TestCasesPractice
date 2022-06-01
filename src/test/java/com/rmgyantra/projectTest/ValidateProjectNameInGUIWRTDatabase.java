package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;
import com.sdet34L1.genericUtility.DatabaseUtility;
import com.sdet34L1.genericUtility.ExcelUtility;
import com.sdet34L1.genericUtility.FileUtility;
import com.sdet34L1.genericUtility.IconstantPath;
import com.sdet34L1.genericUtility.JavaUtility;
import com.sdet34L1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ValidateProjectNameInGUIWRTDatabase {
	public static void main(String[] args) throws SQLException, EncryptedDocumentException, IOException {
		JavaUtility jutil = new JavaUtility();
		FileUtility.openPropertyFile(IconstantPath.RMGYANTRAPROPERTYFILEPATH);
		ExcelUtility.openExcel(IconstantPath.RMGYANTRA_EXCELFILE_PATH);
		int randomNumber = jutil.getRandomnumber(1000);
		String projectName = ExcelUtility.getdataFromExcel("projects", 1, 1)+"_"+randomNumber;
		System.out.println(projectName);
		DatabaseUtility.openDBConnection(IconstantPath.DATABASEURL+FileUtility.getDataFromPropertyFile("dbName"), FileUtility.getDataFromPropertyFile("dbUserName"), FileUtility.getDataFromPropertyFile("dbPassword"));
		
		DatabaseUtility.setDataInDataBase("insert into project values('TY_PROJ_"+randomNumber+"','Sanjay','28/04/2022','"+projectName+"','on Going',12);");
		DatabaseUtility.closeDBConnection();
		
			
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			WebDriverUtility.browserSetting(10, driver);
			WebDriverUtility.navigateApp("http://localhost:8084", driver);
			
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			driver.findElement(By.xpath("//a[text()='Projects']")).click();
			
			List<WebElement> listOfProjects = driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
			for(WebElement project : listOfProjects)
			{
				if(project.getText().equalsIgnoreCase(projectName))
				{
					System.out.println("Project Name is visible in GUI");
					System.out.println("TC Pass");
					break;
					
				}
			}
			
		
		WebDriverUtility.quitBrowser(driver);
		
	}

}
