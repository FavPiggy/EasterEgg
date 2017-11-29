
package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import edu.uw.tacoma.piggy.model.entity.MemberRoleEntity;

/**
 * This class contains static method to check DAO for MemberRole.
 * @author Cuong Tran
 */
public class MemberRoleDAO
{
	/**
	 * The method checks DAO of MemberRole.
	 * @author Cuong Tran
	 * @return return arraylist of MemberRole.
	 * @throws Exception
	 */
	public static List<MemberRoleEntity> listMemberRole()
	{
		List<MemberRoleEntity> list = new ArrayList<MemberRoleEntity>();
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
			ResultSet results = stmt.executeQuery("select * from MemberRole");
			while (results.next())
			{
				MemberRoleEntity entity = new MemberRoleEntity();
				entity.setTaskID(results.getInt(1));
				entity.setMemberID(results.getInt(2));
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
	 * @return return array list of MemberRole.
	 * @param field the field specified.
	 * @param value the value specified.
	 * @throws Exception
	 */
	public static List<MemberRoleEntity> listMemberRole(String field, String value)
	{
		List<MemberRoleEntity> list = new ArrayList<MemberRoleEntity>();
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
			ResultSet results = stmt.executeQuery("select * from MemberRole where " + field + " = '" + value + "'");
			while (results.next())
			{
				MemberRoleEntity entity = new MemberRoleEntity();
				entity.setTaskID(results.getInt(1));
				entity.setMemberID(results.getInt(2));
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
