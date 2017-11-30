package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.UserEntity;

/**
 * This class contains static method to check DAO for User.
 * @author Cuong Tran, Varik Hoang
 */
public class UserDAO
{
	/**
	 * The method checks DAO of User.
	 * @author Cuong Tran
	 * @return return arraylist of User.
	 * @throws Exception
	 */
	public static List<UserEntity> listUser()
	{
		List<UserEntity> list = new ArrayList<UserEntity>();
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
			ResultSet results = stmt.executeQuery("select * from User");
			while (results.next())
			{
				UserEntity entity = new UserEntity();
				entity.setUserID(results.getInt(1));
				entity.setFirstName(results.getString(2));
				entity.setLastName(results.getString(3));
				entity.setPhoneNumber(results.getString(4));
				list.add(entity);
			}

			conn.close();
		}
		catch (Exception ex)
		{
		}

		return list;

	}

	/**
	 * The method checks DAO with specific information input.
	 * @author Cuong Tran
	 * @return return array list of User.
	 * @param field the field specified.
	 * @param value the value specified.
	 * @throws Exception
	 */
	public static List<UserEntity> listUser(String field, String value)
	{
		List<UserEntity> list = new ArrayList<UserEntity>();
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
			ResultSet results = stmt.executeQuery("select * from User where " + field + " = '" + value + "'");
			while (results.next())
			{
				UserEntity entity = new UserEntity();
				entity.setUserID(results.getInt(1));
				entity.setFirstName(results.getString(2));
				entity.setLastName(results.getString(3));
				entity.setPhoneNumber(results.getString(4));
				list.add(entity);
			}

			conn.close();
		}
		catch (Exception ex)
		{
		}

		return list;

	}

}
