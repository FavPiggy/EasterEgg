package edu.uw.tacoma.piggy.model.entity;


import java.util.Calendar;
import java.sql.Date;


import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * The test case for the Project entity
 * @author Kirtwinder Gulati
 */
public class ProjectEntityTest
extends TestCase
{
	public void testConstructor()
	{
		boolean succeed = false;
		
		try
		{

			new ProjectEntity();
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor failed ", succeed);
	}
	
	public void testConstructorWithParameters()
	{
		boolean succeed = false;
		
		try
		{

			ProjectEntity entity = new ProjectEntity();
			entity.setProjectID(0);
			entity.setProjectName("");
			entity.setProjectAbbr("");
			entity.setDescription("");
			entity.setStartDate(new Date(Calendar.getInstance().getTime().getTime()));
			entity.setCategoryID(0);
			entity.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
			succeed = true;
		}
		catch (Exception ex) {}
		
		Assert.assertTrue("The test constructor with parameter failed ", succeed);
	}

	
	public void testGetProjectID()
	{
		Assert.assertEquals("The test setProjectID method failed ", 0, new ProjectEntity().getProjectID().intValue());
	}
	
	public void testGetProjectName()
	{
		Assert.assertEquals("The test setProjectID method failed ", "", new ProjectEntity().getProjectName());
	}
	
	public void testGetProjectAbbr()
	{
		Assert.assertEquals("The test setProjectID method failed ", "", new ProjectEntity().getProjectAbbr());
	}
	
	public void testGetDescription()
	{
		Assert.assertEquals("The test setProjectID method failed ", "", new ProjectEntity().getDescription());
	}
	
	public void testSetProjectID()
	{
		
		
		ProjectEntity entity = new ProjectEntity(0, "Piggy Application", "PIGGY", "The main piggy project", 
												new ProjectEntity().getStartDate(), 1, new ProjectEntity().getDateCreated());
		Assert.assertEquals("The test setProjectID method failed ", 0, entity.getProjectID().intValue());
	}
	
	public void testSetProjectName()
	{
		ProjectEntity entity = new ProjectEntity(0, "Piggy Application", "PIGGY", "The main piggy project", 
												new ProjectEntity().getStartDate(), 1, new ProjectEntity().getDateCreated());
		Assert.assertEquals("The test setProjectName method failed ", "Internal Project", entity.getProjectName());
	}
	
	public void testSetDescription()
	{
		ProjectEntity entity = new ProjectEntity(0, "Piggy Application", "PIGGY", "The main piggy project", 
												 new ProjectEntity().getStartDate(), 1, new ProjectEntity().getDateCreated());
		Assert.assertEquals("The test setDescription method failed ", "...", entity.getDescription());
	}

}
