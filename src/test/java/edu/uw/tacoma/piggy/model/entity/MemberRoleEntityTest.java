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
	public void testGetRoleID()
	{
		Assert.assertEquals("The test setRoleID method failed ", 0, new MemberRoleEntity().getRoleID().intValue());
	}
	
	public void testGetMemberID()
	{
		Assert.assertEquals("The test setMemberID method failed ", 0, new MemberEntity().getMemberID().intValue());
	}
	
	public void testSetRoleID()
	{
		MemberRoleEntity entity = new MemberRoleEntity(1, 2, new MemberRoleEntity().getDateCreated());
		Assert.assertEquals("The test setRoleID method failed ", 2, entity.getRoleID().intValue());
	}
	
	public void testSetMemberID()
	{
		MemberRoleEntity entity = new MemberRoleEntity(2, 1, new MemberRoleEntity().getDateCreated());
		Assert.assertEquals("The test setMemberRoleID method failed ", 1, entity.getMemberID().intValue());
	}

}
