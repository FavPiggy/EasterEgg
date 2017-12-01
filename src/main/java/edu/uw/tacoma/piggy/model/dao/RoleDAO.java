package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.RoleEntity;

/**
 * This class contains static method to check DAO for Role.
 * @author Varik Hoang
 */
public class RoleDAO
{
	private static final String SELECT = "select * from Role ";
	
	/**
	 * The method return a list of Role.
	 * @author Varik Hoang
	 * @return return a list of Role
	 * @throws SQLException
	 */
	public static List<RoleEntity> listRole()
	{
		List<RoleEntity> list = new ArrayList<RoleEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT);
			
			while(resultset.next())
			{
				RoleEntity entity = new RoleEntity();
				entity.setRoleID(resultset.getInt("RoleID"));
				entity.setRoleName(resultset.getString("RoleName"));
				entity.setDescription(resultset.getString("Description"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method returns a list of Role with condition
	 * @author Varik Hoang
	 * @return return a list of Role with condition
	 * @throws SQLException
	 */
	public static List<RoleEntity> listRole(String condition)
	{
		List<RoleEntity> list = new ArrayList<RoleEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT + condition);
			
			while(resultset.next())
			{
				RoleEntity entity = new RoleEntity();
				entity.setRoleID(resultset.getInt("RoleID"));
				entity.setRoleName(resultset.getString("RoleName"));
				entity.setDescription(resultset.getString("Description"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method inserts a Role
	 * @author Varik Hoang
	 * @return return true if inserting successfully
	 * @throws SQLException
	 */
	public static boolean insert(RoleEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into Role values(");
			builder.append("").append(entity.getRoleID()).append(",");
			builder.append("'").append(entity.getRoleName()).append("',");
			builder.append("'").append(entity.getDescription()).append("',");
			builder.append("#").append(entity.getDateCreated()).append("#,");
			builder.delete(builder.length() - 1, builder.length());
			builder.append(");");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method updates a Role
	 * @author Varik Hoang
	 * @return return true if updating successfully
	 * @throws SQLException
	 */
	public static boolean update(RoleEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("update Role set ");
			builder.append("RoleID=").append("").append(entity.getRoleID()).append(", ");
			builder.append("RoleName=").append("'").append(entity.getRoleName()).append("', ");
			builder.append("Description=").append("'").append(entity.getDescription()).append("', ");
			builder.append("DateCreated=").append("#").append(entity.getDateCreated()).append("#, ");
			
			builder.delete(builder.length() - 2, builder.length());
			builder.append(" where");
			builder.append(" RoleID=").append(entity.getRoleID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method deletes a Role
	 * @author Varik Hoang
	 * @return return true if deleting successfully
	 * @throws SQLException
	 */
	public static boolean delete(RoleEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("delete from Role");
			builder.append(" where");
			builder.append(" RoleID=").append(entity.getRoleID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
