package edu.uw.tacoma.piggy.model.entity;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the User entity
 * @author Kirtwinder Gulati
 */
public class UserEntityTest
extends TestCase
{
	public void testConstructor()
	{
		boolean succeed = false;
		
		try
		{
			new UserEntity();
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
			UserEntity entity = new UserEntity();
			entity.setUserID(0);
			entity.setFirstName("");
			entity.setLastName("");
			entity.setPhoneNumber("");
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor with parameter failed ", succeed);
	}

}
