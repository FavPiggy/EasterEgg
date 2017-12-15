package edu.uw.tacoma.piggy.view.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uw.tacoma.piggy.model.dao.TaskMemberDAO;
import edu.uw.tacoma.piggy.model.entity.TaskMemberEntity;

@SuppressWarnings("serial")
public class TaskMemberTable
extends JTable
{
	private List<TaskMemberEntity> entities;
	
	private DefaultTableModel model;
	private Object[] data;
	
	public TaskMemberTable()
	{
		data = new Object[] { "TaskID", "MemberID" };
		model = new DefaultTableModel(data, 0);
		
		setModel(model);
	}
	
	public void insert(TaskMemberEntity entity)
	{
		TaskMemberDAO.insert(entity);
		clearData();
		loadData();
	}
	
	public void update(TaskMemberEntity entity)
	{
		TaskMemberDAO.update(entity);
		clearData();
		loadData();
	}
	
	public void delete(TaskMemberEntity entity)
	{
		TaskMemberDAO.delete(entity);
		clearData();
		loadData();
	}
	
	public TaskMemberEntity getData(int row)
	{
		return entities.get(row);
	}
	
	public void loadData()
	{
		entities = TaskMemberDAO.listTaskMember();
		for (TaskMemberEntity entity : entities)
			addRow(entity);
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(TaskMemberEntity entity)
	{
		data[0] = entity.getTaskID();
		data[1] = entity.getMemberID();
		model.addRow(data);
	}
	
	@Override
	public boolean isCellEditable(int row, int column)
	{  
        return false;  
    }
}


