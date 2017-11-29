package edu.uw.tacoma.piggy.view.panel.gantt;

import javax.swing.JPanel;

import edu.uw.tacoma.piggy.view.PiggyGUI;

public class TaskListPanel
extends JPanel
{
	/**
	 * The main Piggy GUI.
	 */
	private PiggyGUI myGUI;
	
	/**
	 * The task list data.
	 */
	private TaskListData myData;
	
	/**
	 * The constructor for the task list panel
	 * @param theGUI the main Piggy GUI
	 */
	public TaskListPanel(PiggyGUI theGUI)
	{
		myGUI = theGUI;
	}
	
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -384960769882911497L;
	
}
