package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public UserPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setBounds(180, 21, 113, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserID");
		lblNewLabel_1.setBounds(31, 85, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(31, 121, 81, 16);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(31, 164, 72, 16);
		add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(31, 203, 100, 16);
		add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setBounds(89, 80, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 116, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 159, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 198, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(89, 247, 117, 29);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(256, 247, 117, 29);
		add(btnCancel);

	}
}
