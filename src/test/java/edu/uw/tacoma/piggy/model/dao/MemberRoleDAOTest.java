package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import edu.uw.tacoma.piggy.model.entity.MemberRoleEntity;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the category DAO
 * @author Kerry Ferguson
 */
public class MemberRoleDAOTest
extends TestCase
{
	public void testListMemberRole()
	{
		List<MemberRoleEntity> list = MemberRoleDAO.listMemberRole();
		Assert.assertEquals("The test list member role method failed ", 3, list.size());
	}
	
	public void testListMemberRoleID()
	{
		List<MemberRoleEntity> list = MemberRoleDAO.listMemberRole("ID", "0");
		Assert.assertEquals("The test list member role method failed ", 1, list.size());
	}
}
