package edu.uw.tacoma.piggy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;

public class ProjectDescription extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectDescription frame = new ProjectDescription();
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
	public ProjectDescription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewProject = new JLabel("New Project");
		lblNewProject.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewProject.setBounds(154, 16, 134, 25);
		contentPane.add(lblNewProject);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(52, 74, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(37, 105, 61, 16);
		contentPane.add(lblCategory);
		
		textField = new JTextField();
		textField.setBounds(95, 69, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(223, 105, -123, 16);
		contentPane.add(list);
	}
}
