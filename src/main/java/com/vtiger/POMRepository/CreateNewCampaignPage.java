package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	
	//		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignName);
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignName;
	
	//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	public void createNewCampaign(String campaignname)
	{
		campaignName.sendKeys(campaignname);
		save.click();
	}
}
