package com.tescases.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThinkinginHTMLPage {
	@FindBy(xpath = "//h3[text()='Thinking in HTML']")
	private WebElement clickonThinkinginHTMLTxt;
	
	public ThinkinginHTMLPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonThinkinginHTML(WebDriver driver)
	{
		
		clickonThinkinginHTMLTxt.click();
	}

}
