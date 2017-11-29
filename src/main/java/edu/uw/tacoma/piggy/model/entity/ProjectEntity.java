package edu.uw.tacoma.piggy.model.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * This class represents for a Project
 * @author Cuong Tran
 */
public class ProjectEntity
{
	/**
	 * The field ProjectID
	 */
	private Integer _ProjectID;
	/**
	 * The field ProjectName
	 */
	private String _ProjectName;
	/**
	 * The field ProjectAbbr
	 */
	private String _ProjectAbbr;
	/**
	 * The field Description
	 */
	private String _Description;
	/**
	 * The field StartDate
	 */
	private Date _StartDate;
	/**
	 * The field CategoryID
	 */
	private Integer _CategoryID;
	/**
	 * The field DateCreated
	 */
	private Date _DateCreated;


	/**
	 * The getter method for ProjectID
	 */
	public Integer getProjectID() { return _ProjectID; }
	
	/**
	 * The setter method for ProjectID
	 */
	public void setProjectID(Integer _ProjectID) { this._ProjectID = _ProjectID; }

	/**
	 * The getter method for ProjectName
	 */
	public String getProjectName() { return _ProjectName; }
	
	/**
	 * The setter method for ProjectName
	 */
	public void setProjectName(String _ProjectName) { this._ProjectName = _ProjectName; }

	/**
	 * The getter method for ProjectAbbr
	 */
	public String getProjectAbbr() { return _ProjectAbbr; }
	
	/**
	 * The setter method for ProjectAbbr
	 */
	public void setProjectAbbr(String _ProjectAbbr) { this._ProjectAbbr = _ProjectAbbr; }

	/**
	 * The getter method for Description
	 */
	public String getDescription() { return _Description; }
	
	/**
	 * The setter method for Description
	 */
	public void setDescription(String _Description) { this._Description = _Description; }

	/**
	 * The getter method for StartDate
	 */
	public Date getStartDate() { return _StartDate; }
	
	/**
	 * The setter method for StartDate
	 */
	public void setStartDate(Date _StartDate) { this._StartDate = _StartDate; }

	/**
	 * The getter method for CategoryID
	 */
	public Integer getCategoryID() { return _CategoryID; }
	
	/**
	 * The setter method for CategoryID
	 */
	public void setCategoryID(Integer _CategoryID) { this._CategoryID = _CategoryID; }

	/**
	 * The getter method for DateCreated
	 */
	public Date getDateCreated() { return _DateCreated; }
	
	/**
	 * The setter method for DateCreated
	 */
	public void setDateCreated(Date _DateCreated) { this._DateCreated = _DateCreated; }

	/**
	 * @author Varik Hoang
	 * The method initialize the default value for fields
	 */
	public void initialProject()
	{
		setProjectID(0);
		setProjectName("");
		setProjectAbbr("");
		setDescription("");
		setStartDate(null);
		setCategoryID(0);
		setDateCreated(null);
	}

	/**
	 * @author Cuong_Tran
	 * The default constructor for Project
	 */
	public ProjectEntity() { initialProject(); }
	
	/**
	 * @author Cuong_Tran
	 * The constructor with given fields' values for Project
	 */
	public ProjectEntity(Integer _ProjectID,String _ProjectName,String _ProjectAbbr,String _Description,Date _StartDate,Integer _CategoryID,Date _DateCreated) // need to be data type default value
	{
		initialProject();
		setProjectID(_ProjectID);
		setProjectName(_ProjectName);
		setProjectAbbr(_ProjectAbbr);
		setDescription(_Description);
		setStartDate(_StartDate);
		setCategoryID(_CategoryID);
		setDateCreated(_DateCreated);
	}
	
	/**
	 * @author Cuong Tran
	 * Default export method for project object.
	 */
	public void export()
	{
		export(null);
	}
	
	/**
	 * @author Cuong Tran
	 * This method allows to assign new name to export.
	 * @param name assign new name to export
	 */
	public void export (String name) 
	{
		if (name == null)
			name = "Project";
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		
		try
		{ 
			fout = new FileOutputStream(name + ".ser", true);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
		}
		catch (Exception ex) {} 
		finally
		{
			if(oos != null)
			{
				try {oos.close();} catch (Exception ex) {}
			} 
		}
	}

	/**
	 * @author Cuong_Tran
	 * The method represent Project as string.
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("ProjectID=").append(getProjectID() == null ? "NULL" : getProjectID()).append(",");
		result.append("ProjectName=").append(getProjectName() == null ? "NULL" : getProjectName()).append(",");
		result.append("ProjectAbbr=").append(getProjectAbbr() == null ? "NULL" : getProjectAbbr()).append(",");
		result.append("Description=").append(getDescription() == null ? "NULL" : getDescription()).append(",");
		result.append("StartDate=").append(getStartDate() == null ? "NULL" : getStartDate()).append(",");
		result.append("CategoryID=").append(getCategoryID() == null ? "NULL" : getCategoryID()).append(",");
		result.append("DateCreated=").append(getDateCreated() == null ? "NULL" : getDateCreated()).append(",");
		// result = result.substring(0, result.length() - 1);
		return "{" + result.toString() + "}";
	}
}
