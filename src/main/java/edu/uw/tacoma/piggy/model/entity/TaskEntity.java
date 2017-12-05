package edu.uw.tacoma.piggy.model.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.Calendar;
import java.sql.Date;

/**
 * This class represents for a Task
 * @author Cuong Tran
 */
public class TaskEntity
{
	/**
	 * The field TaskID
	 */
	private Integer _TaskID;
	/**
	 * The field ProjectID
	 */
	private Integer _ProjectID;
	/**
	 * The field StartDate
	 */
	private Date _StartDate;
	/**
	 * The field Duration
	 */
	private Integer _Duration;
	/**
	 * The field Description
	 */
	private String _Description;
	/**
	 * The field UserID
	 */
	private Integer _UserID;
	/**
	 * The field ParentTask
	 */
	private Integer _ParentTask;
	/**
	 * The field DateCreated
	 */
	private Date _DateCreated;


	/**
	 * The getter method for TaskID
	 */
	public Integer getTaskID() { return _TaskID; }
	
	/**
	 * The setter method for TaskID
	 */
	public void setTaskID(Integer _TaskID) { this._TaskID = _TaskID; }

	/**
	 * The getter method for ProjectID
	 */
	public Integer getProjectID() { return _ProjectID; }
	
	/**
	 * The setter method for ProjectID
	 */
	public void setProjectID(Integer _ProjectID) { this._ProjectID = _ProjectID; }

	/**
	 * The getter method for StartDate
	 */
	public Date getStartDate() { return _StartDate; }
	
	/**
	 * The setter method for StartDate
	 */
	public void setStartDate(Date _StartDate) { this._StartDate = _StartDate; }

	/**
	 * The getter method for Duration
	 */
	public Integer getDuration() { return _Duration; }
	
	/**
	 * The setter method for Duration
	 */
	public void setDuration(Integer _Duration) { this._Duration = _Duration; }

	/**
	 * The getter method for Description
	 */
	public String getDescription() { return _Description; }
	
	/**
	 * The setter method for Description
	 */
	public void setDescription(String _Description) { this._Description = _Description; }

	/**
	 * The getter method for UserID
	 */
	public Integer getUserID() { return _UserID; }
	
	/**
	 * The setter method for UserID
	 */
	public void setUserID(Integer _UserID) { this._UserID = _UserID; }

	/**
	 * The getter method for ParentTask
	 */
	public Integer getParentTask() { return _ParentTask; }
	
	/**
	 * The setter method for ParentTask
	 */
	public void setParentTask(Integer _ParentTask) { this._ParentTask = _ParentTask; }

	/**
	 * The getter method for DateCreated
	 */
	public Date getDateCreated() { return _DateCreated; }
	
	/**
	 * The setter method for DateCreated
	 */
	public void setDateCreated(Date _DateCreated) { this._DateCreated = _DateCreated; }

	/**
	 * The method initializes fields
	 */
	public void initialTask()
	{
		setTaskID(0);
		setProjectID(0);
		setStartDate(new Date(Calendar.getInstance().getTime().getTime()));
		setDuration(0);
		setDescription("");
		setUserID(0);
		setParentTask(0);
		setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
	}
	
	/**
	 * @author Cuong_Tran
	 * The default constructor for Task
	 */
	public TaskEntity() { initialTask(); }
	
	/**
	 * @author Cuong_Tran
	 * The constructor with given fields' values for Task
	 */
	public TaskEntity(Integer _TaskID,Integer _ProjectID,Date _StartDate,Integer _Duration,String _Description,Integer _UserID,Integer _ParentTask,Date _DateCreated) // need to be data type default value
	{
		setTaskID(_TaskID);
		setProjectID(_ProjectID);
		setStartDate(_StartDate);
		setDuration(_Duration);
		setDescription(_Description);
		setUserID(_UserID);
		setParentTask(_ParentTask);
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
			name = "Task";
		
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
	 * The method represent Task as string.
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TaskID=").append(getTaskID() == null ? "NULL" : getTaskID()).append(",");
		result.append("ProjectID=").append(getProjectID() == null ? "NULL" : getProjectID()).append(",");
		result.append("StartDate=").append(getStartDate() == null ? "NULL" : getStartDate()).append(",");
		result.append("Duration=").append(getDuration() == null ? "NULL" : getDuration()).append(",");
		result.append("Description=").append(getDescription() == null ? "NULL" : getDescription()).append(",");
		result.append("UserID=").append(getUserID() == null ? "NULL" : getUserID()).append(",");
		result.append("ParentTask=").append(getParentTask() == null ? "NULL" : getParentTask()).append(",");
		result.append("DateCreated=").append(getDateCreated() == null ? "NULL" : getDateCreated()).append(",");
		// result = result.substring(0, result.length() - 1);
		return "{" + result.toString() + "}";
	}
}
