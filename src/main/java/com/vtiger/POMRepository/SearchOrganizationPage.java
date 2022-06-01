package com.vtiger.POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34L1.genericUtility.WebDriverUtility;

public class SearchOrganizationPage {

	@FindBy(id="search_txt")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public SearchOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	public void searchOrganizationAndSelect(String organizationvalue, WebDriver driver)
	{
		WebDriverUtility.switchToWindowBasedOnTitle(driver, "Accounts&action");
		searchTxt.sendKeys(organizationvalue);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+organizationvalue+"']")).click();
	}
}
