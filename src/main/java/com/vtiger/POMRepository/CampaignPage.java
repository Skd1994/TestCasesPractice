package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaign;
	
	//constructor initialize
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	 public void clickCreateCampaign()
	 {
		 createCampaign.click();
	 }

}
