package edu.uw.tacoma.piggy.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.uw.tacoma.piggy.view.PiggyGUI;
import edu.uw.tacoma.piggy.view.PiggyViewConst;

/**
 * The class for menu listener
 * @author Varik Hoang
 */
public class MenuListener
implements ActionListener
{
	PiggyGUI myMain;
	
	/**
	 * The constructor
	 * @param menu the menu
	 */
	public MenuListener(PiggyGUI theMain)
	{
		myMain = theMain;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals(PiggyViewConst.MENU_FILE_EXIT))
		{
			// FIXME it should pop up a window to ask user if he/she really want to close
			System.exit(0);
		}
		else if (e.getActionCommand().equals(PiggyViewConst.MENU_HELP_ABOUT))
		{
			// display form
			JOptionPane.showMessageDialog(myMain, "Kerry Ferguson: kferg9@uw.edu\n" + 
					"Kirtwinder Gulati: gulati21@live.com\n" + 
					"Varik Hoang: varikmp@uw.edu\n" + 
					"Mahad Fahiye: mahadf@uw.edu\n" + 
					"Arwain Karlin: ak99@uw.edu\n" + 
					"Cuong Tran: cuongtr@uw.edu");
		}
	}

}
