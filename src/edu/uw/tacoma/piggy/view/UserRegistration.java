package edu.uw.tacoma.piggy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class UserRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnCancel;
	private JButton btnSignUp;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(6, 43, 82, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(79, 38, 120, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(6, 74, 70, 16);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 69, 120, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblConfirmPassowrd = new JLabel("Confirm Passowrd");
		lblConfirmPassowrd.setBounds(6, 102, 120, 16);
		contentPane.add(lblConfirmPassowrd);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 97, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(6, 130, 61, 16);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(79, 125, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(6, 158, 61, 16);
		contentPane.add(lblPhoto);
		
		textField_4 = new JTextField();
		textField_4.setBounds(79, 153, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(199, 153, 117, 29);
		contentPane.add(btnBrowse);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(79, 214, 117, 29);
		contentPane.add(btnCancel);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(199, 214, 117, 29);
		contentPane.add(btnSignUp);
		
		lblNewLabel_1 = new JLabel("User Registration");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(79, 6, 179, 26);
		contentPane.add(lblNewLabel_1);
	}
}
