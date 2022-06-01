package com.sdet34L1.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains all common action related to database
 * @author Admin
 *
 */

public class DatabaseUtility {
	
	static Connection connection;
	static Statement statement;
	/**
	 * This method is used to open the database connection and intiallize the connection, statement
	 * @param dbUrl
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException 
	 */
	public static void openDBConnection(String dbUrl, String dbUserName, String dbPassword) throws SQLException
	{
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		statement = connection.createStatement();
		
	}
	/**
	 * This method is used to fetch the data from database/to do the DQL actions on database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException 
	 */
	
	public static ArrayList<String> getDataFromDataBase(String query, String columnName) throws SQLException
	{
		ArrayList<String> list = new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}
	/**
	 * This method is used to validate the data wheather it is present in database or not
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public static boolean validateDataInDatabase(String query, String columnName, String expectedData) throws SQLException
	{
		ArrayList<String> list = getDataFromDataBase(query, columnName);
		boolean flag = false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag = true;
				break;
			}
		}
		return flag;
	}
	/**
	 * This method is used to store/modify/insert/delete the data in database/to do the DML and DDL actions on database
	 * @param query
	 * @throws SQLException 
	 */
	public static void setDataInDataBase(String query) throws SQLException
	{
	int result = statement.executeUpdate(query);
	if(result>=1) {
		System.out.println("Data entered/modified successfully");
	}
	}
	/**
	 * This method is used to close the Database connection
	 */
	public static void closeDBConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("While closing the Database connection we got exception");
		}
	}

}
