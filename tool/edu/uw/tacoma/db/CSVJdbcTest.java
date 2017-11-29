package edu.uw.tacoma.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.relique.jdbc.csv.CsvDriver;

import edu.uw.tacoma.piggy.model.entity.CategoryEntity;

public class CSVJdbcTest
{
	public static void test2() throws Exception
	{
		// Load the driver.
		Class.forName("org.relique.jdbc.csv.CsvDriver");

		// Create a connection. The first command line parameter is
		// the directory containing the .csv files.
		// A single connection is thread-safe for use by several threads.
		Connection conn = DriverManager.getConnection("jdbc:relique:csv:db");

		// Create a Statement object to execute the query with.
		// A Statement is not thread-safe.
		Statement stmt = conn.createStatement();

		// Select the ID and NAME columns from sample.csv
		ResultSet results = stmt.executeQuery("select * from category where ID>='1'");
		while (results.next())
			System.out.println(results.getString("Name"));

		conn.close();
	}
	
	public static void test1() throws Exception
	{
		// Load the driver.
		Class.forName("org.relique.jdbc.csv.CsvDriver");

		// Create a connection. The first command line parameter is
		// the directory containing the .csv files.
		// A single connection is thread-safe for use by several threads.
		Connection conn = DriverManager.getConnection("jdbc:relique:csv:db");

		// Create a Statement object to execute the query with.
		// A Statement is not thread-safe.
		Statement stmt = conn.createStatement();

		// Select the ID and NAME columns from sample.csv
		ResultSet results = stmt.executeQuery("select * from category where ID='1'");

		// Dump out the results to a CSV file with the same format
		// using CsvJdbc helper function
		boolean append = true;
		CsvDriver.writeToCsv(results, System.out, append);

		// Clean up
		conn.close();
	}
	public static ArrayList<CategoryEntity> listCategory() throws Exception {
		
		ArrayList<CategoryEntity> list = new ArrayList<CategoryEntity>();
		CategoryEntity cat = new CategoryEntity();
		// Load the driver.
		Class.forName("org.relique.jdbc.csv.CsvDriver");

		// Create a connection. The first command line parameter is
		// the directory containing the .csv files.
		// A single connection is thread-safe for use by several threads.
		Connection conn = DriverManager.getConnection("jdbc:relique:csv:db");

		// Create a Statement object to execute the query with.
		// A Statement is not thread-safe.
		Statement stmt = conn.createStatement();

		// Select the ID and NAME columns from sample.csv
		ResultSet results = stmt.executeQuery("select * from category where ID>='1'");
		while (results.next()) {
			cat.setCatID(results.getInt(1));
			cat.setCatName(results.getString(2));
			list.add(cat);
		}
		conn.close();
		return list;
	}
	public static void main(String[] args) throws Exception 
	{
		//System.out.println(listCategory());
		test2();
	}
}
