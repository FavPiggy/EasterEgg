package edu.uw.tacoma.db.tag;


public class TagColumnRef
{
	public String name;
	
	public TagColumnRef(TagColumn column)
	{
		this.name = column.name;
	}
	
	public String toString()
	{
		return name;
	}
}
