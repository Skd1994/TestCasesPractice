package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34L1.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage {
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropdownDrp;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropdownDrp;
	//constructor
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	//business library
	public void enterOrganizationName(String organizationName)
	{
		organizationNameTxt.sendKeys(organizationName);
		
	}
	public void selectIndustryDropdown(WebDriver driver)
	{
		WebDriverUtility.dropDownHandlebyValue("Education", industryDropdownDrp);
	}
	public void selectTypedropdown(WebDriver driver)
	{
		WebDriverUtility.dropDownHandlebyValue("Press", typeDropdownDrp);
	}
	public void save()
	{
		saveBtn.click();
	}

}
