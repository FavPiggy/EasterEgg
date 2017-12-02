package edu.uw.tacoma.piggy.view.panel.gantt;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.swiftgantt.model.Task;
import org.swiftgantt.model.TaskTreeModel;
import org.swiftgantt.ui.TimeUnit;

import edu.uw.tacoma.piggy.view.PiggyGUI;

import edu.uw.tacoma.piggy.view.panel.GanttChartPanel;

/**
 * The class draws the grantt objects
 * @author Varik Hoang
 */
public class GraphicPanel
extends JPanel
//implements Observer
{

	private TaskListData myData;
	
	public GraphicPanel(GanttChartPanel theGantt) {
		
	}

	private static final long serialVersionUID = -2958717085891811031L;
}
