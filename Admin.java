package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Admin extends JFrame {

	private JPanel adminPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 473);
		adminPane = new JPanel();
		adminPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(adminPane);
		adminPane.setLayout(null);
		
		JButton modStudentButton = new JButton("Student options");
		modStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.this.setVisible(false);
				new Admin2().setVisible(true);
			}
		});
		modStudentButton.setBounds(255, 94, 170, 25);
		adminPane.add(modStudentButton);
		
		JButton modTeacherButton = new JButton("Teacher options");
		modTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.this.setVisible(false);
				new Admin2Teacher().setVisible(true);
			}
		});
		modTeacherButton.setBounds(255, 165, 170, 25);
		adminPane.add(modTeacherButton);
		
		JButton studentInfoButton = new JButton("Student Info");
		studentInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Admin.this.setVisible(false);
			new Admin2sInfo().setVisible(true);
			}
		});
		studentInfoButton.setBounds(255, 237, 170, 25);
		adminPane.add(studentInfoButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.this.setVisible(false);
				new Coaching().setVisible(true);
			}
		});
		backButton.setBounds(44, 388, 97, 25);
		adminPane.add(backButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(554, 388, 97, 25);
		adminPane.add(exitButton);
		
		JButton teacherInfoButton = new JButton("Teacher Info");
		teacherInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Admin.this.setVisible(false);
			new Admin2tInfo().setVisible(true);
			}
		});
		teacherInfoButton.setBounds(255, 307, 170, 25);
		adminPane.add(teacherInfoButton);
	}
}
