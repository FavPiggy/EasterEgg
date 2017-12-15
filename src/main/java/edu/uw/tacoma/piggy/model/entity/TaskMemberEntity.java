package edu.uw.tacoma.piggy.model.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


/**
 * This class represents for a TaskMember
 * @author Cuong Tran
 */
public class TaskMemberEntity
{
	/**
	 * The field TaskID
	 */
	private Integer _TaskID;
	/**
	 * The field MemberID
	 */
	private Integer _MemberID;


	/**
	 * The getter method for TaskID
	 */
	public Integer getTaskID() { return _TaskID; }
	
	/**
	 * The setter method for TaskID
	 */
	public void setTaskID(Integer _TaskID) { this._TaskID = _TaskID; }

	/**
	 * The getter method for MemberID
	 */
	public Integer getMemberID() { return _MemberID; }
	
	/**
	 * The setter method for MemberID
	 */
	public void setMemberID(Integer _MemberID) { this._MemberID = _MemberID; }

	/**
	 * The method initializes fields
	 */
	public void initialTaskMember()
	{
		setTaskID(0);
		setMemberID(0);
	}
	
	/**
	 * @author Cuong_Tran
	 * The default constructor for TaskMember
	 */
	public TaskMemberEntity() { initialTaskMember(); }
	
	/**
	 * @author Cuong_Tran
	 * The constructor with given fields' values for TaskMember
	 */
	public TaskMemberEntity(Integer _TaskID,Integer _MemberID) // need to be data type default value
	{
		setTaskID(_TaskID);
		setMemberID(_MemberID);
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
			name = "TaskMember";
		
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
	 * The method represent TaskMember as string.
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("TaskID=").append(getTaskID() == null ? "NULL" : getTaskID()).append(",");
		result.append("MemberID=").append(getMemberID() == null ? "NULL" : getMemberID()).append(",");
		// result = result.substring(0, result.length() - 1);
		return "{" + result.toString() + "}";
	}
}
