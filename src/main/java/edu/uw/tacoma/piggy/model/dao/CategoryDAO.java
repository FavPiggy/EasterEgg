package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import static edu.uw.tacoma.piggy.PiggyUtilities.DateFormatter;
import edu.uw.tacoma.piggy.model.entity.CategoryEntity;

/**
 * This class contains static method to check DAO for Category.
 * @author Cuong Tran
 */
public class CategoryDAO
{
	/**
	 * The method checks DAO of Category.
	 * @author Cuong Tran
	 * @return return arraylist of Category.
	 * @throws Exception
	 */
	public static List<CategoryEntity> listCategory()
	{
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		try
		{

			// Load the driver.
			Class.forName("org.relique.jdbc.csv.CsvDriver");

			// Create a connection. The first command line parameter is
			// the directory containing the .csv files.
			// A single connection is thread-safe for use by several threads.
			Connection conn = DriverManager.getConnection(PiggyUtilities.getDriver());

			// Create a Statement object to execute the query with.
			// A Statement is not thread-safe.
			Statement stmt = conn.createStatement();

			// Select the ID and NAME columns from sample.csv
			ResultSet results = stmt.executeQuery("select * from category");
			while (results.next())
			{
				CategoryEntity entity = new CategoryEntity();
				entity.setCatID(results.getInt(1));
				entity.setCatName(results.getString(2));
				entity.setDescription(results.getString(3));
				entity.setDateCreated(DateFormatter.parse(results.getString(4)));
				list.add(entity);
			}

			conn.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return list;

	}

	/**
	 * The method checks DAO with specific information input.
	 * @author Cuong Tran
	 * @return return array list of Category.
	 * @param field the field specified.
	 * @param value the value specified.
	 * @throws Exception
	 */
	public static List<CategoryEntity> listCategory(String field, String value)
	{
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		try
		{

			// Load the driver.
			Class.forName("org.relique.jdbc.csv.CsvDriver");

			// Create a connection. The first command line parameter is
			// the directory containing the .csv files.
			// A single connection is thread-safe for use by several threads.
			Connection conn = DriverManager.getConnection(PiggyUtilities.getDriver());

			// Create a Statement object to execute the query with.
			// A Statement is not thread-safe.
			Statement stmt = conn.createStatement();

			// Select the ID and NAME columns from sample.csv
			ResultSet results = stmt.executeQuery("select * from category where " + field + " = '" + value + "'");
			while (results.next())
			{
				CategoryEntity entity = new CategoryEntity();
				entity.setCatID(results.getInt(1));
				entity.setCatName(results.getString(2));
				entity.setDescription(results.getString(3));
				entity.setDateCreated(DateFormatter.parse(results.getString(4)));
				list.add(entity);
			}

			conn.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return list;

	}

}
