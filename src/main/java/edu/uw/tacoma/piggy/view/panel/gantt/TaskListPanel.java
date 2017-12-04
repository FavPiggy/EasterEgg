package edu.uw.tacoma.piggy.view.panel.gantt;

import javax.swing.JPanel;

import edu.uw.tacoma.piggy.model.entity.TaskEntity;

import edu.uw.tacoma.piggy.view.panel.GanttChartPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TaskListPanel
extends JPanel
{
	/**
	 * The Gantt Chart Panel
	 */
	@SuppressWarnings("unused")
	private GanttChartPanel myGanttPanel;
	/**
	 * The task list data.
	 */
	private TaskListData myData;
	/**
	 * 
	 */
	private DefaultTableModel model;
	/**
	 * 
	 */
	private Object[] data;
	/**
	 * 
	 */
	private JTable myTable;
	/**
	 * The constructor for the task list panel
	 * @param theGUI the main Piggy GUI
	 */
	public TaskListPanel(GanttChartPanel theGcp, TaskListData TheData)
	{
		myData = TheData;
		myGanttPanel = theGcp;
		myTable = new JTable();
		data = new Object[] { "Task ID", "Project ID", "Start Date", "Duration", "Description", "User ID", "Parent Task", "Date Created" };
		model = new DefaultTableModel(data, 0);
		setupPanel();
		myTable.setModel(model);
	}
	
	
	public void setupPanel() 
	{
		//String listData = getTaskData(myData);
		add(myTable);
	}
	
	public void insert(TaskEntity entity)
	{
		myData.add(entity);
		clearData();
//		loadData();
	}
	
//	public void update(TaskEntity entity)
//	{
//		myData.update(entity);
//		clearData();
//		loadData();
//	}
//	
	public void delete(TaskEntity entity)
	{
		myData.delete(entity);
		clearData();
//		loadData();
	}

	
	public void loadData()
	{
		//access.setActivity(AccountConst.SELECT_ALL);
		//entities = access.executeQuery(new AccountEntity());
//		for(int i =0; i < myData.sizeOfList(); i++) {
//			addRow(myData.getEntity(i));
//		}
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(TaskEntity entity)
	{
		data[3-3] = entity.getTaskID();
		data[4-3] = entity.getProjectID();
		data[5-3] = entity.getStartDate();
		data[6-3] = entity.getDuration();
		data[7-3] = "***";
		data[8-3] = entity.getDescription();
		data[9-3] = entity.getUserID();
		data[10-3] = entity.getParentTask();
		data[11-3] = entity.getDateCreated();
		model.addRow(data);
	}
	
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -384960769882911497L;


	
}
