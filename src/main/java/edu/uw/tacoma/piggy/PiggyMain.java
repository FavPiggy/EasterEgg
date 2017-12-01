package edu.uw.tacoma.piggy;

import java.awt.EventQueue;
import edu.uw.tacoma.piggy.view.PiggyGUI;

public class PiggyMain
{
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
}
