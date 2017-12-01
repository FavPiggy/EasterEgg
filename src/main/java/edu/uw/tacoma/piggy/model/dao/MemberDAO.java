package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.MemberEntity;

/**
 * This class contains static method to check DAO for Member.
 * @author Cuong Tran, Varik Hoang
 */
public class MemberDAO
{
	/**
	 * The method checks DAO of Member.
	 * @author Cuong Tran
	 * @return return arraylist of Member.
	 * @throws Exception
	 */
	public static List<MemberEntity> listMember()
	{
		List<MemberEntity> list = new ArrayList<MemberEntity>();
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
			ResultSet results = stmt.executeQuery("select * from Member");
			while (results.next())
			{
				MemberEntity entity = new MemberEntity();
				entity.setMemberID(results.getInt(1));
				entity.setProjectID(results.getInt(2));
				entity.setUserID(results.getInt(3));
				entity.setDateJoined(results.getDate(4));
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
	 * @return return array list of Member.
	 * @param field the field specified.
	 * @param value the value specified.
	 * @throws Exception
	 */
	public static List<MemberEntity> listMember(String field, String value)
	{
		List<MemberEntity> list = new ArrayList<MemberEntity>();
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
			ResultSet results = stmt.executeQuery("select * from Member where " + field + " = '" + value + "'");
			while (results.next())
			{
				MemberEntity entity = new MemberEntity();
				entity.setMemberID(results.getInt(1));
				entity.setProjectID(results.getInt(2));
				entity.setUserID(results.getInt(3));
				entity.setDateJoined(results.getDate(4));
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
