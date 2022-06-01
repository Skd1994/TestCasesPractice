package com.testcase.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

import com.sdet34L1.genericUtility.ExcelUtility;
/**
 * This class contains only java specific reusable methods
 * @author Admin
 *
 */

public class JavaUtility {
	
	/**
	 * This method is used to convert String value to long datatype
	 * @param value
	 * @return
	 */
	public long stringToLong(String value) {
		 return Long.parseLong(value); 
	}
	/**
	 * This method is used to get Random number
	 * @param limit
	 * @return
	 */
	
	public int getRandomnumber(int limit) {
		Random ran = new Random();
		return ran.nextInt(limit);
	}
	/**
	 * This method is used to print the message
	 * @param message
	 */
	public void printStatement(String message) {
		System.out.println(message);
	}
	public void assertionThroughIfCondition(String actualResult, String expectedResult, String testCaseName) {
		if(actualResult.equalsIgnoreCase(expectedResult))
		{
			System.out.println(testCaseName+" created Successfully");
			System.out.println("TC Pass");
		}
	}
	public void assertionThroughIfCondition(String sessionID, String value, int rowNumber , int cellNumber)
	{
		if(sessionID.contains("Home"))
		{
			ExcelUtility.createCell_Setcell("SheetName", rowNumber, cellNumber, "Create Contact page is displayed");
			ExcelUtility.createCell_Setcell("Contact Name", 6, 5, "TC pass");

			
		}
	}
	/**
	 * This method is used to wait until the element is clickable
	 * @param element
	 * @param Pollingtime
	 * @param duration
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element, long Pollingtime, int duration) throws InterruptedException
	{
		int count = 0;
		while(count<=duration) {
			try {
				element.click();
				break;
				
			}
			catch(Exception e) {
				Thread.sleep(Pollingtime*500);
				count++;
			}
			
		}
	}
	public String dateTimeInFormat() {
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
	}

}
