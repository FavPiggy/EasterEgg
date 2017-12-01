package edu.uw.tacoma.piggy.model.entity;

import java.util.Calendar;
import java.sql.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the Member entity
 * @author Kirtwinder Gulati
 */
public class MemberEntityTest
extends TestCase
{
	public void testConstructor()
	{
		boolean succeed = false;
		
		try
		{
			new MemberEntity();
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
			MemberEntity entity = new MemberEntity();
			entity.setMemberID(0);
			entity.setProjectID(0);
			entity.setUserID(0);
			entity.setDateJoined(new Date(Calendar.getInstance().getTime().getTime()));
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor with parameter failed ", succeed);
	}

}
