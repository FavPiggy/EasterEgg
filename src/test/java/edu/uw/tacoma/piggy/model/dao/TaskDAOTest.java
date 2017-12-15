package edu.uw.tacoma.piggy.model.dao;


import java.sql.Date;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import edu.uw.tacoma.piggy.model.entity.TaskEntity;

/**
 * The test case for the Task DAO
 * @author Kerry Ferguson
 */
public class TaskDAOTest
extends TestCase
{
	public void testTask()
	{
		TaskEntity entity;
		
		List<TaskEntity> list = TaskDAO.listTask();
		Assert.assertEquals("The test list Task method failed ", 6, list.size());
		
		// should set different field values
		entity = new TaskEntity();
		entity.setTaskID(10);
		entity.setProjectID(0);
		entity.setStartDate(new Date(Calendar.getInstance().getTime().getTime()));
		entity.setDuration(0);
		entity.setDescription("");
		entity.setUserID(0);
		entity.setParentTask(0);
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test insert method failed ", TaskDAO.insert(entity));
		
		entity.setTaskID(10);
		entity.setProjectID(0);
		entity.setStartDate(new Date(Calendar.getInstance().getTime().getTime()));
		entity.setDuration(0);
		entity.setDescription("");
		entity.setUserID(0);
		entity.setParentTask(0);
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test update method failed ", TaskDAO.update(entity));
		Assert.assertTrue("The test delete method failed ", TaskDAO.delete(entity));
	}

}
