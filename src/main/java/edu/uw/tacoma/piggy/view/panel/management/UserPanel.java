package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;


import javax.swing.JButton;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private JTextField IDField;
	private JTextField fNameField;
	private JTextField lNameField;
	private JTextField numField;

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
		
		IDField = new JTextField();
		IDField.setBounds(89, 80, 130, 26);
		add(IDField);
		IDField.setColumns(10);
		
		fNameField = new JTextField();
		fNameField.setBounds(112, 116, 130, 26);
		add(fNameField);
		fNameField.setColumns(10);
		
		lNameField = new JTextField();
		lNameField.setBounds(112, 159, 130, 26);
		add(lNameField);
		lNameField.setColumns(10);
		
		numField = new JTextField();
		numField.setBounds(135, 198, 130, 26);
		add(numField);
		numField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(89, 247, 117, 29);
//		btnSave.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				UserEntity user = new UserEntity(Integer.parseInt(IDField.getText()), fNameField.getText(),
//						lNameField.getText(), numField.getText());
//			}});
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(256, 247, 117, 29);
		add(btnCancel);

	}
}
