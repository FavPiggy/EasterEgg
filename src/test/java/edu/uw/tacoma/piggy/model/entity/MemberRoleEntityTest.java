package edu.uw.tacoma.piggy.model.entity;

import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the category entity
 * @author Kerry Ferguson
 */
public class MemberRoleEntityTest
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
	
	public void testGetTaskID()
	{
		Assert.assertEquals("The test setTaskID method failed ", 0, new MemberRoleEntity().getTaskID().intValue());
	}
	
	public void testGetMemberID()
	{
		Assert.assertEquals("The test setMemberID method failed ", 0, new MemberEntity().getMemberID().intValue());
	}
	
	public void testSetTaskID()
	{
		MemberRoleEntity entity = new MemberRoleEntity(2, 1);
		Assert.assertEquals("The test setTaskID method failed ", 2, entity.getTaskID().intValue());
	}
	
	public void testSetMemberID()
	{
		MemberRoleEntity entity = new MemberRoleEntity(2, 1);
		Assert.assertEquals("The test setMemberRoleID method failed ", 1, entity.getMemberID().intValue());
	}
	
	
}
