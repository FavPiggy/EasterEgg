package edu.uw.tacoma.db.tag;


import java.io.Serializable;

@SuppressWarnings("serial")
public class TagKeyForeign
implements Serializable
{
	public TagColumn key;
	public TagTableRef table;
	public TagColumnRef field;
	
	public TagKeyForeign(TagColumn ikey, TagTable itable, TagColumn ifield)
	{
		key = ikey;
		table = new TagTableRef(itable);
		field = new TagColumnRef(ifield);
	}
	
	public String toString()
	{
		return key.toString();
	}
}
