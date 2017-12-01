package edu.uw.tacoma.piggy.view.panel.gantt;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import edu.uw.tacoma.piggy.view.panel.GanttChartPanel;

/**
 * The class draws the grantt objects
 * @author Varik Hoang
 */
public class GraphicPanel
extends JPanel
implements Observer
{
	/**
	 * The main Gantt Chart panel.
	 */
	@SuppressWarnings("unused")
	private GanttChartPanel myGanttPanel;
	
	/**
	 * The task list data.
	 */
	@SuppressWarnings("unused")
	private TaskListData myData;
	
	/**
	 * The constructor for graphic panel
	 * @param theGUI the main GUI passed in
	 */
	public GraphicPanel(GanttChartPanel theGUI)
	{
		myGanttPanel = theGUI;
	}

	@Override
    public void paintComponent(Graphics g)
	{
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
        
        // fill up your code here
        g2.drawLine(1, 1, 5, 5);
    }
	
	/**
	 * The method receives the data from observable objects
	 */
	public void update(Observable o, Object data)
	{
		if (o instanceof TaskListData)
		{
			myData = (TaskListData) o;
			repaint();
		}
	}

	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = -2958717085891811031L;
}
