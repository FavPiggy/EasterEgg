package edu.uw.tacoma.piggy.model.entity;

import java.util.Calendar;
import java.sql.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the Task entity
 * @author Kirtwinder Gulati
 */
public class TaskEntityTest
extends TestCase
{
	public void testConstructor()
	{
		boolean succeed = false;
		
		try
		{
			new TaskEntity();
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
			TaskEntity entity = new TaskEntity();
			entity.setTaskID(0);
			entity.setProjectID(0);
			entity.setStartDate(new Date(Calendar.getInstance().getTime().getTime()));
			entity.setDuration(0);
			entity.setDescription("");
			entity.setUserID(0);
			entity.setParentTask(0);
			entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor with parameter failed ", succeed);
	}

}
