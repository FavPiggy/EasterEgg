package edu.uw.tacoma.piggy.view.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import org.swiftgantt.demo.tab.ScheduleTab;

import edu.uw.tacoma.piggy.model.dao.TaskDAO;
import edu.uw.tacoma.piggy.model.entity.ProjectEntity;
import edu.uw.tacoma.piggy.model.entity.TaskEntity;
import edu.uw.tacoma.piggy.view.PiggyGUI;
import edu.uw.tacoma.piggy.view.panel.gantt.GraphicPanel;
import edu.uw.tacoma.piggy.view.panel.gantt.TaskListData;
import edu.uw.tacoma.piggy.view.panel.gantt.TaskListPanel;

@SuppressWarnings("serial")
public class GanttChartPanel
extends JPanel
{
	
	/**
	 * The main Piggy GUI.
	 */
	private PiggyGUI myGUI;
	
	/**
	 * The current project
	 */
	private ProjectEntity myProject;
	
	/**
	 * 
	 */
	private TaskListPanel myTaskPanel;
	
	/**
	 * 
	 */
	private GraphicPanel myGraphicPanel;
	
	/**
	 * DO NOT REMOVE THIS FIELD
	 */
	private TaskListData data;
	
	/**
	 * 
	 * @param theGui
	 */	
	public GanttChartPanel(PiggyGUI theGui)
	{
		this(theGui, null);
	}
	
	/**
	 * @param theGui
	 */
	public GanttChartPanel(PiggyGUI theGui, ProjectEntity theProject)
	{
		myGUI = theGui;
		myProject = theProject;
		
		data = new TaskListData(theProject);
		myTaskPanel = new TaskListPanel(this, data);
		myGraphicPanel = new GraphicPanel(this, theProject);
		data.addObserver(myGraphicPanel);
		fetch(data, theProject);
		setSubPanel();
	}
	
	public void setSubPanel()
	{

		add(myGraphicPanel, BorderLayout.CENTER);
		
	}
	
	public void fetch(TaskListData data, ProjectEntity theProject)
	{
		if (theProject != null)
		{
			List<TaskEntity> tasks = TaskDAO.listTask("where ProjectID=" + theProject.getProjectID());
			for (TaskEntity task: tasks)
				data.add(task);
		}
	}
}
