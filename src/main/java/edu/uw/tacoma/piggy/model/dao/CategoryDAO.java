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
	/**
	 * The method checks DAO of Category.
	 * @author Varik Hoang
	 * @return return array list of Category.
	 * @throws Exception
	 */
	public static List<CategoryEntity> listCategory()
	{
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery("select * from Category");
			
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
		catch (ClassNotFoundException e) { e.printStackTrace();	}

		return list;
	}
	
	/**
	 * The method checks DAO of Category.
	 * @author Varik Hoang
	 * @return return array list of Category.
	 * @throws Exception
	 */
	public static boolean insert(CategoryEntity entity)
	{
		int resultset = 0;
		
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = PiggyUtilities.getConnection();
			Statement statement = conn.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append("insert into Category values(");
			builder.append(entity.getCatID()).append(",");
			builder.append("'").append(entity.getCatName()).append("',");
			builder.append("'").append(entity.getDescription()).append("',");
			builder.append("'").append(entity.getDateCreated()).append("'");
			builder.append(");");
			
			System.out.println(builder.toString());
			resultset = statement.executeUpdate(builder.toString());
		}
		catch (SQLException e) { e.printStackTrace();	}
		catch (ClassNotFoundException e) { e.printStackTrace();	}

		return resultset > 0;
	}

}
