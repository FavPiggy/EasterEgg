package edu.uw.tacoma.piggy.model.entity;

import java.util.Calendar;
import java.sql.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the Category entity
 * @author Kirtwinder Gulati
 */
public class CategoryEntityTest
extends TestCase
{
	public void testConstructor()
	{
		boolean succeed = false;
		
		try
		{
			new CategoryEntity();
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor failed ", succeed);
	}
	
	public void testConstructorWithParameters()
	{
		boolean succeed = false;
		
		try
		{
			CategoryEntity entity = new CategoryEntity();
			entity.setCatID(0);
			entity.setCatName("");
			entity.setDescription("");
			entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor with parameter failed ", succeed);
	}

}
