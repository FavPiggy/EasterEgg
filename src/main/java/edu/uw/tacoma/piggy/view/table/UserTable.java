package edu.uw.tacoma.piggy.view.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uw.tacoma.piggy.model.dao.UserDAO;
import edu.uw.tacoma.piggy.model.entity.UserEntity;

@SuppressWarnings("serial")
public class UserTable
extends JTable
{
	private List<UserEntity> entities;
	
	private DefaultTableModel model;
	private Object[] data;
	
	public UserTable()
	{
		data = new Object[] { "UserID", "FirstName", "LastName", "PhoneNumber" };
		model = new DefaultTableModel(data, 0);
		
		setModel(model);
	}
	
	public void insert(UserEntity entity)
	{
		UserDAO.insert(entity);
		clearData();
		loadData();
	}
	
	public void update(UserEntity entity)
	{
		UserDAO.update(entity);
		clearData();
		loadData();
	}
	
	public void delete(UserEntity entity)
	{
		UserDAO.delete(entity);
		clearData();
		loadData();
	}
	
	public UserEntity getData(int row)
	{
		return entities.get(row);
	}
	
	public void loadData()
	{
		entities = UserDAO.listUser();
		for (UserEntity entity : entities)
			addRow(entity);
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(UserEntity entity)
	{
		data[0] = entity.getUserID();
		data[1] = entity.getFirstName();
		data[2] = entity.getLastName();
		data[3] = entity.getPhoneNumber();
		model.addRow(data);
	}
	
	@Override
	public boolean isCellEditable(int row, int column)
	{  
        return false;  
    }
}


