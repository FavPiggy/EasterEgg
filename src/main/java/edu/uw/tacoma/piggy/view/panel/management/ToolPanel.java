package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ToolPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ToolPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Category");
		btnNewButton.setBounds(0, 6, 98, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Member");
		btnNewButton_1.setBounds(0, 47, 98, 29);
		add(btnNewButton_1);
		
		JButton btnProject = new JButton("Project");
		btnProject.setBounds(0, 85, 98, 29);
		add(btnProject);
		
		JButton btnRole = new JButton("Role");
		btnRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRole.setBounds(0, 126, 98, 29);
		add(btnRole);
		
		JButton btnTool = new JButton("Tool");
		btnTool.setBounds(0, 166, 98, 29);
		add(btnTool);
		
		JButton btnUser = new JButton("User");
		btnUser.setBounds(0, 208, 98, 29);
		add(btnUser);

	}

}
