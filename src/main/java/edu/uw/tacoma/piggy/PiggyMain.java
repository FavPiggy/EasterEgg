package edu.uw.tacoma.piggy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

import edu.uw.tacoma.piggy.view.PiggyGUI;

public class PiggyMain 
{
	/**
	 * The date formatter
	 */
	public static final DateFormat DateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] happiness)
	{
		for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
		{
			if ("Motif".equals(info.getName())) {
				try
				{
					UIManager.setLookAndFeel(info.getClassName());
				}
				catch (final ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (final InstantiationException e)
				{
					e.printStackTrace();
				}
				catch (final IllegalAccessException e)
				{
					e.printStackTrace();
				}
				catch (final UnsupportedLookAndFeelException e)
				{
					e.printStackTrace();
				}
				
				break;
			}
		}

		PiggyGUI gui = new PiggyGUI();
		gui.start();
	}
}
