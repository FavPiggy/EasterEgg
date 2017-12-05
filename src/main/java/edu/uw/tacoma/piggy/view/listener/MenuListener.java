package edu.uw.tacoma.piggy.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uw.tacoma.piggy.view.PiggyViewConst;

/**
 * The class for menu listener
 * @author Varik Hoang
 */
public class MenuListener
implements ActionListener
{
	/**
	 * The constructor
	 * @param menu the menu
	 */
	public MenuListener()
	{
		
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
		}
	}

}
