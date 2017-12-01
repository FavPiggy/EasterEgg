package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MemberPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public MemberPanel() {
		setLayout(null);
		
		JLabel lblMember = new JLabel("Member");
		lblMember.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblMember.setBounds(129, 26, 112, 39);
		add(lblMember);
		
		JLabel lblNewLabel = new JLabel("Member ID");
		lblNewLabel.setBounds(25, 89, 74, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Project ID");
		lblNewLabel_1.setBounds(25, 119, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setBounds(25, 147, 61, 16);
		add(lblNewLabel_2);
		
		JLabel lblDateJoined = new JLabel("Date Joined");
		lblDateJoined.setBounds(25, 177, 74, 16);
		add(lblDateJoined);
		
		textField = new JTextField();
		textField.setBounds(111, 84, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 114, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 142, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 172, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(25, 252, 117, 29);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(181, 252, 117, 29);
		add(btnCancel);

	}

}
