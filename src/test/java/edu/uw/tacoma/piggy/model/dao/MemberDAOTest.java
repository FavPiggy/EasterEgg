package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import edu.uw.tacoma.piggy.model.entity.MemberEntity;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the Member DAO
 * @author Kerry Ferguson
 */
public class MemberDAOTest
extends TestCase
{
	public void testListMember()
	{
		List<MemberEntity> list = MemberDAO.listMember();
		Assert.assertEquals("The test method category method failed ", 0, list.size());
	}
	
	public void testListMemberID()
	{
		List<MemberEntity> list = MemberDAO.listMember("ID", "0");
		Assert.assertEquals("The test method category method failed ", 0, list.size());
	}
}
