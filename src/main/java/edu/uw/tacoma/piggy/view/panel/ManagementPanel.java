package edu.uw.tacoma.piggy.view.panel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.uw.tacoma.piggy.view.panel.management.CategoryPanel;
import edu.uw.tacoma.piggy.view.panel.management.MemberPanel;
import edu.uw.tacoma.piggy.view.panel.management.ProjectPanel;
import edu.uw.tacoma.piggy.view.panel.management.RolePanel;
import edu.uw.tacoma.piggy.view.panel.management.ToolPanel;
import edu.uw.tacoma.piggy.view.panel.management.UserPanel;

public class ManagementPanel extends JPanel {

	public static String myPanel;
	JPanel toolPanel = new JPanel();
	/**
	 * Create the Panel.
	 */
	public ManagementPanel() {
		setLayout(null);
		toolPanel.setLayout(null);
		//final ManagementPanel mp = new ManagementPanel();
		
		
		JButton btnNewButton = new JButton("Category");
		btnNewButton.setBounds(0, 6, 98, 29);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				removeAll();
				toolPanel.setBounds(6, 6, 97, 237);
				add(toolPanel);
				CategoryPanel categoryPanel = new CategoryPanel();
				categoryPanel.setBounds(115, 6, 418, 288);
				add(categoryPanel);
				revalidate();
				repaint();
			}});
		toolPanel.add(btnNewButton);
		
		JButton btnMember = new JButton("Member");
		btnMember.setBounds(0, 47, 98, 29);
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				toolPanel.setBounds(6, 6, 97, 237);
				add(toolPanel);
				MemberPanel memberPanel = new MemberPanel();
				memberPanel.setBounds(115, 6, 418, 445);
				add(memberPanel);
				revalidate();
				repaint();
			}
		});
		toolPanel.add(btnMember);
		
		JButton btnProject = new JButton("Project");
		btnProject.setBounds(0, 85, 98, 29);
		btnProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				toolPanel.setBounds(6, 6, 97, 237);
				add(toolPanel);
				ProjectPanel projectPanel = new ProjectPanel();
				projectPanel.setBounds(115, 6, 418, 445);
				add(projectPanel);
				revalidate();
				repaint();
				
			}
		});
		toolPanel.add(btnProject);
		
		JButton btnRole = new JButton("Role");
		btnRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				toolPanel.setBounds(6, 6, 97, 237);
				add(toolPanel);
				RolePanel rolePanel = new RolePanel();
				rolePanel.setBounds(115, 6, 418, 445);
				add(rolePanel);
				revalidate();
				repaint();
				

			}
		});
		btnRole.setBounds(0, 126, 98, 29);
		toolPanel.add(btnRole);
		
		JButton btnTool = new JButton("Tool");
		btnTool.setBounds(0, 166, 98, 29);
		btnTool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				toolPanel.setBounds(6, 6, 97, 237);
				add(toolPanel);
				
				
				validate();
				repaint();
			}
		});
		toolPanel.add(btnTool);
		
		JButton btnUser = new JButton("User");
		btnUser.setBounds(0, 208, 98, 29);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				toolPanel.setBounds(6, 6, 97, 237);
				add(toolPanel);
				UserPanel userPanel = new UserPanel();
				userPanel.setBounds(115, 6, 418, 445);
				add(userPanel);
				validate();
				repaint();
				
			}
		});
		toolPanel.add(btnUser);

		toolPanel.setBounds(6, 6, 97, 237);
		add(toolPanel);

		
		
		
		

		

	}
	public static void setPanel(String currPanel) {
		
		myPanel = currPanel;
	}
}
