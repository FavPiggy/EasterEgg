package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import edu.uw.tacoma.piggy.model.entity.TaskMemberEntity;

/**
 * The test case for the TaskMember DAO
 * @author Kerry Ferguson
 */
public class TaskMemberDAOTest
extends TestCase
{
	public void testTaskMember()
	{
		TaskMemberEntity entity;
		
		List<TaskMemberEntity> list = TaskMemberDAO.listTaskMember();
		Assert.assertEquals("The test list TaskMember method failed ", 5, list.size());
		
		// should set different field values
		entity = new TaskMemberEntity();
		entity.setTaskID(10);
		entity.setMemberID(0);
		Assert.assertTrue("The test insert method failed ", TaskMemberDAO.insert(entity));
		
		entity.setTaskID(10);
		entity.setMemberID(0);
		Assert.assertTrue("The test update method failed ", TaskMemberDAO.update(entity));
		Assert.assertTrue("The test delete method failed ", TaskMemberDAO.delete(entity));
	}

}
