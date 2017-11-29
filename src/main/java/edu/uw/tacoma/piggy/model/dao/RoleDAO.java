package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import edu.uw.tacoma.piggy.model.entity.RoleEntity;

/**
 * This class contains static method to check DAO for Role.
 * @author Cuong Tran
 */
public class RoleDAO
{
	/**
	 * The method checks DAO of Role.
	 * @author Cuong Tran
	 * @return return arraylist of Role.
	 * @throws Exception
	 */
	public static List<RoleEntity> listRole()
	{
		List<RoleEntity> list = new ArrayList<RoleEntity>();
		try
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
			ResultSet results = stmt.executeQuery("select * from Role");
			while (results.next())
			{
				RoleEntity entity = new RoleEntity();
				entity.setRoleID(results.getInt(1));
				entity.setRoleName(results.getString(2));
				entity.setDescription(results.getString(3));
				entity.setDateCreated(results.getDate(4));
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
	 * @return return array list of Role.
	 * @param field the field specified.
	 * @param value the value specified.
	 * @throws Exception
	 */
	public static List<RoleEntity> listRole(String field, String value)
	{
		List<RoleEntity> list = new ArrayList<RoleEntity>();
		try
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
			ResultSet results = stmt.executeQuery("select * from Role where " + field + " = '" + value + "'");
			while (results.next())
			{
				RoleEntity entity = new RoleEntity();
				entity.setRoleID(results.getInt(1));
				entity.setRoleName(results.getString(2));
				entity.setDescription(results.getString(3));
				entity.setDateCreated(results.getDate(4));
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
