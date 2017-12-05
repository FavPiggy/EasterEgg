package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.MemberRoleEntity;

/**
 * This class contains static method to check DAO for MemberRole.
 * @author Varik Hoang
 */
public class MemberRoleDAO
{
	private static final String SELECT = "select * from MemberRole ";
	
	/**
	 * The method return a list of MemberRole.
	 * @author Varik Hoang
	 * @return return a list of MemberRole
	 * @throws SQLException
	 */
	public static List<MemberRoleEntity> listMemberRole()
	{
		List<MemberRoleEntity> list = new ArrayList<MemberRoleEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT);
			
			while(resultset.next())
			{
				MemberRoleEntity entity = new MemberRoleEntity();
				entity.setMemberID(resultset.getInt("MemberID"));
				entity.setRoleID(resultset.getInt("RoleID"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method returns a list of MemberRole with condition
	 * @author Varik Hoang
	 * @return return a list of MemberRole with condition
	 * @throws SQLException
	 */
	public static List<MemberRoleEntity> listMemberRole(String condition)
	{
		List<MemberRoleEntity> list = new ArrayList<MemberRoleEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT + condition);
			
			while(resultset.next())
			{
				MemberRoleEntity entity = new MemberRoleEntity();
				entity.setMemberID(resultset.getInt("MemberID"));
				entity.setRoleID(resultset.getInt("RoleID"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method inserts a MemberRole
	 * @author Varik Hoang
	 * @return return true if inserting successfully
	 * @throws SQLException
	 */
	public static boolean insert(MemberRoleEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into MemberRole values(");
			builder.append("").append(entity.getMemberID()).append(",");
			builder.append("").append(entity.getRoleID()).append(",");
			builder.append("#").append(entity.getDateCreated()).append("#,");
			builder.delete(builder.length() - 1, builder.length());
			builder.append(");");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method updates a MemberRole
	 * @author Varik Hoang
	 * @return return true if updating successfully
	 * @throws SQLException
	 */
	public static boolean update(MemberRoleEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("update MemberRole set ");
			builder.append("MemberID=").append("").append(entity.getMemberID()).append(", ");
			builder.append("RoleID=").append("").append(entity.getRoleID()).append(", ");
			builder.append("DateCreated=").append("#").append(entity.getDateCreated()).append("#, ");
			
			builder.delete(builder.length() - 2, builder.length());
			builder.append(" where");
			builder.append(" MemberID=").append(entity.getMemberID()).append(" and");
			builder.append(" RoleID=").append(entity.getRoleID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method deletes a MemberRole
	 * @author Varik Hoang
	 * @return return true if deleting successfully
	 * @throws SQLException
	 */
	public static boolean delete(MemberRoleEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("delete from MemberRole");
			builder.append(" where");
			builder.append(" MemberID=").append(entity.getMemberID()).append(" and");
			builder.append(" RoleID=").append(entity.getRoleID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
