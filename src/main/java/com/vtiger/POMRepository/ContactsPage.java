package com.vtiger.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	 
	 @FindBy(xpath = "//img[@title='Create Contact...']")
	 private WebElement createcontacts;
	 
	 //constructor initialize
	 public ContactsPage(WebDriver driver)
	 {
		 PageFactory.initElements( driver,this);
	 }
	 
	 //methods
	 public void clickCreateContacts()
	 {
		 createcontacts.click();
	 }

}
