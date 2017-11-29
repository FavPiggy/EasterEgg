package edu.uw.tacoma.piggy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;

public class ProjectManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectManagement frame = new ProjectManagement();
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
	public ProjectManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjects = new JLabel("Projects");
		lblProjects.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblProjects.setBounds(158, 21, 120, 32);
		contentPane.add(lblProjects);
		
		JButton button = new JButton("+");
		button.setBounds(333, 6, 117, 29);
		contentPane.add(button);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 71, 387, 174);
		contentPane.add(panel);
		String[] columnNames = {"ID",
                "Name",
                "Date"};
		Object[][] data = {
			    { "123", "Random user 1", "01/01/1991"},
			    { "456", "Random user 2", "01/02/1991"},
			    { "789", "Random user 3", "01/03/1991"},
			    { "012", "Random user 4", "01/04/1991"},
			    { "345", "Random user 5", "01/05/1991"}
			};
		panel.setLayout(null);
		table = new JTable(data, columnNames);
		table.setBounds(0, 0, 336, 80);
		panel.add(table);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(38, 55, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(144, 55, 61, 16);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("........");
		label.setBounds(217, 55, 61, 16);
		contentPane.add(label);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(258, 55, 61, 16);
		contentPane.add(lblDate);
	}
}
