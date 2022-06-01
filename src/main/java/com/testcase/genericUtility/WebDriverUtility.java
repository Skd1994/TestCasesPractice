package com.testcase.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to maintain all webdriver common actions
 * @author Admin
 *
 */
public class WebDriverUtility {
	public Actions act;
	static WebDriverWait wait;
	static WebDriver driver;
	static Select select = null;
	static JavascriptExecutor js;
	static JavaUtility jutil = new JavaUtility();

	
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	//static WebDriver driver;
	/**
	 * This method is used to initialize and launch the browser
	 * @param browser
	 
	
	public static void launchBrowser(String browser) {
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			default:
				System.out.println("please specify proper browser key");
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				 break;
		}
	}
	*/
	/**
	 * This method is used to return driver instance
	 * @param driver
	 * @return
	 */
	public static WebDriver getDriver(WebDriver driver) {
		return driver;
	}
	/**
	 * This method is used to navigate to the application
	 * @param url
	 * @param driver
	 */
	public static void navigateApp(String url, WebDriver driver) {
		driver.get(url);
	}
	/**
	 * This method is used to maximize the browser and implicitly wait 
	 * @param longtimeout
	 * @param driver
	 */
	public static void browserSetting(long longtimeout, WebDriver driver) {
		maximizeBrowser(driver);
		waitTillPageLoad(longtimeout, driver);
	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to implicitly wait till page load
	 * @param longtimeout
	 * @param driver
	 */
	public static void waitTillPageLoad(long longtimeout, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait the control till the particular element is clickable
	 * @param element
	 */
	
	public static void waitUntillElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to wait the control till the particular element is visible
	 * @param element
	 */
	public static void waitUntillElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to initialize wait instance
	 * @param driver
	 * @param timeout
	 */
	public static void explicitlyWait(WebDriver driver, long timeout) {
		wait = new WebDriverWait(driver, timeout);
	}
	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver, String partialText) {
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText));
			{
				break;
			}
		}
	}
	/**
	 * This method is used to initialize the Select class
	 * @param element
	 */
	public static void initializeSelect(WebElement element)
	{
		select = new Select(element);
	}
	/**
	 * This method is used to handle dropdown by Index values
	 * @param element
	 * @param index
	 */
	public static void dropDownHandlebyIndex(WebElement element, int index)
	{
		select.selectByIndex(index);
	}
	/**
	 * This method is used to handle dropdown by Value
	 * @param value
	 * @param element
	 */
	public static void dropDownHandlebyValue(String value, WebElement element)
	{
		select.selectByValue(value);
	}
	/**
	 * This method is used to handle dropdown by VisibleText
	 * @param element
	 * @param visibletext
	 */
	public static void dropDownHandlebyVisibleText(WebElement element, String visibletext)
	{
		select.selectByVisibleText(visibletext);
	}
	public static void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public static void switchToFrame(WebDriver driver, String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}
	public static void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to the main frame
	 * @param driver
	 */
	public static void switchBackToHome(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to initialize the Action class
	 * @param driver
	 */
	public  void initializeActions(WebDriver driver) {
		act = new Actions(driver);
	}
	
	/**
	 * This method is used to MousehoverAction
	 * @param element
	 * @param driver2 
	 * @param driver
	 */
	public  void mouseHoveractions(WebElement element, WebDriver driver2) {
		act.moveToElement(element).click().perform();
	}
	/**
	 * This method is used to Double click on the element
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		act.doubleClick(element).click().perform();
	}
	/**
	 * This method is used to close the browser instance
	 * @param driver
	 */
	public static void  quitBrowser(WebDriver driver) {
		driver.quit();
		
	}
	public static void intializeJs(WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
	}
	public static void enterDataThroughJs(WebElement element, String data)
	{
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	public static void clickThroughJs(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	public static void navigateApplicationThroughJs(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	public static void scrollToSpecifiedHeight(String height) 
	{
		js.executeScript("window.scrollBy(0,"+height+")");
	}
	public static void scrollToBottom()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public static void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * This method is used to take the screen shot
	 * @param fileName
	 * @param jutil2
	 * @return
	 * @throws IOException
	 */
	public static String takeScreenShot(String fileName, JavaUtility jutil2) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+fileName+"_"+((JavaUtility) jutil2).dateTimeInFormat()+".png");
		//System.out.println(dst.getAbsolutePath());
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	/**
	 * This method is used to accept the alert popup
	 */
	public void alertAccept()
	{
		driver.switchTo().alert().accept();
	}

}
