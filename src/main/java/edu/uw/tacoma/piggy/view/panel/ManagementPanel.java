package edu.uw.tacoma.piggy.view.panel;

import javax.swing.JPanel;

import edu.uw.tacoma.piggy.view.panel.management.CategoryPanel;
import edu.uw.tacoma.piggy.view.panel.management.ProjectPanel;
import edu.uw.tacoma.piggy.view.panel.management.ToolPanel;

public class ManagementPanel extends JPanel {

	/**
	 * Create the Panel.
	 */
	public ManagementPanel() {
		setLayout(null);
		
		ToolPanel toolPanel = new ToolPanel();
		toolPanel.setBounds(6, 6, 97, 237);
		add(toolPanel);
		
		CategoryPanel categoryPanel = new CategoryPanel();
		categoryPanel.setBounds(115, 6, 418, 288);
		//add(categoryPanel);
		
		ProjectPanel projectPanel = new ProjectPanel();
		projectPanel.setBounds(115, 6, 418, 445);
		add(projectPanel);

	}
}
