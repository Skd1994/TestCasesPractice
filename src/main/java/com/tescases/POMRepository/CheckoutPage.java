package com.tescases.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	@FindBy(id = "billing_first_name")
	private WebElement firstNameText ;
	
	@FindBy(xpath = "//h3[text()='Billing Details']")
	private WebElement billingDetailsTxt;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFirstNameTextbox(WebDriver driver)
	{
		
		return firstNameText;
	}
	public String getbillingDetails(WebDriver driver)
	{
		
		return billingDetailsTxt.getText();
	}

}
