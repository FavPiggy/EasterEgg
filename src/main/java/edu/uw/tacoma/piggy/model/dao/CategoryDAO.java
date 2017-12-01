package edu.uw.tacoma.piggy.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import edu.uw.tacoma.piggy.PiggyUtilities;
import edu.uw.tacoma.piggy.model.entity.CategoryEntity;

/**
 * This class contains static method to check DAO for Category.
 * @author Varik Hoang
 */
public class CategoryDAO
{
	private static final String SELECT = "select * from Category ";
	
	/**
	 * The method return a list of Category.
	 * @author Varik Hoang
	 * @return return a list of Category
	 * @throws SQLException
	 */
	public static List<CategoryEntity> listCategory()
	{
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT);
			
			while(resultset.next())
			{
				CategoryEntity entity = new CategoryEntity();
				entity.setCatID(resultset.getInt("CatID"));
				entity.setCatName(resultset.getString("CatName"));
				entity.setDescription(resultset.getString("Description"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method returns a list of Category with condition
	 * @author Varik Hoang
	 * @return return a list of Category with condition
	 * @throws SQLException
	 */
	public static List<CategoryEntity> listCategory(String condition)
	{
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(SELECT + condition);
			
			while(resultset.next())
			{
				CategoryEntity entity = new CategoryEntity();
				entity.setCatID(resultset.getInt("CatID"));
				entity.setCatName(resultset.getString("CatName"));
				entity.setDescription(resultset.getString("Description"));
				entity.setDateCreated(resultset.getDate("DateCreated"));
				list.add(entity);
            }
		}
		catch (SQLException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method inserts a Category
	 * @author Varik Hoang
	 * @return return true if inserting successfully
	 * @throws SQLException
	 */
	public static boolean insert(CategoryEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into Category values(");
			builder.append("").append(entity.getCatID()).append(",");
			builder.append("'").append(entity.getCatName()).append("',");
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
	 * The method updates a Category
	 * @author Varik Hoang
	 * @return return true if updating successfully
	 * @throws SQLException
	 */
	public static boolean update(CategoryEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("update Category set ");
			builder.append("CatID=").append("").append(entity.getCatID()).append(", ");
			builder.append("CatName=").append("'").append(entity.getCatName()).append("', ");
			builder.append("Description=").append("'").append(entity.getDescription()).append("', ");
			builder.append("DateCreated=").append("#").append(entity.getDateCreated()).append("#, ");
			
			builder.delete(builder.length() - 2, builder.length());
			builder.append(" where");
			builder.append(" CatID=").append(entity.getCatID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}
	
	/**
	 * The method deletes a Category
	 * @author Varik Hoang
	 * @return return true if deleting successfully
	 * @throws SQLException
	 */
	public static boolean delete(CategoryEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("delete from Category");
			builder.append(" where");
			builder.append(" CatID=").append(entity.getCatID()).append(" and");
			
			builder.delete(builder.length() - 4, builder.length());
			builder.append(";");
			
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
