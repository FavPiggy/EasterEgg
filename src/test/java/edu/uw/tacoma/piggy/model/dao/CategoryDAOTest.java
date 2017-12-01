package edu.uw.tacoma.piggy.model.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import edu.uw.tacoma.piggy.model.entity.CategoryEntity;
import junit.framework.Assert;
import junit.framework.TestCase;

import static edu.uw.tacoma.piggy.PiggyUtilities.DateFormatter;

/**
 * The test case for the category DAO
 * @author Kerry Ferguson
 */
public class CategoryDAOTest
extends TestCase
{
	public void testListCategory()
	{
		List<CategoryEntity> list = CategoryDAO.listCategory();
		Assert.assertEquals("The test list category method failed ", 2, list.size());
	}
	
	public void testInsert() throws ParseException
	{
		CategoryEntity entity = new CategoryEntity();
		entity.setCatID(5);
		entity.setCatName("Test");
		entity.setDateCreated(DateFormatter.parse("2017/10/10"));
		
		Assert.assertTrue("The test list category method failed ", CategoryDAO.insert(entity));
	}

}
