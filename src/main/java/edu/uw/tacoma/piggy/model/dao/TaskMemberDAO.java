package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.TaskMemberEntity;

/**
 * This class contains static method to check DAO for TaskMember.
 * @author Varik Hoang
 */
public class TaskMemberDAO
{
	private static final String SELECT = "select * from TaskMember ";
	
	/**
	 * The method return a list of TaskMember.
	 * @author Varik Hoang
	 * @return return a list of TaskMember
	 * @throws SQLException
	 */
	public static List<TaskMemberEntity> listTaskMember()
	{
		List<TaskMemberEntity> list = new ArrayList<TaskMemberEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT);
			
			while(resultset.next())
			{
				TaskMemberEntity entity = new TaskMemberEntity();
				entity.setTaskID(resultset.getInt("TaskID"));
				entity.setMemberID(resultset.getInt("MemberID"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method returns a list of TaskMember with condition
	 * @author Varik Hoang
	 * @return return a list of TaskMember with condition
	 * @throws SQLException
	 */
	public static List<TaskMemberEntity> listTaskMember(String condition)
	{
		List<TaskMemberEntity> list = new ArrayList<TaskMemberEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT + condition);
			
			while(resultset.next())
			{
				TaskMemberEntity entity = new TaskMemberEntity();
				entity.setTaskID(resultset.getInt("TaskID"));
				entity.setMemberID(resultset.getInt("MemberID"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method inserts a TaskMember
	 * @author Varik Hoang
	 * @return return true if inserting successfully
	 * @throws SQLException
	 */
	public static boolean insert(TaskMemberEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into TaskMember values(");
			builder.append("").append(entity.getTaskID()).append(",");
			builder.append("").append(entity.getMemberID()).append(",");
			builder.delete(builder.length() - 1, builder.length());
			builder.append(");");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method updates a TaskMember
	 * @author Varik Hoang
	 * @return return true if updating successfully
	 * @throws SQLException
	 */
	public static boolean update(TaskMemberEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("update TaskMember set ");
			builder.append("TaskID=").append("").append(entity.getTaskID()).append(", ");
			builder.append("MemberID=").append("").append(entity.getMemberID()).append(", ");
			
			builder.delete(builder.length() - 2, builder.length());
			builder.append(" where");
			builder.append(" TaskID=").append(entity.getTaskID()).append(" and");
			builder.append(" MemberID=").append(entity.getMemberID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method deletes a TaskMember
	 * @author Varik Hoang
	 * @return return true if deleting successfully
	 * @throws SQLException
	 */
	public static boolean delete(TaskMemberEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("delete from TaskMember");
			builder.append(" where");
			builder.append(" TaskID=").append(entity.getTaskID()).append(" and");
			builder.append(" MemberID=").append(entity.getMemberID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
