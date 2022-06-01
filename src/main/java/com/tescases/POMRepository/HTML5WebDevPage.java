package com.tescases.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HTML5WebDevPage {
	@FindBy(xpath = "//h3[text()='HTML5 WebApp Develpment']")
	private WebElement clickonHTML5WebAppDevTxt;
	
	public HTML5WebDevPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonHTML5WebAppDev(WebDriver driver)
	{
		
		clickonHTML5WebAppDevTxt.click();
	}

}
