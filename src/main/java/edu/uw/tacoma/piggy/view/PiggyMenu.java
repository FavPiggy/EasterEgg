package edu.uw.tacoma.piggy.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import edu.uw.tacoma.piggy.view.listener.MenuListener;

/**
 * The class for application menu
 * @author Varik Hoang
 */
@SuppressWarnings("serial")
public class PiggyMenu
extends JMenuBar
{
	MenuListener listener;
	
	/**
	 * The constructor for the menu
	 */
	public PiggyMenu()
	{
		listener = new MenuListener();
		
		createFileMenu();
		createHelpMenu();
	}
	
	/**
	 * The Piggy GUI
	 */
	private PiggyGUI myGUI;
	
	/**
	 * The method returns the GUI.
	 * @return the GUI
	 */
	protected PiggyGUI getGUI()
	{
		return myGUI;
	}
	
	/**
	 * The method sets the GUI
	 * @param theGUI the Piggy GUI
	 */
	public void setGUI(PiggyGUI theGUI)
	{
		myGUI = theGUI;
	}
	
	public void createFileMenu()
	{
		JMenu menuFile = new JMenu("File");
		add(menuFile);
		
		JMenuItem menuFileExit = new JMenuItem("Exit");
		menuFileExit.setActionCommand(PiggyViewConst.MENU_FILE_EXIT);
		menuFileExit.addActionListener(listener);
		menuFile.add(menuFileExit);
	}
	
	public void createHelpMenu()
	{
		JMenu menuHelp = new JMenu("Help");
		add(menuHelp);
		
		JMenuItem menuHelpAbout = new JMenuItem("About");
		menuHelpAbout.setActionCommand(PiggyViewConst.MENU_HELP_ABOUT);
		menuHelpAbout.addActionListener(listener);
		menuHelp.add(menuHelpAbout);
	}

}
