package com.vtiger.POMRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34L1.genericUtility.WebDriverUtility;

public class CreateNewDocumentPage {
	
	//input[@name='notes_title']")).sendKeys(Title)
	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement documentNameTxt;
	
	@FindBy(xpath = "//iframe[contains(@title,'Rich text editor')]")
	private WebElement frameFrm;
	
	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement docDescriptionTxt;
	
	@FindBy(xpath = "//a[@id='cke_5']/span[@class='cke_icon']")
	private WebElement boldIcon;
	
	@FindBy(xpath = "//a[@id='cke_6']/span[@class='cke_icon']")
	private WebElement italicIcon;
	
	@FindBy(xpath = "//input[@id='filename_I__']")
	private WebElement chooseFileBtn;
	
	//input[@title='Save [Alt+S]']"
	@FindBy(xpath = "//b[.='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//constructor
	public CreateNewDocumentPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	public void createNewDocument(String documentname)
	{
		documentNameTxt.sendKeys(documentname);
	}
	
	public void enterDocumentDescription(WebDriver driver, String documentDescription)
	{
		WebDriverUtility.switchToFrame(driver, frameFrm);
		docDescriptionTxt.sendKeys(documentDescription,Keys.CONTROL+"a");
		WebDriverUtility.switchBackToHome(driver);
	}
	public void boldAndItalic()
	{
		boldIcon.click();
		italicIcon.click();
	}
	public void chooseFile(String documentPath)
	{
		chooseFileBtn.sendKeys(documentPath);
	}
	public void enterDocumentTitleNameAndSave(String documentTitleName)
	{
		documentNameTxt.sendKeys(documentTitleName);
		saveBtn.click();
	}
	public void saveDocument()
	{
		saveBtn.click();
	}

}
