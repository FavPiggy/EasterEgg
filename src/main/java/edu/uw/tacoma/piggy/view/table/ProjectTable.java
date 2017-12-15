package edu.uw.tacoma.piggy.view.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uw.tacoma.piggy.model.dao.ProjectDAO;
import edu.uw.tacoma.piggy.model.entity.ProjectEntity;

@SuppressWarnings("serial")
public class ProjectTable
extends JTable
{
	private List<ProjectEntity> entities;
	
	private DefaultTableModel model;
	private Object[] data;
	
	public ProjectTable()
	{
		data = new Object[] { "ProjectID", "ProjectName", "ProjectAbbr", "Description", "StartDate", "CategoryID", "DateCreated" };
		model = new DefaultTableModel(data, 0);
		
		setModel(model);
	}
	
	public void insert(ProjectEntity entity)
	{
		ProjectDAO.insert(entity);
		clearData();
		loadData();
	}
	
	public void update(ProjectEntity entity)
	{
		ProjectDAO.update(entity);
		clearData();
		loadData();
	}
	
	public void delete(ProjectEntity entity)
	{
		ProjectDAO.delete(entity);
		clearData();
		loadData();
	}
	
	public ProjectEntity getData(int row)
	{
		return entities.get(row);
	}
	
	public void loadData()
	{
		entities = ProjectDAO.listProject();
		for (ProjectEntity entity : entities)
			addRow(entity);
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(ProjectEntity entity)
	{
		data[0] = entity.getProjectID();
		data[1] = entity.getProjectName();
		data[2] = entity.getProjectAbbr();
		data[3] = entity.getDescription();
		data[4] = entity.getStartDate();
		data[5] = entity.getCategoryID();
		data[6] = entity.getDateCreated();
		model.addRow(data);
	}
	
	@Override
	public boolean isCellEditable(int row, int column)
	{  
        return false;  
    }
}


