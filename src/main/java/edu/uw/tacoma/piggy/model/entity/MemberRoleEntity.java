package edu.uw.tacoma.piggy.model.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.Calendar;
import java.sql.Date;

/**
 * This class represents for a MemberRole
 * @author Cuong Tran
 */
public class MemberRoleEntity
{
	/**
	 * The field MemberID
	 */
	private Integer _MemberID;
	/**
	 * The field RoleID
	 */
	private Integer _RoleID;
	/**
	 * The field DateCreated
	 */
	private Date _DateCreated;


	/**
	 * The getter method for MemberID
	 */
	public Integer getMemberID() { return _MemberID; }
	
	/**
	 * The setter method for MemberID
	 */
	public void setMemberID(Integer _MemberID) { this._MemberID = _MemberID; }

	/**
	 * The getter method for RoleID
	 */
	public Integer getRoleID() { return _RoleID; }
	
	/**
	 * The setter method for RoleID
	 */
	public void setRoleID(Integer _RoleID) { this._RoleID = _RoleID; }

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
	public void initialMemberRole()
	{
		setMemberID(0);
		setRoleID(0);
		setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
	}
	
	/**
	 * @author Cuong_Tran
	 * The default constructor for MemberRole
	 */
	public MemberRoleEntity() { initialMemberRole(); }
	
	/**
	 * @author Cuong_Tran
	 * The constructor with given fields' values for MemberRole
	 */
	public MemberRoleEntity(Integer _MemberID,Integer _RoleID,Date _DateCreated) // need to be data type default value
	{
		setMemberID(_MemberID);
		setRoleID(_RoleID);
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
			name = "MemberRole";
		
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
	 * The method represent MemberRole as string.
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("MemberID=").append(getMemberID() == null ? "NULL" : getMemberID()).append(",");
		result.append("RoleID=").append(getRoleID() == null ? "NULL" : getRoleID()).append(",");
		result.append("DateCreated=").append(getDateCreated() == null ? "NULL" : getDateCreated()).append(",");
		// result = result.substring(0, result.length() - 1);
		return "{" + result.toString() + "}";
	}
}
