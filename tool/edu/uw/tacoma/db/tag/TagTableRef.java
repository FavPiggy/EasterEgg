package edu.uw.tacoma.db.tag;


import java.io.Serializable;

@SuppressWarnings("serial")
public class TagTableRef
implements Serializable
{
	public String name;
	
	public TagTableRef(TagTable table)
	{
		this.name = table.name;
	}
	
	public String toString()
	{
		return name;
	}
}
