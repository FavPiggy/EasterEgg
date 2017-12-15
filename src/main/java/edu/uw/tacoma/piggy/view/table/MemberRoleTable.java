package edu.uw.tacoma.piggy.view.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uw.tacoma.piggy.model.dao.MemberRoleDAO;
import edu.uw.tacoma.piggy.model.entity.MemberRoleEntity;

@SuppressWarnings("serial")
public class MemberRoleTable
extends JTable
{
	private List<MemberRoleEntity> entities;
	
	private DefaultTableModel model;
	private Object[] data;
	
	public MemberRoleTable()
	{
		data = new Object[] { "MemberID", "RoleID", "DateCreated" };
		model = new DefaultTableModel(data, 0);
		
		setModel(model);
	}
	
	public void insert(MemberRoleEntity entity)
	{
		MemberRoleDAO.insert(entity);
		clearData();
		loadData();
	}
	
	public void update(MemberRoleEntity entity)
	{
		MemberRoleDAO.update(entity);
		clearData();
		loadData();
	}
	
	public void delete(MemberRoleEntity entity)
	{
		MemberRoleDAO.delete(entity);
		clearData();
		loadData();
	}
	
	public MemberRoleEntity getData(int row)
	{
		return entities.get(row);
	}
	
	public void loadData()
	{
		entities = MemberRoleDAO.listMemberRole();
		for (MemberRoleEntity entity : entities)
			addRow(entity);
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(MemberRoleEntity entity)
	{
		data[0] = entity.getMemberID();
		data[1] = entity.getRoleID();
		data[2] = entity.getDateCreated();
		model.addRow(data);
	}
	
	@Override
	public boolean isCellEditable(int row, int column)
	{  
        return false;  
    }
}

