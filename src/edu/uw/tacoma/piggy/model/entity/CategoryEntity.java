package edu.uw.tacoma.piggy.model.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
/**
 * This class represents for a Category
 * @author Cuong Tran
 */
public class CategoryEntity
{
	/**
	 * The field CatID
	 */
	private Integer _CatID;
	/**
	 * The field CatName
	 */
	private String _CatName;
	/**
	 * The field Description
	 */
	private String _Description;
	/**
	 * The field DateCreated
	 */
	private Date _DateCreated;


	/**
	 * The getter method for CatID
	 */
	public Integer getCatID() { return _CatID; }
	
	/**
	 * The setter method for CatID
	 */
	public void setCatID(Integer _CatID) { this._CatID = _CatID; }

	/**
	 * The getter method for CatName
	 */
	public String getCatName() { return _CatName; }
	
	/**
	 * The setter method for CatName
	 */
	public void setCatName(String _CatName) { this._CatName = _CatName; }

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
	public void initialCategory()
	{
		setCatID(0);
		setCatName("");
		setDescription("");
		setDateCreated(null);
	}

	/**
	 * @author Cuong_Tran
	 * The default constructor for Category
	 */
	public CategoryEntity() { initialCategory(); }
	
	/**
	 * @author Cuong_Tran
	 * The constructor with given fields' values for Category
	 */
	public CategoryEntity(Integer _CatID,String _CatName,String _Description,Date _DateCreated) // need to be data type default value
	{
		initialCategory();
		setCatID(_CatID);
		setCatName(_CatName);
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
			name = "Category";
		
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
	 * The method represent Category as string.
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("CatID=").append(getCatID() == null ? "NULL" : getCatID()).append(",");
		result.append("CatName=").append(getCatName() == null ? "NULL" : getCatName()).append(",");
		result.append("Description=").append(getDescription() == null ? "NULL" : getDescription()).append(",");
		result.append("DateCreated=").append(getDateCreated() == null ? "NULL" : getDateCreated()).append(",");
		// result = result.substring(0, result.length() - 1);
		return "{" + result.toString() + "}";
	}
}
