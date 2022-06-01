package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInformationPage {
	
	//
	@FindBy(id = "dltview_Title")
	private WebElement documentNameTxt;
	
	@FindBy(xpath = "//td[text()='Notes']/following-sibling::td/p")
	private WebElement documentDescriptionText;
	
		public DocumentInformationPage(WebDriver driver)
		{
			PageFactory.initElements( driver, this);
		}
		public String getDocumentName() 
		{
			return documentNameTxt.getText();
		}
		public String getDocumentDescription()
		{
			return documentDescriptionText.getText();
		}

}
