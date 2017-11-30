package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.ProjectEntity;

/**
 * This class contains static method to check DAO for Project.
 * @author Cuong Tran, Varik Hoang
 */
public class ProjectDAO
{
	/**
	 * The method checks DAO of Project.
	 * @author Cuong Tran
	 * @return return arraylist of Project.
	 * @throws Exception
	 */
	public static List<ProjectEntity> listProject()
	{
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
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
			ResultSet results = stmt.executeQuery("select * from Project");
			while (results.next())
			{
				ProjectEntity entity = new ProjectEntity();
				entity.setProjectID(results.getInt(1));
				entity.setProjectName(results.getString(2));
				entity.setProjectAbbr(results.getString(3));
				entity.setDescription(results.getString(4));
				entity.setStartDate(results.getDate(5));
				entity.setCategoryID(results.getInt(6));
				entity.setDateCreated(results.getDate(7));
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
	 * @return return array list of Project.
	 * @param field the field specified.
	 * @param value the value specified.
	 * @throws Exception
	 */
	public static List<ProjectEntity> listProject(String field, String value)
	{
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
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
			ResultSet results = stmt.executeQuery("select * from Project where " + field + " = '" + value + "'");
			while (results.next())
			{
				ProjectEntity entity = new ProjectEntity();
				entity.setProjectID(results.getInt(1));
				entity.setProjectName(results.getString(2));
				entity.setProjectAbbr(results.getString(3));
				entity.setDescription(results.getString(4));
				entity.setStartDate(results.getDate(5));
				entity.setCategoryID(results.getInt(6));
				entity.setDateCreated(results.getDate(7));
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
