package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

import edu.uw.tacoma.piggy.model.entity.CategoryEntity;

import javax.swing.JButton;

public class CategoryPanel extends JPanel {
	private JTextField cIdField;
	private JTextField cNameField;
	private JTextField descriptionField;
	private JTextField dateCreatedField;

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
		
		cIdField = new JTextField();
		cIdField.setBounds(131, 81, 130, 26);
		add(cIdField);
		cIdField.setColumns(10);
		
		cNameField = new JTextField();
		cNameField.setBounds(131, 121, 130, 26);
		add(cNameField);
		cNameField.setColumns(10);
		
		descriptionField = new JTextField();
		descriptionField.setBounds(131, 161, 130, 26);
		add(descriptionField);
		descriptionField.setColumns(10);
		
		dateCreatedField = new JTextField();
		dateCreatedField.setBounds(141, 201, 130, 26);
		add(dateCreatedField);
		dateCreatedField.setColumns(10);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(54, 254, 117, 29);
		saveBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//CategoryEntity(Integer _CatID,String _CatName,String _Description,Date _DateCreated)
				try {
					CategoryEntity category = new CategoryEntity(Integer.parseInt(cIdField.getText()), cNameField.getText(),
							descriptionField.getText(),new SimpleDateFormat("dd/MM/yyyy").parse(dateCreatedField.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		add(saveBtn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(258, 254, 117, 29);
		add(btnCancel);

	}

}
