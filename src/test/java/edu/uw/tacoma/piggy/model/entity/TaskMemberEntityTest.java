package edu.uw.tacoma.piggy.model.entity;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the TaskMember entity
 * @author Kirtwinder Gulati
 */
public class TaskMemberEntityTest
extends TestCase
{
	public void testConstructor()
	{
		boolean succeed = false;
		
		try
		{
			new TaskMemberEntity();
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
			TaskMemberEntity entity = new TaskMemberEntity();
			entity.setTaskID(0);
			entity.setMemberID(0);
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor with parameter failed ", succeed);
	}

}
