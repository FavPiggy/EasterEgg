package edu.uw.tacoma.piggy.model.entity;

import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the category entity
 * @author Varik Hoang
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
			new CategoryEntity(0, "", "", new Date());
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor with parameter failed ", succeed);
	}
	
	public void testGetCatID()
	{
		Assert.assertEquals("The test setCatID method failed ", 0, new CategoryEntity().getCatID().intValue());
	}
	
	public void testGetCatName()
	{
		Assert.assertEquals("The test setCatID method failed ", "", new CategoryEntity().getCatName());
	}
	
	public void testGetDescription()
	{
		Assert.assertEquals("The test setCatID method failed ", "", new CategoryEntity().getDescription());
	}
	
	public void testSetCatID()
	{
		CategoryEntity entity = new CategoryEntity(10, "Internal Project", "...", new Date());
		Assert.assertEquals("The test setCatID method failed ", 10, entity.getCatID().intValue());
	}
	
	public void testSetCatName()
	{
		CategoryEntity entity = new CategoryEntity(10, "Internal Project", "...", new Date());
		Assert.assertEquals("The test setCatID method failed ", "Internal Project", entity.getCatName());
	}
	
	public void testSetDescription()
	{
		CategoryEntity entity = new CategoryEntity(10, "Internal Project", "...", new Date());
		Assert.assertEquals("The test setCatID method failed ", "...", entity.getDescription());
	}
}
