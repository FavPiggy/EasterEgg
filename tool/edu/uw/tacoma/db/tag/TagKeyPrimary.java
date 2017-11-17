package edu.uw.tacoma.db.tag;


import java.io.Serializable;

@SuppressWarnings("serial")
public class TagKeyPrimary
implements Serializable
{
	TagColumn column;
	
	public TagKeyPrimary(TagColumn column)
	{
		this.column = column;
	}
	
	public String toString()
	{
		return column.toString();
	}
}
