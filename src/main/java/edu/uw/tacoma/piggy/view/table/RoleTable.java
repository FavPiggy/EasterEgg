package edu.uw.tacoma.piggy.view.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uw.tacoma.piggy.model.dao.RoleDAO;
import edu.uw.tacoma.piggy.model.entity.RoleEntity;

@SuppressWarnings("serial")
public class RoleTable
extends JTable
{
	private List<RoleEntity> entities;
	
	private DefaultTableModel model;
	private Object[] data;
	
	public RoleTable()
	{
		data = new Object[] { "RoleID", "RoleName", "Description", "DateCreated" };
		model = new DefaultTableModel(data, 0);
		
		setModel(model);
	}
	
	public void insert(RoleEntity entity)
	{
		RoleDAO.insert(entity);
		clearData();
		loadData();
	}
	
	public void update(RoleEntity entity)
	{
		RoleDAO.update(entity);
		clearData();
		loadData();
	}
	
	public void delete(RoleEntity entity)
	{
		RoleDAO.delete(entity);
		clearData();
		loadData();
	}
	
	public RoleEntity getData(int row)
	{
		return entities.get(row);
	}
	
	public void loadData()
	{
		entities = RoleDAO.listRole();
		for (RoleEntity entity : entities)
			addRow(entity);
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(RoleEntity entity)
	{
		data[0] = entity.getRoleID();
		data[1] = entity.getRoleName();
		data[2] = entity.getDescription();
		data[3] = entity.getDateCreated();
		model.addRow(data);
	}
	
	@Override
	public boolean isCellEditable(int row, int column)
	{  
        return false;  
    }
}


