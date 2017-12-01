package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProjectPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public ProjectPanel() {
		setLayout(null);
		
		JLabel lblProject = new JLabel("Project");
		lblProject.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblProject.setBounds(137, 28, 117, 31);
		add(lblProject);
		
		JLabel lblProjectId = new JLabel("Project ID");
		lblProjectId.setBounds(28, 107, 61, 16);
		add(lblProjectId);
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setBounds(28, 135, 92, 16);
		add(lblProjectName);
		
		JLabel lblProjectAbbr = new JLabel("Project Abbr");
		lblProjectAbbr.setBounds(28, 166, 77, 16);
		add(lblProjectAbbr);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(28, 194, 77, 16);
		add(lblDescription);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(28, 225, 77, 16);
		add(lblStartDate);
		
		JLabel lblCatagoryId = new JLabel("Catagory ID");
		lblCatagoryId.setBounds(28, 255, 77, 16);
		add(lblCatagoryId);
		
		JLabel lblUserCreated = new JLabel("User Created");
		lblUserCreated.setBounds(28, 285, 92, 16);
		add(lblUserCreated);
		
		textField = new JTextField();
		textField.setBounds(162, 102, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 130, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(162, 161, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(162, 194, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(162, 220, 130, 26);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(162, 250, 130, 26);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(162, 280, 130, 26);
		add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(58, 375, 117, 29);
		add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(215, 375, 117, 29);
		add(btnCancel);

	}
}
