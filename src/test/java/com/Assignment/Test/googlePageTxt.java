package com.Assignment.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googlePageTxt {
	
	@FindBy(xpath = "//input[@class='gLFyf gsfi']")
	private WebElement googleTxt;
	
	@FindBy(xpath = "(//input[@value='Google Search'])[1]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@data-ved='0ahUKEwjM34_3l-b3AhXaxIsBHYV2Bf8Q19QECA4']")
	private WebElement iamluckyBtn;
	
	@FindBy(xpath = "//div[@data-ved='0ahUKEwjM34_3l-b3AhXaxIsBHYV2Bf8Qvs8DCAY']")
	private WebElement searchbyvoiceImg;
	
	public googlePageTxt(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	public void googlePageAction(String data)
	{
		googleTxt.sendKeys(data);
		
	//	iamluckyBtn.click();
		//searchbyvoiceImg.click();
	}
	
	public void click()
	{
		searchBtn.click();
	}
	

}
