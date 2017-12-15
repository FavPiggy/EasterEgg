package edu.uw.tacoma.piggy.model.dao;


import java.sql.Date;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import edu.uw.tacoma.piggy.model.entity.MemberEntity;


/**
 * The test case for the Member DAO
 * @author Kerry Ferguson
 */
public class MemberDAOTest
extends TestCase
{

	public void testMember()
	{
		MemberEntity entity;
		
		List<MemberEntity> list = MemberDAO.listMember();
		Assert.assertEquals("The test list Member method failed ", 7, list.size());
		
		// should set different field values
		entity = new MemberEntity();
		entity.setMemberID(10);
		entity.setProjectID(0);
		entity.setUserID(0);
		entity.setDateJoined(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test insert method failed ", MemberDAO.insert(entity));
		
		entity.setMemberID(10);
		entity.setProjectID(0);
		entity.setUserID(0);
		entity.setDateJoined(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test update method failed ", MemberDAO.update(entity));
		Assert.assertTrue("The test delete method failed ", MemberDAO.delete(entity));
	}

}
