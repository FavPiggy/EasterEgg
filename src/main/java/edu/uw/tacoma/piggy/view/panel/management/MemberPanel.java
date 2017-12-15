package edu.uw.tacoma.piggy.view.panel.management;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import edu.uw.tacoma.piggy.model.entity.MemberEntity;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MemberPanel extends JPanel {
	private JTextField mIdField;
	private JTextField pIdField;
	private JTextField uIdField;
	private JTextField dateJoinedField;

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
		
		mIdField = new JTextField();
		mIdField.setBounds(111, 84, 130, 26);
		add(mIdField);
		mIdField.setColumns(10);
		
		pIdField = new JTextField();
		pIdField.setBounds(111, 114, 130, 26);
		add(pIdField);
		pIdField.setColumns(10);
		
		uIdField = new JTextField();
		uIdField.setBounds(111, 142, 130, 26);
		add(uIdField);
		uIdField.setColumns(10);
		
		dateJoinedField = new JTextField();
		dateJoinedField.setBounds(111, 172, 130, 26);
		add(dateJoinedField);
		dateJoinedField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(25, 252, 117, 29);
		btnSave.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// MemberEntity(Integer _MemberID,Integer _ProjectID,Integer _UserID,Date _DateJoined)
			

					MemberEntity member = new MemberEntity();
					member.setMemberID(Integer.parseInt(mIdField.getText()));
					member.setProjectID(Integer.parseInt(pIdField.getText()));
					member.setUserID(Integer.parseInt(uIdField.getText()));

				
			}});
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(181, 252, 117, 29);
		add(btnCancel);

	}

}
