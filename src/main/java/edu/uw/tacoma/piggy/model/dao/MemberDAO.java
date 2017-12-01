package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.MemberEntity;

/**
 * This class contains static method to check DAO for Member.
 * @author Varik Hoang
 */
public class MemberDAO
{
	private static final String SELECT = "select * from Member ";
	
	/**
	 * The method return a list of Member.
	 * @author Varik Hoang
	 * @return return a list of Member
	 * @throws SQLException
	 */
	public static List<MemberEntity> listMember()
	{
		List<MemberEntity> list = new ArrayList<MemberEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT);
			
			while(resultset.next())
			{
				MemberEntity entity = new MemberEntity();
				entity.setMemberID(resultset.getInt("MemberID"));
				entity.setProjectID(resultset.getInt("ProjectID"));
				entity.setUserID(resultset.getInt("UserID"));
				entity.setDateJoined(resultset.getDate("DateJoined"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method returns a list of Member with condition
	 * @author Varik Hoang
	 * @return return a list of Member with condition
	 * @throws SQLException
	 */
	public static List<MemberEntity> listMember(String condition)
	{
		List<MemberEntity> list = new ArrayList<MemberEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT + condition);
			
			while(resultset.next())
			{
				MemberEntity entity = new MemberEntity();
				entity.setMemberID(resultset.getInt("MemberID"));
				entity.setProjectID(resultset.getInt("ProjectID"));
				entity.setUserID(resultset.getInt("UserID"));
				entity.setDateJoined(resultset.getDate("DateJoined"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method inserts a Member
	 * @author Varik Hoang
	 * @return return true if inserting successfully
	 * @throws SQLException
	 */
	public static boolean insert(MemberEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into Member values(");
			builder.append("").append(entity.getMemberID()).append(",");
			builder.append("").append(entity.getProjectID()).append(",");
			builder.append("").append(entity.getUserID()).append(",");
			builder.append("#").append(entity.getDateJoined()).append("#,");
			builder.delete(builder.length() - 1, builder.length());
			builder.append(");");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method updates a Member
	 * @author Varik Hoang
	 * @return return true if updating successfully
	 * @throws SQLException
	 */
	public static boolean update(MemberEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("update Member set ");
			builder.append("MemberID=").append("").append(entity.getMemberID()).append(", ");
			builder.append("ProjectID=").append("").append(entity.getProjectID()).append(", ");
			builder.append("UserID=").append("").append(entity.getUserID()).append(", ");
			builder.append("DateJoined=").append("#").append(entity.getDateJoined()).append("#, ");
			
			builder.delete(builder.length() - 2, builder.length());
			builder.append(" where");
			builder.append(" MemberID=").append(entity.getMemberID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method deletes a Member
	 * @author Varik Hoang
	 * @return return true if deleting successfully
	 * @throws SQLException
	 */
	public static boolean delete(MemberEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("delete from Member");
			builder.append(" where");
			builder.append(" MemberID=").append(entity.getMemberID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
