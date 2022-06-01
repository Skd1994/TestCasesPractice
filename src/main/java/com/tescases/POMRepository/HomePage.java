package com.tescases.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34L1.genericUtility.WebDriverUtility;

public class HomePage {
	@FindBy(xpath = "//a[text()='Shop']")
	private WebElement clickonShopTxt ;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickShop(WebDriver driver)
	{
		
		clickonShopTxt.click();
	}

}
