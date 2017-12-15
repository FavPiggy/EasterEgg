package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.UserEntity;

/**
 * This class contains static method to check DAO for User.
 * @author Varik Hoang
 */
public class UserDAO
{
	private static final String SELECT = "select * from User ";
	
	/**
	 * The method return a list of User.
	 * @author Varik Hoang
	 * @return return a list of User
	 * @throws SQLException
	 */
	public static List<UserEntity> listUser()
	{
		List<UserEntity> list = new ArrayList<UserEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT);
			
			while(resultset.next())
			{
				UserEntity entity = new UserEntity();
				entity.setUserID(resultset.getInt("UserID"));
				entity.setFirstName(resultset.getString("FirstName"));
				entity.setLastName(resultset.getString("LastName"));
				entity.setPhoneNumber(resultset.getString("PhoneNumber"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method returns a list of User with condition
	 * @author Varik Hoang
	 * @return return a list of User with condition
	 * @throws SQLException
	 */
	public static List<UserEntity> listUser(String condition)
	{
		List<UserEntity> list = new ArrayList<UserEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT + condition);
			
			while(resultset.next())
			{
				UserEntity entity = new UserEntity();
				entity.setUserID(resultset.getInt("UserID"));
				entity.setFirstName(resultset.getString("FirstName"));
				entity.setLastName(resultset.getString("LastName"));
				entity.setPhoneNumber(resultset.getString("PhoneNumber"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method inserts a User
	 * @author Varik Hoang
	 * @return return true if inserting successfully
	 * @throws SQLException
	 */
	public static boolean insert(UserEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into User values(");
			builder.append("").append(entity.getUserID()).append(",");
			builder.append("'").append(entity.getFirstName()).append("',");
			builder.append("'").append(entity.getLastName()).append("',");
			builder.append("'").append(entity.getPhoneNumber()).append("',");
			builder.delete(builder.length() - 1, builder.length());
			builder.append(");");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method updates a User
	 * @author Varik Hoang
	 * @return return true if updating successfully
	 * @throws SQLException
	 */
	public static boolean update(UserEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("update User set ");
			builder.append("UserID=").append("").append(entity.getUserID()).append(", ");
			builder.append("FirstName=").append("'").append(entity.getFirstName()).append("', ");
			builder.append("LastName=").append("'").append(entity.getLastName()).append("', ");
			builder.append("PhoneNumber=").append("'").append(entity.getPhoneNumber()).append("', ");
			
			builder.delete(builder.length() - 2, builder.length());
			builder.append(" where");
			builder.append(" UserID=").append(entity.getUserID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method deletes a User
	 * @author Varik Hoang
	 * @return return true if deleting successfully
	 * @throws SQLException
	 */
	public static boolean delete(UserEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("delete from User");
			builder.append(" where");
			builder.append(" UserID=").append(entity.getUserID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
