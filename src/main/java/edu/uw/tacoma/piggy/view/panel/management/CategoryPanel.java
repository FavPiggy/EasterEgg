package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

	/**
	 * Create the panel.
	 */
	public CategoryPanel() {
		setLayout(null);
		
		//this.setBounds(93, 203, 211, 48);
		
		
		JLabel lblCategoryId = new JLabel("Category ID");
		lblCategoryId.setBounds(80, 183, 81, 16);
		add(lblCategoryId);
		
		JLabel lblCatName = new JLabel("Cat Name");
		lblCatName.setBounds(184, 183, 61, 16);
		add(lblCatName);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblCategory.setBounds(130, 6, 119, 37);
		add(lblCategory);
		
		JLabel lblNewLabel = new JLabel("Category ID");
		lblNewLabel.setBounds(26, 57, 81, 29);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cat Name");
		lblNewLabel_1.setBounds(36, 98, 61, 16);
		add(lblNewLabel_1);
		
		
		cIdField = new JTextField();
		cIdField.setBounds(119, 55, 130, 26);
		add(cIdField);
		cIdField.setColumns(10);
		
		cNameField = new JTextField();
		cNameField.setBounds(119, 93, 130, 26);
		add(cNameField);
		cNameField.setColumns(10);
		Object[][] data = {
			    {new Integer(0), "Internal"},
			    {new Integer(1), "External"},
			    {new Integer(2), "Out-sourced"}};
		//System.out.println(data[0][1]);
		

		Object [] rows = {"ID", "Name"};
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(70, 131, 117, 29);
		addBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//System.out.println(cIdField.getText());
				//CategoryEntity(Integer _CatID,String _CatName,String _Description,Date _DateCreated)
				try {
					System.out.println(cIdField.getText());
					CategoryEntity category = new CategoryEntity();
					category.setCatID(Integer.parseInt(cIdField.getText()));
					category.setCatName(cNameField.getText());
					//category.setDateCreated((java.sql.Date) new SimpleDateFormat("dd/MM/yyyy").parse(dateCreatedField.getText()));
					//category.setDescription(descriptionField.getText());
					for(int i = 0; i < data.length; i++) {
						//System.out.println("YEAAAAAH");
						if((int)data[i][0] == Integer.parseInt(cIdField.getText()) && data[i][1].equals(cNameField.getText())) {
							System.out.println("YEAAAAAH");
							
							
						}
					}
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		
		//JPanel categoryPanel = new JPanel();
		//categoryPanel.setLayout(null);
		JTable table = new JTable(data, rows);
		table.setBounds(80, 204, 210, 48);
		//System.out.println(table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
		
		this.add(table);
		add(addBtn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(201, 131, 117, 29);
		add(btnCancel);

		
		

	}
}
