package edu.uw.tacoma.piggy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import edu.uw.tacoma.piggy.view.panel.ManagementPanel;

/**
 * The following class represents a GUI for the Easter Egg.
 * Random change 3
 * @author Arwain Karlin
 * @version 1.0
 */
public class PiggyGUI implements PropertyChangeListener {

    /**
     * A JFrame for the GUI.
     */
    private final JFrame myWindow;
    /**
     * Logo for Piggy.
     */
    private final ImageIcon myPiggyLogo = new ImageIcon("./src/piggy.jpg");

    /**
     * A default constructor for the GUI.
     */
    public PiggyGUI() {

        myWindow = new JFrame("Favorite Piggy");
        setup();
        myWindow.setIconImage(myPiggyLogo.getImage());
        
       
    }

    /**
     * This method makes the JFrame visible.
     */
    public void start() {
        myWindow.setLocationRelativeTo(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
        
    }

    /**
     * A setup for the JFrame.
     */
    private void setup() {
    	ManagementPanel mp = new ManagementPanel();
    	myWindow.add(mp,BorderLayout.CENTER);
    	myWindow.pack();
//        JPanel panel = new JPanel();
//        panel.getUI();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
//        
//        JLabel jlabel = new JLabel("We are Favorite Piggy!\n");
//        jlabel.setFont(new Font("Papyrus", 1, 22));
//        panel.add(jlabel);
//        
//        //
//        JLabel jlabel2 = new JLabel("Arwain Karlin - Coder for hire!\n");
//        jlabel2.setFont(new Font("Papyrus", 1, 16));
//        panel.add(jlabel2);
//        
//        //
//        JLabel jlabel3 = new JLabel("Kirtwinder Gulati - 1/2 cup coder, 2 cups baker, 1 tsp vanilla and " +
//                "1/2 cup chocolate chips.\n Mix thoroughly to combine, bake at 360 for 21 minutes");
//        jlabel3.setFont(new Font("Papyrus", 1, 16));
//        panel.add(jlabel3);
//        
//        //Cuong's Message
//        JLabel cuongMess = new JLabel("Cuong Tran - Coffee for Life!\n");
//        cuongMess.setFont(new Font("Papyrus", 1, 16));
//        panel.add(cuongMess);
//        
//      //Varik Message
//        JLabel varikLabel = new JLabel("Varik Hoang - Zz.Zz.z.z...");
//        varikLabel.setFont(new Font("Papyrus", 1, 16));
//        panel.add(varikLabel);
//
//        // Kerry Message
//        JLabel jlabel8 = new JLabel("Kerry Ferguson - ....");
//        jlabel8.setFont(new Font("Papyrus", 1, 16));
//        panel.add(jlabel8);
//
//        // Mahad Message
//        JLabel jlabel9 = new JLabel("Mahad Kaboweyne -  *insert cool fact here*");
//        jlabel9.setFont(new Font("Courier", 1, 16));
//        panel.add(jlabel9);
//
//        panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
//        myWindow.add(panel);


    }

    /**
     * Below initializes an exit action when the quit button is pushed.
     */
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("Goodbye".equals(theEvent.getPropertyName())) {
            myWindow.dispatchEvent(new WindowEvent(myWindow, WindowEvent.WINDOW_CLOSING));
        }
    }
=======
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
