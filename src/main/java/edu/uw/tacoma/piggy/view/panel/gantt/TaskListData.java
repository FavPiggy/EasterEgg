package edu.uw.tacoma.piggy.view.panel.gantt;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import edu.uw.tacoma.piggy.model.entity.TaskEntity;
/**
 * 
 * @author Cuong_Tran
 *
 */
public class TaskListData
extends Observable
{	
	private List<TaskEntity> listTask;
	
	public TaskListData()
	{
		listTask = new ArrayList<TaskEntity>();
	}
	
	/**
	 * Add new task into the list.
	 * @author Cuong_Tran
	 * @param theTask assign new task.
	 */
	public void add(TaskEntity theTask)
	{
		TaskEntity newTask = theTask;
		listTask.add(newTask);
	}
	
	/**
	 * 
	 * @param ent
	 */
	public void delete(TaskEntity ent) {
		listTask.remove(ent);
	}
	
	public TaskEntity getEntity() {
		
		return null;
	}
	
	/**
	 * This returns the size of the list task.
	 * @author Cuong_Tran
	 * @return integer value of size.
	 */
	public int sizeOfList() 
	{
		return listTask.size();
	}
	/**
	 * @author Cuong_Tran
	 * @return return true if the list of task is empty.
	 */
	public boolean isEmpty() 
	{	
		return listTask.isEmpty();
	}
}
