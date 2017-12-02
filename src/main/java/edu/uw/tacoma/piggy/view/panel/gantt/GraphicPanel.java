package edu.uw.tacoma.piggy.view.panel.gantt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.swiftgantt.GanttChart;
import org.swiftgantt.common.Time;
import org.swiftgantt.model.GanttModel;
import org.swiftgantt.model.Task;
import org.swiftgantt.ui.TimeUnit;

import edu.uw.tacoma.piggy.model.entity.ProjectEntity;
import edu.uw.tacoma.piggy.model.entity.TaskEntity;
import edu.uw.tacoma.piggy.view.panel.GanttChartPanel;

/**
 * The class draws the grantt objects
 * @author Varik Hoang
 */
@SuppressWarnings("serial")
public class GraphicPanel
extends JPanel
implements Observer
{
	/**
	 * The gantt model
	 */
	private GanttModel model;
	
	/**
	 * The gantt chart
	 */
	private GanttChart chart;
	
	/**
	 * The starting time
	 */
	private Time startTime;
	
	/**
	 * The ending time
	 */
	private Time endTime;
	
	/**
	 * The task root
	 */
	private Task taskRoot;
	
	/**
	 * The gantt chart panel
	 */
	private GanttChartPanel parent;
	
	private ProjectEntity myProject;
	
	/**
	 * The task map
	 */
	private Map<Integer, Task> taskmap;
	
	/**
	 * The constructor
	 * @param theGantt the parent panel
	 */
	public GraphicPanel(GanttChartPanel theGantt, ProjectEntity theProject)
	{
		myProject = theProject;
		taskmap = new HashMap<Integer, Task>();
		
		chart = new GanttChart();
		chart.setTimeUnit(TimeUnit.Day);
		
		model = new GanttModel();
		
		add(chart);
	}

	/**
	 * The method update the new task list data
	 * @author Varik Hoang
	 */
	@SuppressWarnings("unchecked")
	public void update(Observable o, Object arg)
	{
		if (o instanceof TaskListData)
			update((List<TaskEntity>) arg);
	}

	public void update(List<TaskEntity> tasklist)
	{
		model.removeAll();
		
		startTime = new Time();
		endTime = new Time();
		
		taskRoot = new Task(myProject.getProjectName(), startTime, endTime, null);
		
		for (TaskEntity entity: tasklist)
		{
			// convert the date from sql package to util package
			java.util.Date utilDate = new java.util.Date(entity.getStartDate().getTime());
			startTime.setDate(utilDate.getDate()); // TODO find a better way to cast dates
			endTime.add(Time.DATE, entity.getDuration());
			
			// put the task into the map
			Task task = new Task(entity.getDescription(), startTime, endTime);
			taskmap.put(entity.getTaskID(), task);
			
			// connect the child task to the parent task
			TaskEntity parent = find(tasklist, entity.getParentTask());
			if (parent != null && taskmap.get(parent.getTaskID()) != task)
				task.addPredecessor(taskmap.get(parent.getTaskID()));
			
			taskRoot.add(task);
		}
		
		// add tasks -> model -> chart
		model.addTask(taskRoot);
		chart.setModel(model);
	}
	
	public TaskEntity find(List<TaskEntity> tasklist, int taskID)
	{
		for (TaskEntity entity: tasklist)
			if (entity.getTaskID() == taskID)
				return entity;
		return null;
	}
	
}
