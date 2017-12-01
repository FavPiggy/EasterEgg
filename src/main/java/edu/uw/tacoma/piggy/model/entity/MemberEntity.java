package edu.uw.tacoma.piggy.model.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.Calendar;
import java.sql.Date;

/**
 * This class represents for a Member
 * @author Cuong Tran
 */
public class MemberEntity
{
	/**
	 * The field MemberID
	 */
	private Integer _MemberID;
	/**
	 * The field ProjectID
	 */
	private Integer _ProjectID;
	/**
	 * The field UserID
	 */
	private Integer _UserID;
	/**
	 * The field DateJoined
	 */
	private Date _DateJoined;


	/**
	 * The getter method for MemberID
	 */
	public Integer getMemberID() { return _MemberID; }
	
	/**
	 * The setter method for MemberID
	 */
	public void setMemberID(Integer _MemberID) { this._MemberID = _MemberID; }

	/**
	 * The getter method for ProjectID
	 */
	public Integer getProjectID() { return _ProjectID; }
	
	/**
	 * The setter method for ProjectID
	 */
	public void setProjectID(Integer _ProjectID) { this._ProjectID = _ProjectID; }

	/**
	 * The getter method for UserID
	 */
	public Integer getUserID() { return _UserID; }
	
	/**
	 * The setter method for UserID
	 */
	public void setUserID(Integer _UserID) { this._UserID = _UserID; }

	/**
	 * The getter method for DateJoined
	 */
	public Date getDateJoined() { return _DateJoined; }
	
	/**
	 * The setter method for DateJoined
	 */
	public void setDateJoined(Date _DateJoined) { this._DateJoined = _DateJoined; }

	/**
	 * The method initializes fields
	 */
	public void initialMember()
	{
		setMemberID(0);
		setProjectID(0);
		setUserID(0);
		setDateJoined(new Date(Calendar.getInstance().getTime().getTime()));
	}
	
	/**
	 * @author Cuong_Tran
	 * The default constructor for Member
	 */
	public MemberEntity() { initialMember(); }
	
	/**
	 * @author Cuong_Tran
	 * The constructor with given fields' values for Member
	 */
	public MemberEntity(Integer _MemberID,Integer _ProjectID,Integer _UserID,Date _DateJoined) // need to be data type default value
	{
		setMemberID(_MemberID);
		setProjectID(_ProjectID);
		setUserID(_UserID);
		setDateJoined(_DateJoined);
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
			name = "Member";
		
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
	 * The method represent Member as string.
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("MemberID=").append(getMemberID() == null ? "NULL" : getMemberID()).append(",");
		result.append("ProjectID=").append(getProjectID() == null ? "NULL" : getProjectID()).append(",");
		result.append("UserID=").append(getUserID() == null ? "NULL" : getUserID()).append(",");
		result.append("DateJoined=").append(getDateJoined() == null ? "NULL" : getDateJoined()).append(",");
		// result = result.substring(0, result.length() - 1);
		return "{" + result.toString() + "}";
	}
}
