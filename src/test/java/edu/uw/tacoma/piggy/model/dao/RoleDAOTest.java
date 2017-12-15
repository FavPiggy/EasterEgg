package edu.uw.tacoma.piggy.model.dao;


import java.sql.Date;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import edu.uw.tacoma.piggy.model.entity.RoleEntity;

/**
 * The test case for the Role DAO
 * @author Kerry Ferguson
 */
public class RoleDAOTest
extends TestCase
{

	public void testRole()
	{
		RoleEntity entity;
		
		List<RoleEntity> list = RoleDAO.listRole();
		Assert.assertEquals("The test list Role method failed ", 4, list.size());
		
		// should set different field values
		entity = new RoleEntity();
		entity.setRoleID(10);
		entity.setRoleName("");
		entity.setDescription("");
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test insert method failed ", RoleDAO.insert(entity));
		
		entity.setRoleID(10);
		entity.setRoleName("");
		entity.setDescription("");
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test update method failed ", RoleDAO.update(entity));
		Assert.assertTrue("The test delete method failed ", RoleDAO.delete(entity));
	}

}
