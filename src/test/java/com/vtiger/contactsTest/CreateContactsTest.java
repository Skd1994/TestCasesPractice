package com.vtiger.contactsTest;

import org.testng.annotations.Test;

import com.sdet34L1.genericUtility.BaseClass;
import com.sdet34L1.genericUtility.ExcelUtility;
import com.sdet34L1.genericUtility.JavaUtility;
import com.sdet34L1.genericUtility.WebDriverUtility;
import com.vtiger.POMRepository.ContactInformationPage;
import com.vtiger.POMRepository.ContactsPage;
import com.vtiger.POMRepository.CreateNewContactPage;
import com.vtiger.POMRepository.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;



public class CreateContactsTest extends BaseClass {
	
	
	
	ContactsPage contact;
	CreateNewContactPage createNewContactPage;
	ContactInformationPage contactInformationPage;
	String contactLastName;
	
	@Test(groups = "sanity" , description = "testng :- CreateContactsTest")
	@Description("Description:- CreateContactsTest")
	@Epic("Epic :- CreateContactsTest")
	@Story("Story :- CreateContactsTest")
	@Step("Step :- CreateContactsTest")
	@Severity(SeverityLevel.BLOCKER)
	public void createContactsTest()
	{
		contact = new ContactsPage(driver);
		createNewContactPage = new CreateNewContactPage(driver);
		contactInformationPage = new ContactInformationPage(driver);
		
		homepage.clickcontacts(driver);
		
		contact.clickCreateContacts();
		
		contactLastName = ExcelUtility.getdataFromExcel("contacts", 2, 1)+randomNumber;
		
		createNewContactPage.enterContactLastNameAndSave(contactLastName);
		
		webDriverUtility.waitUntillElementVisible(contactInformationPage.getContactNameInformation(webDriverUtility));
		
		jutil.assertionThroughIfCondition(contactInformationPage.getContactname(), contactLastName," contact Last Name");
	
	
	}
	

}
