package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34L1.genericUtility.WebDriverUtility;

//create the class as webpage name and make it as public

public class HomePage {
	

	//declare all the elements and specify the access specifier as private
	@FindBy(linkText = "More")
	private WebElement moreDropDown;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campainsTab;
	
	@FindBy(linkText = "Products")
	private WebElement productsTab;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsTab;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsTab;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsTab;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signOutLink;
	
	//initialize the driver address to all the elements through constructors and make it as public
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//business lib
	public void clickcampaign(WebDriver driver,WebDriverUtility webDriverUtility)
	{
		webDriverUtility.mouseHoveractions(moreDropDown, driver);
		campainsTab.click();
	}
	public void clickproduct(WebDriver driver)
	{
		productsTab.click();
	}
	public void clickorganizations(WebDriver driver)
	{
		organizationsTab.click();
	}
	public void clickcontacts(WebDriver driver)
	{
		contactsTab.click();
	}
	public void clickdocuments(WebDriver driver)
	{
		documentsTab.click();
	}
	public void signout(WebDriver driver,WebDriverUtility webDriverUtility)
	{
		webDriverUtility.mouseHoveractions(administratorIcon, driver);
		signOutLink.click();
	}

}
