package edu.uw.tacoma.piggy.model.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * This class represents for a Role
 * @author Cuong Tran
 */
public class RoleEntity
{
	/**
	 * The field RoleID
	 */
	private Integer _RoleID;
	/**
	 * The field RoleName
	 */
	private String _RoleName;
	/**
	 * The field Description
	 */
	private String _Description;
	/**
	 * The field DateCreated
	 */
	private Date _DateCreated;


	/**
	 * The getter method for RoleID
	 */
	public Integer getRoleID() { return _RoleID; }
	
	/**
	 * The setter method for RoleID
	 */
	public void setRoleID(Integer _RoleID) { this._RoleID = _RoleID; }

	/**
	 * The getter method for RoleName
	 */
	public String getRoleName() { return _RoleName; }
	
	/**
	 * The setter method for RoleName
	 */
	public void setRoleName(String _RoleName) { this._RoleName = _RoleName; }

	/**
	 * The getter method for Description
	 */
	public String getDescription() { return _Description; }
	
	/**
	 * The setter method for Description
	 */
	public void setDescription(String _Description) { this._Description = _Description; }

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
	public void initialRole()
	{
		setRoleID(0);
		setRoleName("");
		setDescription("");
		setDateCreated(null);
	}

	/**
	 * @author Cuong_Tran
	 * The default constructor for Role
	 */
	public RoleEntity() { initialRole(); }
	
	/**
	 * @author Cuong_Tran
	 * The constructor with given fields' values for Role
	 */
	public RoleEntity(Integer _RoleID,String _RoleName,String _Description,Date _DateCreated) // need to be data type default value
	{
		initialRole();
		setRoleID(_RoleID);
		setRoleName(_RoleName);
		setDescription(_Description);
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
			name = "Role";
		
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
	 * The method represent Role as string.
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("RoleID=").append(getRoleID() == null ? "NULL" : getRoleID()).append(",");
		result.append("RoleName=").append(getRoleName() == null ? "NULL" : getRoleName()).append(",");
		result.append("Description=").append(getDescription() == null ? "NULL" : getDescription()).append(",");
		result.append("DateCreated=").append(getDateCreated() == null ? "NULL" : getDateCreated()).append(",");
		// result = result.substring(0, result.length() - 1);
		return "{" + result.toString() + "}";
	}
}
