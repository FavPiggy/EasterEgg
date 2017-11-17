package edu.uw.tacoma.db.tag;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TagColumn
implements Serializable
{
	public String name;
	public TagType type;
	public TagTypeLang lang;
	public TagTypeSQL sql;
	public TagTypeValue value;
	public TagColumnPos pos;
	
	public TagColumn(String name, TagType type, TagTypeLang lang, TagTypeSQL sql, TagTypeValue value, Integer pos)
	{
		this.name = name;
		this.type = type;
		this.lang = lang;
		this.sql = sql;
		this.value = value;
		this.pos = new TagColumnPos(pos);
	}
	
	public String toString()
	{
		return name;
	}
}
