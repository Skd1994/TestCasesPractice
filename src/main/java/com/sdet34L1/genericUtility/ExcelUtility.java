package com.sdet34L1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is used to maintain all excel specific common methods
 * @author Admin
 *
 */
public class ExcelUtility {
	static Workbook wb;
	/**
	 * This method is used to fetch the data from excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public static String getdataFromExcel(String sheetName, int rowNumber, int cellNumber) {
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return(data);
	}
	/**
	 * This method is used to open the Excel
	 * @param filepath
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public static void openExcel(String filepath) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream(filepath);
		wb = WorkbookFactory.create(fis1);
	}
	/**
	 * This method is used to fetch the multiple data from the excel sheet
	 * @param sheetName
	 * @return
	 */
	
	public static Object[][] getMultipleDataFromExcel(String sheetName)
	{
		Sheet sh = wb.getSheet(sheetName);
		Object[][] arr = new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
		for(int i = 0; i<sh.getLastRowNum()+1; i++)
		{
			for(int j = 0; j<sh.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}
	/**
	 * This method is used to create and set cell value into excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNum
	 * @param value
	 */
	public static void createCell_Setcell(String sheetName, int rowNumber, int cellNum, String value)
	{
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNum).setCellValue(value);
	}
	/**
	 * This method is used to write in the excel
	 * @param savepath
	 * @throws IOException
	 */
	public static void saveExcelData(String savepath) 
	{
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(savepath);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to Close the excel
	 * @throws IOException
	 */
	public static void closeExcel() 
	{
		try {
			wb.close();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("while closing excel exception occured..please check the ExcelUtility");
		}
	}

}
