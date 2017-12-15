package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.ProjectEntity;

/**
 * This class contains static method to check DAO for Project.
 * @author Varik Hoang
 */
public class ProjectDAO
{
	private static final String SELECT = "select * from Project ";
	
	/**
	 * The method return a list of Project.
	 * @author Varik Hoang
	 * @return return a list of Project
	 * @throws SQLException
	 */
	public static List<ProjectEntity> listProject()
	{
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT);
			
			while(resultset.next())
			{
				ProjectEntity entity = new ProjectEntity();
				entity.setProjectID(resultset.getInt("ProjectID"));
				entity.setProjectName(resultset.getString("ProjectName"));
				entity.setProjectAbbr(resultset.getString("ProjectAbbr"));
				entity.setDescription(resultset.getString("Description"));
				entity.setStartDate(resultset.getDate("StartDate"));
				entity.setCategoryID(resultset.getInt("CategoryID"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method returns a list of Project with condition
	 * @author Varik Hoang
	 * @return return a list of Project with condition
	 * @throws SQLException
	 */
	public static List<ProjectEntity> listProject(String condition)
	{
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT + condition);
			
			while(resultset.next())
			{
				ProjectEntity entity = new ProjectEntity();
				entity.setProjectID(resultset.getInt("ProjectID"));
				entity.setProjectName(resultset.getString("ProjectName"));
				entity.setProjectAbbr(resultset.getString("ProjectAbbr"));
				entity.setDescription(resultset.getString("Description"));
				entity.setStartDate(resultset.getDate("StartDate"));
				entity.setCategoryID(resultset.getInt("CategoryID"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method inserts a Project
	 * @author Varik Hoang
	 * @return return true if inserting successfully
	 * @throws SQLException
	 */
	public static boolean insert(ProjectEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into Project values(");
			builder.append("").append(entity.getProjectID()).append(",");
			builder.append("'").append(entity.getProjectName()).append("',");
			builder.append("'").append(entity.getProjectAbbr()).append("',");
			builder.append("'").append(entity.getDescription()).append("',");
			builder.append("#").append(entity.getStartDate()).append("#,");
			builder.append("").append(entity.getCategoryID()).append(",");
			builder.append("#").append(entity.getDateCreated()).append("#,");
			builder.delete(builder.length() - 1, builder.length());
			builder.append(");");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method updates a Project
	 * @author Varik Hoang
	 * @return return true if updating successfully
	 * @throws SQLException
	 */
	public static boolean update(ProjectEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("update Project set ");
			builder.append("ProjectID=").append("").append(entity.getProjectID()).append(", ");
			builder.append("ProjectName=").append("'").append(entity.getProjectName()).append("', ");
			builder.append("ProjectAbbr=").append("'").append(entity.getProjectAbbr()).append("', ");
			builder.append("Description=").append("'").append(entity.getDescription()).append("', ");
			builder.append("StartDate=").append("#").append(entity.getStartDate()).append("#, ");
			builder.append("CategoryID=").append("").append(entity.getCategoryID()).append(", ");
			builder.append("DateCreated=").append("#").append(entity.getDateCreated()).append("#, ");
			
			builder.delete(builder.length() - 2, builder.length());
			builder.append(" where");
			builder.append(" ProjectID=").append(entity.getProjectID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method deletes a Project
	 * @author Varik Hoang
	 * @return return true if deleting successfully
	 * @throws SQLException
	 */
	public static boolean delete(ProjectEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("delete from Project");
			builder.append(" where");
			builder.append(" ProjectID=").append(entity.getProjectID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
