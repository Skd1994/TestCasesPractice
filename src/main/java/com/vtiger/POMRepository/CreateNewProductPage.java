package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(actproduct);
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productNameTxt;
	
	//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'")).click();
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	//business lib
	public void enterProductName(String productname)
	{
		productNameTxt.sendKeys(productname);
		saveBtn.click();
	}

}
