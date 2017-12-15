package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import edu.uw.tacoma.piggy.model.entity.RoleEntity;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the category DAO
 * @author Kerry Ferguson
 */
public class RoleDAOTest
extends TestCase
{
	public void testListCategory()
	{
		List<RoleEntity> list = RoleDAO.listRole();
		Assert.assertEquals("The test list category method failed ", 3, list.size());
	}
	
	public void testListCategoryID()
	{
		List<RoleEntity> list = RoleDAO.listRole("ID", "0");
		Assert.assertEquals("The test list category method failed ", 1, list.size());
	}
}
