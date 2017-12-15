package edu.uw.tacoma.piggy.view.panel.gantt;

import java.util.ArrayList;
import java.util.List;

import edu.uw.tacoma.piggy.model.dao.TaskDAO;
import edu.uw.tacoma.piggy.model.entity.ProjectEntity;
import edu.uw.tacoma.piggy.model.entity.TaskEntity;

/**
 * .... Java doc please
 * @author Cuong Tran, Varik Hoang
 */
public class TaskListData
{	
	ProjectEntity project;
	private List<TaskEntity> tasks;
	
//	public TaskListData(ProjectEntity theProject)
//	{
//		project = theProject;
//		tasks = new ArrayList<TaskEntity>();
//	}
	
	public TaskListData()
	{
		tasks = new ArrayList<TaskEntity>();
	}
	/**
	 * Add new task into the list.
	 * @author Varik Hoang
	 * @param theTask the task to add
	 */
	public void add(final TaskEntity task)
	{
		if (tasks.add(task))
		{
			TaskDAO.insert(task); //Cuong test insert to Data base
		}
	}
	
	/**
	 * update the task in the list
	 * @author Varik Hoang
	 * @param task the task to update
	 */
	public void update(final TaskEntity task)
	{
		for (int index = 0; index < tasks.size() - 1; index++)
		{
			TaskEntity current = tasks.get(index);
			if (current.getTaskID() == task.getTaskID())
			{
				current.setDescription(task.getDescription());
				current.setStartDate(task.getStartDate());
				current.setDuration(task.getDuration());
				current.setParentTask(task.getParentTask());
			}
		}
		TaskDAO.update(task);
	}
	
	/**
	 * delete the task in the list
	 * @author Cuong Tran
	 * @param task the task needs to be deleted
	 */
	public void delete(final TaskEntity task)
	{
		if (tasks.remove(task))
		{
			TaskDAO.delete(task);
		}
	}
	
	/**
	 * The method return the task
	 * @param index the index of the task
	 * @return the task at the given index
	 */
	public TaskEntity get(int index)
	{
		if (index < tasks.size() - 1)
			return tasks.get(index);
		return null;
	}
	
	public void clear()
	{
		tasks.clear();
	}
	
	/**
	 * The method returns the list of tasks
	 * @return
	 */
	public List<TaskEntity> get()
	{
		return tasks;
	}
	
	/**
	 * This returns the size of the list task.
	 * @author Cuong_Tran
	 * @return integer value of size.
	 */
	public int size() 
	{
		return tasks.size();
	}
	/**
	 * @author Cuong_Tran
	 * @return return true if the list of task is empty.
	 */
	public boolean isEmpty() 
	{	
		return tasks.isEmpty();
	}
	

	
//	// JUST FOR DEBUG
//	public String toString()
//	{
//		StringBuilder builder = new StringBuilder();
//		builder.append("List: \n");
//		for (TaskEntity task: tasks)
//			builder.append(task).append("\n");
//		
//		return builder.toString();
//	}

}
