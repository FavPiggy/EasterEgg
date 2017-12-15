package edu.uw.tacoma.piggy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class UserDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboard frame = new UserDashboard();
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
	public UserDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 61, 365, 351);
		contentPane.add(panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 40, 96, 21);
		contentPane.add(tabbedPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		tabbedPane.addTab("Mail", null, lblNewLabel, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(126, 40, 89, 21);
		contentPane.add(tabbedPane_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		tabbedPane_3.addTab("Projects", null, lblNewLabel_1, null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_4.setBounds(207, 40, 96, 21);
		contentPane.add(tabbedPane_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		tabbedPane_4.addTab("Profile", null, lblNewLabel_2, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(299, 40, 104, 21);
		contentPane.add(tabbedPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		tabbedPane_1.addTab("Forum", null, lblNewLabel_3, null);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(328, 6, 117, 29);
		contentPane.add(btnSignOut);
		
		JLabel lblUserDashboard = new JLabel("User Dashboard");
		lblUserDashboard.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUserDashboard.setBounds(126, 12, 198, 16);
		contentPane.add(lblUserDashboard);
	}
}
