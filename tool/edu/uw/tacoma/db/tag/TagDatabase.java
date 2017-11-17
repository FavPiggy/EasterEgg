package edu.uw.tacoma.db.tag;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TagDatabase
implements Serializable
{
	public String name;
	public boolean partition; // default: false
	public List<TagTable> tables;
	
	public TagDatabase(String name) { this(name, false); }
	public TagDatabase(String name, boolean partition)
	{
		this.name = name;
		this.partition = partition;
	}
	
	public void add(TagTable table)
	{
		if (tables == null)
			tables = new ArrayList<TagTable>();
		
		tables.add(table);
	}
	
	public String toString()
	{
		return name;
	}
}