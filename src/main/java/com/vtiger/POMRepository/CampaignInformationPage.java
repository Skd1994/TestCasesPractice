package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	//	String campnameexp = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement campaignNameText;
	
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	public String getCampaignName()
	{
		return campaignNameText.getText();
	}

}
