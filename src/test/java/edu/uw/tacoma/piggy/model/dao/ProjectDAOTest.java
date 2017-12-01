package edu.uw.tacoma.piggy.model.dao;

import java.sql.Date;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import edu.uw.tacoma.piggy.model.entity.ProjectEntity;

/**
 * The test case for the Project DAO
 * @author Kerry Ferguson
 */
public class ProjectDAOTest
extends TestCase
{
	public void testProject()
	{
		ProjectEntity entity;
		
		List<ProjectEntity> list = ProjectDAO.listProject();
		Assert.assertEquals("The test list Project method failed ", 2, list.size());
		
		// should set different field values
		entity = new ProjectEntity();
		entity.setProjectID(10);
		entity.setProjectName("");
		entity.setProjectAbbr("");
		entity.setDescription("");
		entity.setStartDate(new Date(Calendar.getInstance().getTime().getTime()));
		entity.setCategoryID(0);
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test insert method failed ", ProjectDAO.insert(entity));
		
		entity.setProjectID(10);
		entity.setProjectName("");
		entity.setProjectAbbr("");
		entity.setDescription("");
		entity.setStartDate(new Date(Calendar.getInstance().getTime().getTime()));
		entity.setCategoryID(0);
		entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		Assert.assertTrue("The test update method failed ", ProjectDAO.update(entity));
		Assert.assertTrue("The test delete method failed ", ProjectDAO.delete(entity));
	}

}
