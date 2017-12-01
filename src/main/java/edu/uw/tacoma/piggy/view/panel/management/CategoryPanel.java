package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CategoryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public CategoryPanel() {
		setLayout(null);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblCategory.setBounds(169, 20, 119, 37);
		add(lblCategory);
		
		JLabel lblNewLabel = new JLabel("Category ID");
		lblNewLabel.setBounds(47, 80, 81, 29);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cat Name");
		lblNewLabel_1.setBounds(47, 126, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(47, 166, 81, 16);
		add(lblNewLabel_2);
		
		JLabel lblDateCreated = new JLabel("Date Created");
		lblDateCreated.setBounds(47, 206, 81, 16);
		add(lblDateCreated);
		
		textField = new JTextField();
		textField.setBounds(131, 81, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 121, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 161, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 201, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(54, 254, 117, 29);
		add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(258, 254, 117, 29);
		add(btnCancel);

	}

}
