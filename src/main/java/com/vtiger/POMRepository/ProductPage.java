package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProduct;
	
	//constructor initialize
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	//business lib
	public void clickCreateProduct()
	{
		createProduct.click();
	}

}
