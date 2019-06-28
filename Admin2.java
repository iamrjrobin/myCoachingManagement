package myProject;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import myProject.StudentC;
public class Admin2 extends JFrame {

	private JPanel modifyStudentPane;
	private JTextField removeStudentIDTextField;
	private JTextField IDTextField;
	private JTextField studentNameField;
	private JTextField studentKeyField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin2 frame = new Admin2();
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
	public Admin2() {
		setTitle("Modify Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 524);
		modifyStudentPane = new JPanel();
		modifyStudentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(modifyStudentPane);
		modifyStudentPane.setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin2.this.setVisible(false);
				new Admin().setVisible(true);
			}
		});
		backButton.setBounds(38, 419, 97, 25);
		modifyStudentPane.add(backButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		exitButton.setBounds(538, 419, 97, 25);
		modifyStudentPane.add(exitButton);
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int test=1;
				Connection con=null;
				try
				{
					Class.forName("org.sqlite.JDBC");
					con=DriverManager.getConnection("jdbc:sqlite:H://Eclipse codingsWin//myProject//src//myProject//student.sqlite");
				}
				catch(Exception s)
				{
					System.out.print(s.getClass().getName()+": "+ s.getMessage());
					System.exit(0);
				}
				Statement stmt= null;
				try
				{
					stmt=con.createStatement();
					String studentid=removeStudentIDTextField.getText();
					stmt.executeUpdate("delete from student where s_id='"+studentid+"'");
					stmt.close();
					
				}
				catch (Exception s) 
				{
					test=0;
					System.out.print(s.getClass().getName()+": "+ s.getMessage());
					System.exit(0);
				}
				if(test!=0)
				{
					JOptionPane.showMessageDialog(null, "No match found");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "done");
				}
			}
		});
		removeButton.setBounds(538, 327, 97, 25);
		modifyStudentPane.add(removeButton);
		
		removeStudentIDTextField = new JTextField();
		removeStudentIDTextField.setHorizontalAlignment(SwingConstants.CENTER);
		removeStudentIDTextField.setText("Enter ID to remove student");
		removeStudentIDTextField.setBounds(38, 328, 258, 22);
		modifyStudentPane.add(removeStudentIDTextField);
		removeStudentIDTextField.setColumns(10);
		
		JButton addStudent = new JButton("Add");
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Connection con=null;
			String studentKey,ID, Name;
			studentKey=studentKeyField.getText();
			ID=IDTextField.getText();
			Name=studentNameField.getText();
			StudentC s1=new StudentC(studentKey, ID, Name);
			try
			{
				Class.forName("org.sqlite.JDBC");
				con=DriverManager.getConnection("jdbc:sqlite:H://Eclipse codingsWin//myProject//src//myProject//student.sqlite");	
			}
			catch(Exception s)
			{
				System.out.print(s.getClass().getName()+": "+ s.getMessage());
				System.exit(0);
			}
			Statement stmt =null;
			try
			{
			stmt=con.createStatement();
			stmt.executeUpdate("insert into student(s_id,s_key,s_name,a_key)values('"+s1.ID+"','"+s1.studentKey+"','"+s1.Name+"','999')");
			//stmt.close();
			JOptionPane.showMessageDialog(null, "done!");
			}
			catch(Exception s)
			{
				System.out.print(s.getClass().getName()+": "+ s.getMessage());
				System.exit(0);
			}
			}
		});
		addStudent.setBounds(538, 260, 97, 25);
		modifyStudentPane.add(addStudent);
		
		IDTextField = new JTextField();
		IDTextField.setText("Enter new student ID");
		IDTextField.setHorizontalAlignment(SwingConstants.CENTER);
		IDTextField.setColumns(10);
		IDTextField.setBounds(38, 39, 258, 22);
		modifyStudentPane.add(IDTextField);
		
		studentNameField = new JTextField();
		studentNameField.setText("Enter new student name");
		studentNameField.setHorizontalAlignment(SwingConstants.CENTER);
		studentNameField.setColumns(10);
		studentNameField.setBounds(38, 128, 258, 22);
		modifyStudentPane.add(studentNameField);
		
		studentKeyField = new JTextField();
		studentKeyField.setText("Enter new student key");
		studentKeyField.setHorizontalAlignment(SwingConstants.CENTER);
		studentKeyField.setColumns(10);
		studentKeyField.setBounds(38, 210, 258, 22);
		modifyStudentPane.add(studentKeyField);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			IDTextField.setText("");
			
			}
		});
		clearButton.setBounds(327, 38, 97, 25);
		modifyStudentPane.add(clearButton);
		
		btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			studentNameField.setText("");
			}
		});
		btnNewButton.setBounds(327, 127, 97, 25);
		modifyStudentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			studentKeyField.setText("");
			}
		});
		btnNewButton_1.setBounds(327, 209, 97, 25);
		modifyStudentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			removeStudentIDTextField.setText("");
			}
		});
		btnNewButton_2.setBounds(38, 363, 97, 25);
		modifyStudentPane.add(btnNewButton_2);
	}
}
