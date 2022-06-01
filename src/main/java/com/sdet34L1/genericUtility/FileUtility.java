package com.sdet34L1.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only Property fileSpecific common methods
 * @author Admin
 *
 */

public class FileUtility {
	static Properties property;
	/**
	 * This method is used to open the property file
	 * @param filePath
	 * @throws IOException 
	 */
	
	public static void  openPropertyFile(String filePath) throws IOException
	{
	FileInputStream fis = new FileInputStream(filePath);
	property = new Properties();
	property.load(fis);
	}
	/**
	 * This method is used to fetch the data from the property file
	 * @param key
	 * @return
	 */
	
	public static String getDataFromPropertyFile(String key) {
		String value = property.getProperty(key);
		return value;
	}

}
