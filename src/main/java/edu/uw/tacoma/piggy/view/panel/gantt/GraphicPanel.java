package edu.uw.tacoma.piggy.view.panel.gantt;

import java.awt.BorderLayout;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.swiftgantt.GanttChart;
import org.swiftgantt.common.Time;
import org.swiftgantt.demo.tab.ScheduleTab;
import org.swiftgantt.demo.tab.TaskDialog;
import org.swiftgantt.model.GanttModel;
import org.swiftgantt.model.Task;
import org.swiftgantt.model.TaskTreeModel;
import org.swiftgantt.ui.TimeUnit;

import edu.uw.tacoma.piggy.model.dao.TaskDAO;
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
	private TaskDialog myDialog; 

	/**
	 * The task map
	 */
	private Map<Integer, Task> taskmap;
	
	/**
	 * 
	 */
	private ScheduleTab mySchedule;
	
	
	/**
	 * The constructor
	 * @param theGantt the parent panel
	 */
	public GraphicPanel(GanttChartPanel theGantt, ProjectEntity theProject)
	{
		myProject = theProject;
		taskmap = new HashMap<Integer, Task>();
		Date myStartDate = theProject.getStartDate();
		
		List<TaskEntity> tasks = TaskDAO.listTask("WHERE ProjectID = "+ theProject.getProjectID());
		for (TaskEntity task: tasks)
			System.out.println(task);
		
		
		chart = new GanttChart();
		chart.setTimeUnit(TimeUnit.Day);
		
		mySchedule = new ScheduleTab(this);
		model = new GanttModel();
		myDialog = new TaskDialog();

		setupGantt();
	}
	
	/**
	 * @author Cuong_Tran
	 * setup ganttChart.
	 */
	public void setupGantt() {
		chart.getConfig();
		
		
		TaskTreeModel taskTreeModel = new TaskTreeModel();
		mySchedule.setTaskTreeModel(taskTreeModel);

		
		setLayout(new BorderLayout());
		add(mySchedule, BorderLayout.NORTH);
		add(chart, BorderLayout.SOUTH);
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
			myDialog.setTask(task);
		}
		
		// add tasks -> model -> chart
		model.addTask(taskRoot);
		chart.setModel(model);
	}
	
	public GanttChart getGanttChart() {
		return chart;
	}
	
	public TaskEntity find(List<TaskEntity> tasklist, int taskID)
	{
		for (TaskEntity entity: tasklist)
			if (entity.getTaskID() == taskID)
				return entity;
		return null;
	}

}
