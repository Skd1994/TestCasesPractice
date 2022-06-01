
	package com.tescases.POMRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	

	public class ShopPage {
		
		
		@FindBy(xpath = "//a[text()='Home']")
		private WebElement clickonHomeTxt;
	
		
		public ShopPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		public void clickHome(WebDriver driver)
		{
			
			clickonHomeTxt.click();
		}
		
		public WebElement getHomeLink(WebDriver driver)
		{
			return clickonHomeTxt;
		}


}
