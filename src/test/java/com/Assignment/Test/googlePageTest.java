package com.Assignment.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googlePageTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		googlePageTxt google = new googlePageTxt(driver);
		
	
	driver.get("https://www.google.com/");
	
	google.googlePageAction("abc");
	google.click();
	}
	
	 

}
