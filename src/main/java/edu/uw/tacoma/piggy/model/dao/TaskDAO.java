package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.TaskEntity;

/**
 * This class contains static method to check DAO for Task.
 * @author Varik Hoang
 */
public class TaskDAO
{
	private static final String SELECT = "select * from Task ";
	
	/**
	 * The method return a list of Task.
	 * @author Varik Hoang
	 * @return return a list of Task
	 * @throws SQLException
	 */
	public static List<TaskEntity> listTask()
	{
		List<TaskEntity> list = new ArrayList<TaskEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT);
			
			while(resultset.next())
			{
				TaskEntity entity = new TaskEntity();
				entity.setTaskID(resultset.getInt("TaskID"));
				entity.setProjectID(resultset.getInt("ProjectID"));
				entity.setStartDate(resultset.getDate("StartDate"));
				entity.setDuration(resultset.getInt("Duration"));
				entity.setDescription(resultset.getString("Description"));
				entity.setUserID(resultset.getInt("UserID"));
				entity.setParentTask(resultset.getInt("ParentTask"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method returns a list of Task with condition
	 * @author Varik Hoang
	 * @return return a list of Task with condition
	 * @throws SQLException
	 */
	public static List<TaskEntity> listTask(String condition)
	{
		List<TaskEntity> list = new ArrayList<TaskEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT + condition);
			
			while(resultset.next())
			{
				TaskEntity entity = new TaskEntity();
				entity.setTaskID(resultset.getInt("TaskID"));
				entity.setProjectID(resultset.getInt("ProjectID"));
				entity.setStartDate(resultset.getDate("StartDate"));
				entity.setDuration(resultset.getInt("Duration"));
				entity.setDescription(resultset.getString("Description"));
				entity.setUserID(resultset.getInt("UserID"));
				entity.setParentTask(resultset.getInt("ParentTask"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method inserts a Task
	 * @author Varik Hoang
	 * @return return true if inserting successfully
	 * @throws SQLException
	 */
	public static boolean insert(TaskEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into Task values(");
			builder.append("").append(entity.getTaskID()).append(",");
			builder.append("").append(entity.getProjectID()).append(",");
			builder.append("#").append(entity.getStartDate()).append("#,");
			builder.append("").append(entity.getDuration()).append(",");
			builder.append("'").append(entity.getDescription()).append("',");
			builder.append("").append(entity.getUserID()).append(",");
			builder.append("").append(entity.getParentTask()).append(",");
			builder.append("#").append(entity.getDateCreated()).append("#,");
			builder.delete(builder.length() - 1, builder.length());
			builder.append(");");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method updates a Task
	 * @author Varik Hoang
	 * @return return true if updating successfully
	 * @throws SQLException
	 */
	public static boolean update(TaskEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("update Task set ");
			builder.append("TaskID=").append("").append(entity.getTaskID()).append(", ");
			builder.append("ProjectID=").append("").append(entity.getProjectID()).append(", ");
			builder.append("StartDate=").append("#").append(entity.getStartDate()).append("#, ");
			builder.append("Duration=").append("").append(entity.getDuration()).append(", ");
			builder.append("Description=").append("'").append(entity.getDescription()).append("', ");
			builder.append("UserID=").append("").append(entity.getUserID()).append(", ");
			builder.append("ParentTask=").append("").append(entity.getParentTask()).append(", ");
			builder.append("DateCreated=").append("#").append(entity.getDateCreated()).append("#, ");
			
			builder.delete(builder.length() - 2, builder.length());
			builder.append(" where");
			builder.append(" TaskID=").append(entity.getTaskID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method deletes a Task
	 * @author Varik Hoang
	 * @return return true if deleting successfully
	 * @throws SQLException
	 */
	public static boolean delete(TaskEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("delete from Task");
			builder.append(" where");
			builder.append(" TaskID=").append(entity.getTaskID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
