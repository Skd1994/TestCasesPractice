package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.sdet34L1.genericUtility.DatabaseUtility;
import com.sdet34L1.genericUtility.FileUtility;
import com.sdet34L1.genericUtility.IconstantPath;
import com.sdet34L1.genericUtility.JavaUtility;
import com.sdet34L1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInDatabaseWRTGUI {
	public static void main(String[] args) throws IOException, SQLException, InterruptedException {
		JavaUtility jutil = new JavaUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String projectName = "SDET34L1-"+jutil.getRandomnumber(1000);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
		
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Sanjay");
		WebElement projectStatusdropDown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		
		Select select = new Select(projectStatusdropDown);
		select.selectByVisibleText("Created");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		FileUtility.openPropertyFile(IconstantPath.RMGYANTRAPROPERTYFILEPATH);
		DatabaseUtility.openDBConnection(IconstantPath.DATABASEURL+FileUtility.getDataFromPropertyFile("dbName"),FileUtility.getDataFromPropertyFile("dbUserName"),FileUtility.getDataFromPropertyFile("dbPassword"));
			//execute the querry
			boolean status = DatabaseUtility.validateDataInDatabase("select project_name from project;", "project_name", projectName);
			
			
			//validate the project name
			
			if(status==true)
			{
					System.out.println("TC pass");
				
			}
			else
			{
				System.out.println("TC fail");
			}
			
			
			
			
		DatabaseUtility.closeDBConnection();
		WebDriverUtility.quitBrowser(driver);
	}
}
		
		
	


