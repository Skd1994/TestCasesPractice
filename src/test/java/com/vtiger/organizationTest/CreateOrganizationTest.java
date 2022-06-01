package com.vtiger.organizationTest;

import org.testng.annotations.Test;

import com.sdet34L1.genericUtility.BaseClass;
import com.sdet34L1.genericUtility.ExcelUtility;
import com.sdet34L1.genericUtility.WebDriverUtility;
import com.vtiger.POMRepository.ContactInformationPage;
import com.vtiger.POMRepository.ContactsPage;
import com.vtiger.POMRepository.CreateNewContactPage;
import com.vtiger.POMRepository.CreateNewOrganizationPage;
import com.vtiger.POMRepository.OrganizationInformationPage;
import com.vtiger.POMRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{
	
	String actualOrgName;
	OrganizationPage organizationPage;
	CreateNewOrganizationPage createNewOrganizationPage;
	OrganizationInformationPage organizationInformationPage;
	
	@Test(groups = "regression")
	public void createOrganizationTest()
	{
		
		organizationPage = new OrganizationPage(driver);
		createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		organizationInformationPage = new OrganizationInformationPage(driver);
		
		homepage.clickorganizations(driver);
		
		organizationPage.createOrganizationImg();
		
		actualOrgName = ExcelUtility.getdataFromExcel("organization", 2, 1)+randomNumber;
		
		createNewOrganizationPage.enterOrganizationName(actualOrgName);
		
		createNewOrganizationPage.save();
		
		webDriverUtility.waitUntillElementVisible(organizationInformationPage.getOrganizationNameInformation(webDriverUtility));
		
		jutil.assertionThroughIfCondition(organizationInformationPage.getOrganizationname(), actualOrgName, "Organization");
		
	}
	
	
	

}
