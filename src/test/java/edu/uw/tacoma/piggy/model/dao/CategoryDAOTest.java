package edu.uw.tacoma.piggy.model.dao;

import java.sql.Date;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import edu.uw.tacoma.piggy.model.entity.CategoryEntity;

/**
 * The test case for the Category DAO
 * @author Kerry Ferguson
 */
public class CategoryDAOTest
extends TestCase
{
	public void testCategory()
	{
		CategoryEntity entity;
		
		List<CategoryEntity> list = CategoryDAO.listCategory();
		Assert.assertEquals("The test list Category method failed ", 2, list.size());
		
		// should set different field values
		entity = new CategoryEntity();
		entity.setCatID(5);
		entity.setCatName("Test");
		entity.setDescription("Test");
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test insert method failed ", CategoryDAO.insert(entity));
		
		entity.setCatID(5);
		entity.setCatName("Test");
		entity.setDescription("Test");
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test update method failed ", CategoryDAO.update(entity));
		Assert.assertTrue("The test delete method failed ", CategoryDAO.delete(entity));
	}

}
