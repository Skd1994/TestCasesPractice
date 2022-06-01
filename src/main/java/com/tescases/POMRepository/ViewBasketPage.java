package com.tescases.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewBasketPage {
	@FindBy(xpath = "//a[@class='button wc-forward']")
	private WebElement clickonViewBasketBtn;
	
	public ViewBasketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonViewBasket(WebDriver driver)
	{
		
		clickonViewBasketBtn.click();
	}


}
