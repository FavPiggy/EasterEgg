package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;

import edu.uw.tacoma.piggy.view.panel.ManagementPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ToolPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ToolPanel() {
		setLayout(null);
		//final ManagementPanel mp = new ManagementPanel();
		
		
		JButton btnNewButton = new JButton("Category");
		btnNewButton.setBounds(0, 6, 98, 29);
		add(btnNewButton);
		
		JButton btnMember = new JButton("Member");
		btnMember.setBounds(0, 47, 98, 29);
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementPanel.setPanel("Member");
			}
		});
		add(btnMember);
		
		JButton btnProject = new JButton("Project");
		btnProject.setBounds(0, 85, 98, 29);
		btnProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementPanel.setPanel("Project");
				//mp.revalidate();
				//mp.repaint();
			}
		});
		add(btnProject);
		
		JButton btnRole = new JButton("Role");
		btnRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementPanel.setPanel("Role");
			}
		});
		btnRole.setBounds(0, 126, 98, 29);
		add(btnRole);
		
		JButton btnTool = new JButton("Tool");
		btnTool.setBounds(0, 166, 98, 29);
		btnTool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementPanel.setPanel("Tool");
			}
		});
		add(btnTool);
		
		JButton btnUser = new JButton("User");
		btnUser.setBounds(0, 208, 98, 29);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementPanel.setPanel("User");
			}
		});
		add(btnUser);

	}

}
