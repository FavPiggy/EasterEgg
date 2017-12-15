package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import edu.uw.tacoma.piggy.model.entity.UserEntity;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the category DAO
 * @author Kerry Ferguson
 */
public class UserDAOTest
extends TestCase
{
	public void testListCategory()
	{
		List<UserEntity> list = UserDAO.listUser();
		Assert.assertEquals("The test list user method failed ", 3, list.size());
	}
	
	public void testListCategoryID()
	{
		List<UserEntity> list = UserDAO.listUser("ID", "0");
		Assert.assertEquals("The test list user method failed ", 1, list.size());
	}
}
