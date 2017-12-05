package edu.uw.tacoma.piggy.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uw.tacoma.piggy.view.PiggyViewConst;

/**
 * The class for button listener
 * @author Varik Hoang
 */
public class ButtonListener
implements ActionListener
{
	/**
	 * The constructor
	 * @param menu the menu
	 */
	public ButtonListener()
	{
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		/**
		 * Action for ManagementPanel class
		 */
		// ToolPanel
		if (e.getActionCommand().equals(PiggyViewConst.TOOL_PANEL_BUTTON_CATEGORY))
		{
			
		}
		else if (e.getActionCommand().equals(PiggyViewConst.TOOL_PANEL_BUTTON_MEMBER))
		{
			
		}
		else if (e.getActionCommand().equals(PiggyViewConst.TOOL_PANEL_BUTTON_PROJECT))
		{
			
		}
		else if (e.getActionCommand().equals(PiggyViewConst.TOOL_PANEL_BUTTON_ROLE))
		{
			
		}
		else if (e.getActionCommand().equals(PiggyViewConst.TOOL_PANEL_BUTTON_USER))
		{
			
		}
		
		/**
		 * Action for GanttChartPanel class
		 */
		else if (e.getActionCommand().equals(PiggyViewConst.TOOL_PANEL_BUTTON_USER))
		{
			
		}
	}
}
