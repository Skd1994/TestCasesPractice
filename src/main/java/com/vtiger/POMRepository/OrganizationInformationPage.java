package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34L1.genericUtility.WebDriverUtility;

public class OrganizationInformationPage {
	
	@FindBy(xpath ="//span[@id='dtlview_Organization Name']")
	private WebElement organizationNameTxt;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement organizationIndustryTxt;
	
	@FindBy(id ="dtlview_Type")
	private WebElement organizationTypeTxt;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationNameHeaderInfoText;
	
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	public String getOrganizationname()
	{
		return organizationNameTxt.getText();
	}
	public String getOrganizationIndustryName()
	{
		return organizationIndustryTxt.getText();
		
	}
	public String getOrganizationTypeName() {
		return organizationTypeTxt.getText();
	}
	public WebElement getOrganizationNameInformation(WebDriverUtility webDriverUtility)
	{
		return organizationNameHeaderInfoText;
	}

}
