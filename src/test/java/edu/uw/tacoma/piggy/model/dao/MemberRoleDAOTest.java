package edu.uw.tacoma.piggy.model.dao;


import java.sql.Date;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import edu.uw.tacoma.piggy.model.entity.MemberRoleEntity;

/**
 * The test case for the MemberRole DAO
 * @author Kerry Ferguson
 */
public class MemberRoleDAOTest
extends TestCase
{

	public void testMemberRole()
	{
		MemberRoleEntity entity;
		
		List<MemberRoleEntity> list = MemberRoleDAO.listMemberRole();
		Assert.assertEquals("The test list MemberRole method failed ", 6, list.size());
		
		// should set different field values
		entity = new MemberRoleEntity();
		entity.setMemberID(10);
		entity.setRoleID(0);
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test insert method failed ", MemberRoleDAO.insert(entity));
		
		entity.setMemberID(10);
		entity.setRoleID(0);
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test update method failed ", MemberRoleDAO.update(entity));
		Assert.assertTrue("The test delete method failed ", MemberRoleDAO.delete(entity));
	}

}
