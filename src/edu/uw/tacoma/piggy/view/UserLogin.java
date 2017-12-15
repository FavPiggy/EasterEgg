package edu.uw.tacoma.piggy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(74, 71, 73, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 104, 73, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(147, 66, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblinsertPiggyImage = new JLabel("*Insert Piggy Image Here*");
		lblinsertPiggyImage.setBounds(105, 30, 175, 16);
		contentPane.add(lblinsertPiggyImage);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(210, 147, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setBounds(210, 175, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password?");
		lblForgotPassword.setBounds(25, 188, 122, 16);
		contentPane.add(lblForgotPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 99, 130, 26);
		contentPane.add(passwordField);
	}
}
