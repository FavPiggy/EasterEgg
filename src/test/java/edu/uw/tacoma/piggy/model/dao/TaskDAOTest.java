package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import edu.uw.tacoma.piggy.model.entity.TaskEntity;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the category DAO
 * @author Kerry Ferguson
 */
public class TaskDAOTest
extends TestCase
{
	public void testListCategory()
	{
		List<TaskEntity> list = TaskDAO.listTask();
		Assert.assertEquals("The test list task method failed ", 3, list.size());
	}
	
	public void testListCategoryID()
	{
		List<TaskEntity> list = TaskDAO.listTask("ID", "0");
		Assert.assertEquals("The test list task method failed ", 1, list.size());
	}
}
