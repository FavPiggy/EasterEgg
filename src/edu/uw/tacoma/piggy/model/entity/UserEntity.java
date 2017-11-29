package edu.uw.tacoma.piggy.model.entity;

import java.sql.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents for a User
 * @author Cuong Tran
 */
public class UserEntity
{
	/**
	 * The field UserID
	 */
	private Integer _UserID;
	/**
	 * The field FirstName
	 */
	private String _FirstName;
	/**
	 * The field LastName
	 */
	private String _LastName;
	/**
	 * The field PhoneNumber
	 */
	private String _PhoneNumber;


	/**
	 * The getter method for UserID
	 */
	public Integer getUserID() { return _UserID; }
	
	/**
	 * The setter method for UserID
	 */
	public void setUserID(Integer _UserID) { this._UserID = _UserID; }

	/**
	 * The getter method for FirstName
	 */
	public String getFirstName() { return _FirstName; }
	
	/**
	 * The setter method for FirstName
	 */
	public void setFirstName(String _FirstName) { this._FirstName = _FirstName; }

	/**
	 * The getter method for LastName
	 */
	public String getLastName() { return _LastName; }
	
	/**
	 * The setter method for LastName
	 */
	public void setLastName(String _LastName) { this._LastName = _LastName; }

	/**
	 * The getter method for PhoneNumber
	 */
	public String getPhoneNumber() { return _PhoneNumber; }
	
	/**
	 * The setter method for PhoneNumber
	 */
	public void setPhoneNumber(String _PhoneNumber) { this._PhoneNumber = _PhoneNumber; }

	/**
	 * @author Varik Hoang
	 * The method initialize the default value for fields
	 */
	public void initialUser()
	{
		setUserID(0);
		setFirstName("");
		setLastName("");
		setPhoneNumber("");
	}

	/**
	 * @author Cuong_Tran
	 * The default constructor for User
	 */
	public UserEntity() { initialUser(); }
	
	/**
	 * @author Cuong_Tran
	 * The constructor with given fields' values for User
	 */
	public UserEntity(Integer _UserID,String _FirstName,String _LastName,String _PhoneNumber) // need to be data type default value
	{
		initialUser();
		setUserID(_UserID);
		setFirstName(_FirstName);
		setLastName(_LastName);
		setPhoneNumber(_PhoneNumber);
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
			name = "User";
		
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
	 * The method represent User as string.
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("UserID=").append(getUserID() == null ? "NULL" : getUserID()).append(",");
		result.append("FirstName=").append(getFirstName() == null ? "NULL" : getFirstName()).append(",");
		result.append("LastName=").append(getLastName() == null ? "NULL" : getLastName()).append(",");
		result.append("PhoneNumber=").append(getPhoneNumber() == null ? "NULL" : getPhoneNumber()).append(",");
		// result = result.substring(0, result.length() - 1);
		return "{" + result.toString() + "}";
	}
}
