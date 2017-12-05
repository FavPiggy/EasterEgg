package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import edu.uw.tacoma.piggy.model.entity.UserEntity;

/**
 * The test case for the User DAO
 * @author Kerry Ferguson
 */
public class UserDAOTest
extends TestCase
{
	public void testUser()
	{
		UserEntity entity;
		
		List<UserEntity> list = UserDAO.listUser();
		Assert.assertEquals("The test list User method failed ", 6, list.size());
		
		// should set different field values
		entity = new UserEntity();
		entity.setUserID(10);
		entity.setFirstName("");
		entity.setLastName("");
		entity.setPhoneNumber("");
		Assert.assertTrue("The test insert method failed ", UserDAO.insert(entity));
		
		entity.setUserID(10);
		entity.setFirstName("");
		entity.setLastName("");
		entity.setPhoneNumber("");
		Assert.assertTrue("The test update method failed ", UserDAO.update(entity));
		Assert.assertTrue("The test delete method failed ", UserDAO.delete(entity));
	}

}
