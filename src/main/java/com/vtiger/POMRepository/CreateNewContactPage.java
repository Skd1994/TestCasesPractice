package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactLastNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@title='Select']")
	private WebElement clickorganizationLookupImg;
	
	//constructor
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	public void enterContactLastNameAndSave(String contactLastName)
	{
		contactLastNameTxt.sendKeys(contactLastName);
		saveBtn.click();
	}
	public  void enterContactLastName(String contactLastName) {
		
		contactLastNameTxt.sendKeys(contactLastName);
		
	}
	public void enterContactNameAndSwitchToSearchOrganization(String contactLastName, WebDriver driver)
	{
		contactLastNameTxt.sendKeys(contactLastName);
		clickorganizationLookupImg.click();
	}
	public void saveContact()
	{
		saveBtn.click();
	}
	public static void createNewcontactPage(String contactLastName) {
		// TODO Auto-generated method stub
		
	}

}
