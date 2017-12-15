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
	
	public void testGetMemberID()
	{
		Assert.assertEquals("The test setMemberID method failed ", 0, new MemberEntity().getMemberID().intValue());
	}
	
	public void testGetProjectID()
	{
		Assert.assertEquals("The test setProjectID method failed ", 0, new MemberEntity().getProjectID().intValue());
	}
	
	public void testGetUserID()
	{
		Assert.assertEquals("The test setUserID method failed ", 0, new MemberEntity().getUserID().intValue());
	}
	
	public void testSetMemberID()
	{
	//	Integer _CatID,String _CatName,String _Description,Date _DateCreated
	//	Integer _MemberID,Integer _ProjectID,Integer _UserID,Date _DateJoined
		
		MemberEntity entity = new MemberEntity(1, 3, 123, new Date());
		Assert.assertEquals("The test setMemberID method failed ", 1, entity.getMemberID().intValue());
	}
	
	public void testSetProjectID()
	{
		MemberEntity entity = new MemberEntity(1, 3, 123, new Date());
		Assert.assertEquals("The test setProjectID method failed ", 3, entity.getProjectID().intValue());
	}
	
	public void testSetUserID()
	{
		MemberEntity entity = new MemberEntity(1, 3, 123, new Date());
		Assert.assertEquals("The test setUserID method failed ", 123, entity.getUserID().intValue());
	}
}
