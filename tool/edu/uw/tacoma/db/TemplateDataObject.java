package edu.uw.tacoma.db;

import edu.uw.tacoma.db.tag.*;

public class TemplateDataObject
{
	public static TagServer getServerObject()
	{
		int position;
		TagServer server = new TagServer("sample");

		TagDatabase database;
		server.host = "localhost";
		server.type = "csvfile";
		server.user = "varik";
		server.pass = "hoang";
		database = new TagDatabase("project");
		
		TagTypeLang lint, lstr, ldt;
		lint = new TagTypeLang("Integer");
		lstr = new TagTypeLang("String");
		ldt = new TagTypeLang("Date");
		
		TagTypeSQL sint, sstr, sdt;
		sint = new TagTypeSQL("Int");
		sstr = new TagTypeSQL("String");
		sdt = new TagTypeSQL("Date");
		
		TagTypeValue defint, defstr, defdt;
		defint = new TagTypeValue("0");
		defstr = new TagTypeValue("\"\"");
		defdt = new TagTypeValue("null");
		
		position = 3;
		TagTable cat = new TagTable("Category");
		cat.add(new TagColumn("CatID", new TagType("int"), lint, sint, defint, position++));
		cat.add(new TagColumn("CatName", new TagType("varchar(50)"), lstr, sstr, defstr, position++));
		cat.add(new TagColumn("Description", new TagType("varchar(200)"), lstr, sstr, defstr, position++));
		cat.add(new TagColumn("DateCreated", new TagType("datetime"), ldt, sdt, defdt, position++));
		cat.add(new TagKeyPrimary(cat.columns.get(0)));
		database.add(cat);
		
		position = 3;
		TagTable user = new TagTable("User");
		user.add(new TagColumn("UserID", new TagType("int"), lint, sint, defint, position++));
		user.add(new TagColumn("FirstName", new TagType("varchar(50)"), lint, sstr, defint, position++));
		user.add(new TagColumn("LastName", new TagType("varchar(50)"), lstr, sstr, defstr, position++));
		user.add(new TagColumn("PhoneNumber", new TagType("char(10)"), lstr, sstr, defstr, position++));
		user.add(new TagKeyPrimary(user.columns.get(0)));
		database.add(user);
		
		position = 3;
		TagTable role = new TagTable("Role");
		role.add(new TagColumn("RoleID", new TagType("int"), lint, sint, defint, position++));
		role.add(new TagColumn("RoleName", new TagType("varchar(50)"), lstr, sstr, defstr, position++));
		role.add(new TagColumn("Description", new TagType("varchar(200)"), lstr, sstr, defstr, position++));
		role.add(new TagColumn("DateCreated", new TagType("datetime"), ldt, sdt, defdt, position++));
		role.add(new TagKeyPrimary(role.columns.get(0)));
		database.add(role);
		
		position = 3;
		TagTable project = new TagTable("Project");
		project.add(new TagColumn("ProjectID", new TagType("int"), lint, sint, defint, position++));
		project.add(new TagColumn("ProjectName", new TagType("varchar(50)"), lstr, sstr, defstr, position++));
		project.add(new TagColumn("ProjectAbbr", new TagType("varchar(5)"), lstr, sstr, defstr, position++));
		project.add(new TagColumn("Description", new TagType("varchar(200)"), lstr, sstr, defstr, position++));
		project.add(new TagColumn("StartDate", new TagType("datetime"), ldt, sdt, defdt, position++));
		project.add(new TagColumn("CategoryID", new TagType("int"), lint, sint, defint, position++));
		project.add(new TagColumn("DateCreated", new TagType("datetime"), ldt, sdt, defdt, position++));
		project.add(new TagKeyPrimary(project.columns.get(0)));
		project.add(new TagKeyForeign(project.columns.get(5), cat, cat.columns.get(0)));
		database.add(project);
		
		position = 3;
		TagTable task = new TagTable("Task");
		task.add(new TagColumn("TaskID", new TagType("int"), lint, sint, defint, position++));
		task.add(new TagColumn("ProjectID", new TagType("int"), lint, sint, defint, position++));
		task.add(new TagColumn("StartDate", new TagType("datetime"), ldt, sdt, defdt, position++));
		task.add(new TagColumn("Duration", new TagType("int"), lint, sint, defint, position++));
		task.add(new TagColumn("Description", new TagType("varchar(200)"), lstr, sstr, defstr, position++));
		task.add(new TagColumn("UserID", new TagType("int"), lint, sint, defint, position++));
		task.add(new TagColumn("ParentTask", new TagType("int"), lint, sint, defint, position++));
		task.add(new TagColumn("DateCreated", new TagType("datetime"), ldt, sdt, defdt, position++));
		task.add(new TagKeyPrimary(task.columns.get(0)));
		task.add(new TagKeyForeign(task.columns.get(1), project, project.columns.get(0)));
		task.add(new TagKeyForeign(task.columns.get(5), user, user.columns.get(0)));
		task.add(new TagKeyForeign(task.columns.get(6), task, task.columns.get(0)));
		database.add(task);
		
		position = 3;
		TagTable member = new TagTable("Member");
		member.add(new TagColumn("MemberID", new TagType("int"), lint, sint, defint, position++));
		member.add(new TagColumn("ProjectID", new TagType("int"), lint, sint, defint, position++));
		member.add(new TagColumn("UserID", new TagType("int"), lint, sint, defint, position++));
		member.add(new TagColumn("DateJoined", new TagType("datetime"), ldt, sdt, defdt, position++));
		member.add(new TagKeyPrimary(member.columns.get(0)));
		member.add(new TagKeyForeign(member.columns.get(1), project, project.columns.get(0)));
		member.add(new TagKeyForeign(member.columns.get(2), user, user.columns.get(0)));
		database.add(member);
		
		position = 3;
		TagTable memberrole = new TagTable("MemberRole");
		memberrole.add(new TagColumn("MemberID", new TagType("int"), lint, sint, defint, position++));
		memberrole.add(new TagColumn("RoleID", new TagType("int"), lint, sint, defint, position++));
		memberrole.add(new TagColumn("DateCreated", new TagType("datetime"), ldt, sdt, defdt, position++));
		memberrole.add(new TagKeyPrimary(memberrole.columns.get(0)));
		memberrole.add(new TagKeyPrimary(memberrole.columns.get(1)));
		memberrole.add(new TagKeyForeign(memberrole.columns.get(0), member, member.columns.get(0)));
		memberrole.add(new TagKeyForeign(memberrole.columns.get(1), role, role.columns.get(0)));
		database.add(memberrole);
		
		position = 3;
		TagTable taskmember = new TagTable("MemberRole");
		taskmember.add(new TagColumn("TaskID", new TagType("int"), lint, sint, defint, position++));
		taskmember.add(new TagColumn("MemberID", new TagType("int"), lint, sint, defint, position++));
		taskmember.add(new TagKeyPrimary(taskmember.columns.get(0)));
		taskmember.add(new TagKeyPrimary(taskmember.columns.get(1)));
		taskmember.add(new TagKeyForeign(taskmember.columns.get(0), task, task.columns.get(0)));
		taskmember.add(new TagKeyForeign(taskmember.columns.get(1), member, member.columns.get(0)));
		database.add(taskmember);

		server.add(database);
		return server;
	}
}
