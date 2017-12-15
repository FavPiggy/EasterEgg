package edu.uw.tacoma.piggy.model.entity;


import java.util.Calendar;
import java.sql.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

/**

 * The test case for the MemberRole entity
 * @author Kirtwinder Gulati
 */
public class MemberRoleEntityTest
extends TestCase
{
	public void testConstructor()
	{
		boolean succeed = false;
		
		try
		{

			new MemberRoleEntity();
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
			MemberRoleEntity entity = new MemberRoleEntity();
			entity.setMemberID(0);
			entity.setRoleID(0);
			entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
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
