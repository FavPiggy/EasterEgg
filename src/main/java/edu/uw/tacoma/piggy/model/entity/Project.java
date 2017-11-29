package edu.uw.tacoma.piggy.model.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Project {
	/**Project Id field.	*/
	private int projectId;
	
	/**Project name field.	*/
	private String projectName;
	/**	*/
	private String projectAbbr;
	/**	*/
	private String description;
	/**	*/
	private Date startDate;
	/**	*/
	private int categoryId;
	
	/**	*/
	private int userCreated;
	
	/**
	 * @author Cuong_Tran
	 * The default constructor for project object.
	 */
	public Project() {
		
	}
	
	/**
	 * @author Cuong_Tran
	 * The constructor allows to create object with project Id and project's name.
	 * @param theId assigns a Id to project.
	 * @param theName assigns a Name of the project.
	 */
	public Project(int theId, String theName) {
		this.projectId = theId;
		this.projectName = theName;
	}
	
	
	/**
	 * @author Cuong_Tran
	 * Constructor allows to create object with project Id, project's name and user who creates it.
	 * @param theId assigns a Id to project.
	 * @param theName assigns a Name of the project.
	 * @param theUserId assigns a user Id who creates project.
	 */
	public Project(int theId, String theName, int theUserId) {
		this.projectId = theId;
		this.projectName = theName;
		this.userCreated = theUserId;
	}
	/**
	 * @author Cuong_Tran
	 * Constructor allows to create object with project Id, project's name, start date, and user who creates it.
	 * @param theId assigns the Id to project.
	 * @param theName assigns a Name of the project.
	 * @param theDate assigns a start date of project.
	 * @param theUserId assigns a user Id who creates project.
	 */
	public Project(int theId, String theName, Date theDate, int theUserId) {
		this.projectId = theId;
		this.projectName = theName;
		this.startDate = theDate;
		this.userCreated = theUserId;
	}
	
	/**
	 * @author Cuong_Tran
	 * Constructor allows to create new object with full arguments.
	 * @param theId assigns the Id to project.
	 * @param theName assigns a Name of the project.
	 * @param theAbbr assign a abbreviation.
	 * @param theDescription assign a description for project.
	 * @param theStartDate assigns a start date of project.
	 * @param theCatId assign a category id for project.
	 * @param theUserId assigns a user Id who creates project.
	 */
	public Project(int theId, String theName, String theAbbr, String theDescription, 
					Date theStartDate, int theCatId, int theUserId) {
		this.projectId = theId;
		this.projectName = theName;
		this.startDate = theStartDate;
		this.userCreated = theUserId;
		this.projectAbbr = theAbbr;
		this.description = theDescription;
		this.categoryId = theCatId;
	}
	
		
	/**
	 * @author Cuong_Tran
	 * Default export method for project object.
	 */
	public void export()
	{
		export(null);
	}
	
	/**
	 * This method allows to assign new name to export.
	 * @param name assign new name to export
	 */
	public void export (String name) 
	  {
		if (name == null)
			name = "project";
		
	    ObjectOutputStream oos = null;
	    FileOutputStream fout = null;
	    try{ 
	      fout = new FileOutputStream("c:\\" + name + ".ser", true);
	      oos = new ObjectOutputStream(fout);
	      oos.writeObject(this);
	     } catch (Exception ex) {} 
	     finally {
	       if(oos != null){
	         try {oos.close();} catch (Exception ex) {}
	       } 
	     }
	 }
	
	
	/**
	 * toString method to help debug and check project object information.
	 */
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		StringBuilder builder = new StringBuilder();
		builder.append("Project ID = ");
		builder.append(projectId);
		builder.append(", Project Name: ");
		builder.append(projectName);
		builder.append(", Abbreviation: ");
		builder.append(projectAbbr);
		builder.append(", Description: ");
		builder.append(description);
		builder.append(", Category ID: ");
		builder.append(categoryId);
		builder.append(", User created: ");
		builder.append(userCreated);
		builder.append(", Date created: ");
		builder.append(dateFormat.format(startDate));	
		
		return builder.toString();
	}
}
