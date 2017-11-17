package edu.uw.tacoma.db.tag;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TagServer
implements Serializable
{
	public String host;
	public String type;
	public String user;
	public String pass;
	public List<TagDatabase> databases;
	
	public TagServer() 				{ this("localhost", "derby", null, null); }
	public TagServer(String host)	{ this(host, "derby", null, null); }
	public TagServer(String host, String type, String user, String pass)
	{
		this.host = host;
		this.type = type;
		this.user = user;
		this.pass = pass;
	}
	
	public void add(TagDatabase database)
	{
		if (databases == null)
			databases = new ArrayList<TagDatabase>();
		
		databases.add(database);
	}
	
	public String toString()
	{
		return host;
	}
}
