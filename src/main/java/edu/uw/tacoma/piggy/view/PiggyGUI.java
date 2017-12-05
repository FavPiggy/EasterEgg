package edu.uw.tacoma.piggy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import edu.uw.tacoma.piggy.model.entity.ProjectEntity;
import edu.uw.tacoma.piggy.view.panel.GanttChartPanel;
import edu.uw.tacoma.piggy.view.panel.ManagementPanel;

/**
 * The GUI class for the application
 * @author Varik Hoang
 */
@SuppressWarnings("serial")
public class PiggyGUI
extends JFrame
{
	PiggyMenu piggyMenu;
	JTabbedPane tabbedPane;
	ManagementPanel managementPanel;
	GanttChartPanel ganttchartPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					PiggyGUI window = new PiggyGUI();
					window.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PiggyGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		piggyMenu = new PiggyMenu();
		setJMenuBar(piggyMenu);
		
		managementPanel = new ManagementPanel();
//		ganttchartPanel = new GanttChartPanel(this, null);
		
		ProjectEntity project = new ProjectEntity();
		project.setProjectID(1);
		project.setProjectName("Where is the project name coming from?");
		ganttchartPanel = new GanttChartPanel(this, project);
		
		tabbedPane = createTabbedPane();
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		pack();
	}
	
	/**
	 * @author Varik Hoang
	 * @return the tabbed pane
	 */
	private JTabbedPane createTabbedPane()
	{
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Management", null, managementPanel);
		tabbedPane.addTab("Project", null, ganttchartPanel); 
		return tabbedPane;
	}

}
