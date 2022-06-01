package com.tescases.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedtoCheckoutPage {
	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	private WebElement clickonProceedtoCheckoutBtn;
	
	public ProceedtoCheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonProceedtoCheckout(WebDriver driver)
	{
		
		clickonProceedtoCheckoutBtn.click();
	}

}
