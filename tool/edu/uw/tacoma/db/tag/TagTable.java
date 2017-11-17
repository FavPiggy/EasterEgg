package edu.uw.tacoma.db.tag;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TagTable
implements Serializable
{
	public String name;
	public Integer index; // default: 0
	
	public List<TagColumn> columns;
	public List<TagKeyPrimary> primarykeys;
	public List<TagKeyForeign> foreignkeys;
	
	public TagTable(String name) { this(name, 0); }
	public TagTable(String name, Integer index)
	{
		this.name = name;
		this.index = index;
	}
	
	public void add(TagColumn column)
	{
		if (columns == null)
			columns  = new ArrayList<TagColumn>();
		
		columns.add(column);
	}
	
	public void add(TagKeyPrimary primary)
	{
		if (primarykeys == null)
			primarykeys  = new ArrayList<TagKeyPrimary>();
		
		// imply to set data type for primary key field
//		for (TagColumn column: columns)
//			if (column.name.equals(primary.column.name))
//				primary.type = column.type;
		
		primarykeys.add(primary);
	}
	
	public void add(TagKeyForeign foreign)
	{
		if (foreignkeys == null)
			foreignkeys  = new ArrayList<TagKeyForeign>();
		
		foreignkeys.add(foreign);
	}
	
	public String toString()
	{
		return name;
	}
}
