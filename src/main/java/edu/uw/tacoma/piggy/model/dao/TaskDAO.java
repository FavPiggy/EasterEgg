package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import edu.uw.tacoma.piggy.model.entity.TaskEntity;

/**
 * This class contains static method to check DAO for Task.
 * @author Cuong Tran
 */
public class TaskDAO
{
	/**
	 * The method checks DAO of Task.
	 * @author Cuong Tran
	 * @return return arraylist of Task.
	 * @throws Exception
	 */
	public static List<TaskEntity> listTask()
	{
		List<TaskEntity> list = new ArrayList<TaskEntity>();
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
			ResultSet results = stmt.executeQuery("select * from Task");
			while (results.next())
			{
				TaskEntity entity = new TaskEntity();
				entity.setTaskID(results.getInt(1));
				entity.setProjectID(results.getInt(2));
				entity.setStartDate(results.getDate(3));
				entity.setDuration(results.getInt(4));
				entity.setDescription(results.getString(5));
				entity.setUserID(results.getInt(6));
				entity.setParentTask(results.getInt(7));
				entity.setDateCreated(results.getDate(8));
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
	 * @return return array list of Task.
	 * @param field the field specified.
	 * @param value the value specified.
	 * @throws Exception
	 */
	public static List<TaskEntity> listTask(String field, String value)
	{
		List<TaskEntity> list = new ArrayList<TaskEntity>();
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
			ResultSet results = stmt.executeQuery("select * from Task where " + field + " = '" + value + "'");
			while (results.next())
			{
				TaskEntity entity = new TaskEntity();
				entity.setTaskID(results.getInt(1));
				entity.setProjectID(results.getInt(2));
				entity.setStartDate(results.getDate(3));
				entity.setDuration(results.getInt(4));
				entity.setDescription(results.getString(5));
				entity.setUserID(results.getInt(6));
				entity.setParentTask(results.getInt(7));
				entity.setDateCreated(results.getDate(8));
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
