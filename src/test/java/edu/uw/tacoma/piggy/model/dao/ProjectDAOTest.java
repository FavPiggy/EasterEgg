package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import edu.uw.tacoma.piggy.model.entity.ProjectEntity;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the category DAO
 * @author Kerry Ferguson
 */
public class ProjectDAOTest
extends TestCase
{
	public void testListCategory()
	{
		List<ProjectEntity> list = ProjectDAO.listProject();
		Assert.assertEquals("The test list project method failed ", 3, list.size());
	}
	
	public void testListCategoryID()
	{
		List<ProjectEntity> list = ProjectDAO.listProject("ID", "0");
		Assert.assertEquals("The test list project method failed ", 1, list.size());
	}
}
