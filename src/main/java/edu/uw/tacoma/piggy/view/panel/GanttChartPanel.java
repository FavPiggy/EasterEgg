package edu.uw.tacoma.piggy.view.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import edu.uw.tacoma.piggy.view.PiggyGUI;
import edu.uw.tacoma.piggy.view.panel.gantt.GraphicPanel;
import edu.uw.tacoma.piggy.view.panel.gantt.TaskListPanel;

public class GanttChartPanel extends JPanel {
	/**
	 * The main Piggy GUI.
	 */
	private PiggyGUI myGUI;
	/**
	 * 
	 */
	private TaskListPanel myTaskPanel;
	/**
	 * 
	 */
	private GraphicPanel myGraphicPanel;
	/**
	 * 
	 * @param theGui
	 */
	public GanttChartPanel(PiggyGUI theGui)
	{
		myGUI = theGui;
		myTaskPanel = new TaskListPanel(this);
		myGraphicPanel = new GraphicPanel(this);
		setSubPanel();
	}
	public void setSubPanel() {
		//add(myTaskPanel, BorderLayout.WEST);
		add(myGraphicPanel, BorderLayout.CENTER);
	}
}
