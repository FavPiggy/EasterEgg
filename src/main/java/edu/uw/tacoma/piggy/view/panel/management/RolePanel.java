package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

import edu.uw.tacoma.piggy.model.entity.RoleEntity;

import javax.management.relation.Role;
import javax.swing.JButton;

public class RolePanel extends JPanel {
	private JTextField IDField;
	private JTextField roleNameField;
	private JTextField descriptionField;
	private JTextField dateField;
	ArrayList<RoleEntity> roles = new ArrayList<RoleEntity>();

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
		
		IDField = new JTextField();
		IDField.setBounds(97, 98, 130, 26);
		add(IDField);
		IDField.setColumns(10);
		
		roleNameField = new JTextField();
		roleNameField.setBounds(107, 135, 130, 26);
		add(roleNameField);
		roleNameField.setColumns(10);
		
		descriptionField = new JTextField();
		descriptionField.setBounds(117, 168, 130, 26);
		add(descriptionField);
		descriptionField.setColumns(10);
		
		dateField = new JTextField();
		dateField.setBounds(129, 208, 130, 26);
		add(dateField);
		dateField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(110, 253, 117, 29);
//		btnSave.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//			
//				try {
//					RoleEntity role = new RoleEntity(Integer.parseInt(IDField.getText()), roleNameField.getText(), descriptionField.getText(),
//							new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText()));
//				} catch (NumberFormatException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
//				
//			}});
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(260, 253, 117, 29);
		add(btnCancel);

	}
}
