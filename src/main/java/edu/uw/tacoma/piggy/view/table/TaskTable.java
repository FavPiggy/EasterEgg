package edu.uw.tacoma.piggy.view.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uw.tacoma.piggy.model.dao.TaskDAO;
import edu.uw.tacoma.piggy.model.entity.TaskEntity;

@SuppressWarnings("serial")
public class TaskTable
extends JTable
{
	private List<TaskEntity> entities;
	
	private DefaultTableModel model;
	private Object[] data;
	
	public TaskTable()
	{
		data = new Object[] { "TaskID", "ProjectID", "StartDate", "Duration", "Description", "UserID", "ParentTask", "DateCreated" };
		model = new DefaultTableModel(data, 0);
		
		setModel(model);
	}
	
	public void insert(TaskEntity entity)
	{
		TaskDAO.insert(entity);
		clearData();
		loadData();
	}
	
	public void update(TaskEntity entity)
	{
		TaskDAO.update(entity);
		clearData();
		loadData();
	}
	
	public void delete(TaskEntity entity)
	{
		TaskDAO.delete(entity);
		clearData();
		loadData();
	}
	
	public TaskEntity getData(int row)
	{
		return entities.get(row);
	}
	
	public void loadData()
	{
		entities = TaskDAO.listTask();
		for (TaskEntity entity : entities)
			addRow(entity);
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(TaskEntity entity)
	{
		data[0] = entity.getTaskID();
		data[1] = entity.getProjectID();
		data[2] = entity.getStartDate();
		data[3] = entity.getDuration();
		data[4] = entity.getDescription();
		data[5] = entity.getUserID();
		data[6] = entity.getParentTask();
		data[7] = entity.getDateCreated();
		model.addRow(data);
	}
	
	@Override
	public boolean isCellEditable(int row, int column)
	{  
        return false;  
    }
}


