package edu.uw.tacoma.piggy.model.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale.Category;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

import java.util.ArrayList;
import java.util.Date;

import edu.uw.tacoma.piggy.PiggyUtilities;
import static edu.uw.tacoma.piggy.PiggyUtilities.DateFormatter;
import edu.uw.tacoma.piggy.model.entity.CategoryEntity;

/**
 * This class contains static method to check DAO for Category.
 * 
 * @author Cuong Tran, Varik Hoang
 */
public class CategoryDAO
{
	/**
	 * The method checks DAO of Category.
	 * 
	 * @author Cuong Tran
	 * @return return arraylist of Category.
	 * @throws Exception
	 */
	public static List<CategoryEntity> listCategory()
	{
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//			Connection conn = PiggyUtilities.getConnection();
//			jdbc:ucanaccess:///home/varikmp/workspace/EasterEgg/target/test-classes/db/database.mdb
//			jdbc:ucanaccess:///home/varikmp/workspace/EasterEgg/src/test/resources/db/database.mdb
//			Statement statement = conn.createStatement();
//			ResultSet resultset = statement.executeQuery("select * from Category");
			
//			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//			Connection conn = DriverManager.getConnection("jdbc:ucanaccess:///home/varikmp/workspace/EasterEgg/src/test/resources/db/database.mdb");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess:///home/varikmp/workspace/EasterEgg/target/test-classes/db/database.mdb");
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
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
