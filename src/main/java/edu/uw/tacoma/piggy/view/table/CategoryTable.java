package edu.uw.tacoma.piggy.view.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uw.tacoma.piggy.model.dao.CategoryDAO;
import edu.uw.tacoma.piggy.model.entity.CategoryEntity;

@SuppressWarnings("serial")
public class CategoryTable
extends JTable
{
	private List<CategoryEntity> entities;
	
	private DefaultTableModel model;
	private Object[] data;
	
	public CategoryTable()
	{
		data = new Object[] { "CatID", "CatName", "Description", "DateCreated" };
		model = new DefaultTableModel(data, 0);
		
		setModel(model);
	}
	
	public void insert(CategoryEntity entity)
	{
		CategoryDAO.insert(entity);
		clearData();
		loadData();
	}
	
	public void update(CategoryEntity entity)
	{
		CategoryDAO.update(entity);
		clearData();
		loadData();
	}
	
	public void delete(CategoryEntity entity)
	{
		CategoryDAO.delete(entity);
		clearData();
		loadData();
	}
	
	public CategoryEntity getData(int row)
	{
		return entities.get(row);
	}
	
	public void loadData()
	{
		entities = CategoryDAO.listCategory();
		for (CategoryEntity entity : entities)
			addRow(entity);
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(CategoryEntity entity)
	{
		data[0] = entity.getCatID();
		data[1] = entity.getCatName();
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


