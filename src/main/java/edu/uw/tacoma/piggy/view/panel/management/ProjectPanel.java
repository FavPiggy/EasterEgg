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

import edu.uw.tacoma.piggy.model.entity.ProjectEntity;

import javax.swing.JButton;

public class ProjectPanel extends JPanel {
	private JTextField pIdField;
	private JTextField pNameField;
	private JTextField AbbrField;
	private JTextField descriptionField;
	private JTextField sDateField;
	private JTextField cIdField;
	private JTextField uCreatedField;

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
		
		pIdField = new JTextField();
		pIdField.setBounds(162, 102, 130, 26);
		add(pIdField);
		pIdField.setColumns(10);
		
		pNameField = new JTextField();
		pNameField.setBounds(162, 130, 130, 26);
		add(pNameField);
		pNameField.setColumns(10);
		
		AbbrField = new JTextField();
		AbbrField.setBounds(162, 161, 130, 26);
		add(AbbrField);
		AbbrField.setColumns(10);
		
		descriptionField = new JTextField();
		descriptionField.setBounds(162, 194, 130, 26);
		add(descriptionField);
		descriptionField.setColumns(10);
		
		sDateField = new JTextField();
		sDateField.setBounds(162, 220, 130, 26);
		add(sDateField);
		sDateField.setColumns(10);
		
		cIdField = new JTextField();
		cIdField.setBounds(162, 250, 130, 26);
		add(cIdField);
		cIdField.setColumns(10);
		
		uCreatedField = new JTextField();
		uCreatedField.setBounds(162, 280, 130, 26);
		add(uCreatedField);
		uCreatedField.setColumns(10);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(58, 375, 117, 29);
		saveBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//ProjectEntity(Integer _ProjectID,String _ProjectName,String _ProjectAbbr,String _Description,Date _StartDate,Integer _CategoryID,Date _DateCreated)
				try {
					ProjectEntity project = new ProjectEntity(Integer.parseInt(pIdField.getText()), pNameField.getText(),
							AbbrField.getText(), descriptionField.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(sDateField.getText()),
							Integer.parseInt(cIdField.getText()), new SimpleDateFormat("dd/MM/yyyy").parse(uCreatedField.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		add(saveBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(215, 375, 117, 29);
		add(cancelBtn);

	}
}
