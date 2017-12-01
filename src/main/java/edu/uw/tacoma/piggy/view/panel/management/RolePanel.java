package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class RolePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public RolePanel() {
		setLayout(null);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblRole.setBounds(174, 24, 85, 43);
		add(lblRole);
		
		JLabel lblRoleId = new JLabel("Role ID");
		lblRoleId.setBounds(36, 103, 61, 16);
		add(lblRoleId);
		
		JLabel lblRoleName = new JLabel("Role Name");
		lblRoleName.setBounds(36, 140, 67, 16);
		add(lblRoleName);
		
		JLabel lblDescriptio = new JLabel("Description");
		lblDescriptio.setBounds(36, 173, 91, 16);
		add(lblDescriptio);
		
		JLabel lblDateCreated = new JLabel("Date Created");
		lblDateCreated.setBounds(36, 213, 91, 16);
		add(lblDateCreated);
		
		textField = new JTextField();
		textField.setBounds(97, 98, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 135, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 168, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(129, 208, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);

	}

}
