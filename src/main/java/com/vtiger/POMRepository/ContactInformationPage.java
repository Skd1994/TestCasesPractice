package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34L1.genericUtility.WebDriverUtility;

public class ContactInformationPage {
	
	@FindBy(xpath ="//span[@id='dtlview_Last Name']")
	private WebElement contactLastNameTxt;
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement contactNameHeaderInfoTxt;
	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	public String getContactname()
	{
		return contactLastNameTxt.getText();
	}
	public WebElement getContactNameInformation(WebDriverUtility webDriverUtility)
	{
		return contactNameHeaderInfoTxt;
	}
	
}
