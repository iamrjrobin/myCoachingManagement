package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Admin2Teacher extends JFrame {

	private JPanel admin2teacherPane;
	private JTextField pwdTextField;
	private JTextField removeTeacherKeyTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin2Teacher frame = new Admin2Teacher();
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
	public Admin2Teacher() {
		setTitle("Modify Teacher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 476);
		admin2teacherPane = new JPanel();
		admin2teacherPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(admin2teacherPane);
		admin2teacherPane.setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin2Teacher.this.setVisible(false);
				new Admin().setVisible(true);
			}
		});
		backButton.setBounds(33, 365, 97, 25);
		admin2teacherPane.add(backButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		exitButton.setBounds(565, 365, 97, 25);
		admin2teacherPane.add(exitButton);
		
		pwdTextField = new JTextField();
		pwdTextField.setHorizontalAlignment(SwingConstants.CENTER);
		pwdTextField.setText("Key for New Teacher");
		pwdTextField.setBounds(33, 86, 266, 22);
		admin2teacherPane.add(pwdTextField);
		pwdTextField.setColumns(10);
		
		JButton teacherAddButton = new JButton("Add");
		teacherAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
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
				String teacherkey=pwdTextField.getText();
				stmt.executeUpdate("insert into teacher(t_key,a_key)values('"+teacherkey+"','999')");
				stmt.close();
				JOptionPane.showMessageDialog(null, "Done!");
			}
			catch (Exception s) 
			{
				System.out.print(s.getClass().getName()+": "+ s.getMessage());
				JOptionPane.showMessageDialog(null, "Failed to add. Check informations again\nClick OK to termiante program");
				System.exit(0);
			}
			}
		});
		teacherAddButton.setBounds(565, 85, 97, 25);
		admin2teacherPane.add(teacherAddButton);
		
		JButton removeTeacherButton = new JButton("Remove");
		removeTeacherButton.addActionListener(new ActionListener() {
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
					String teacherkey=removeTeacherKeyTextField.getText();
					stmt.executeUpdate("delete from teacher where t_key='"+teacherkey+"'");
					stmt.close();
					//JOptionPane.showMessageDialog(null, "Done!");
				}
				catch (Exception s) 
				{
					test =0;
					System.out.print(s.getClass().getName()+": "+ s.getMessage());
					System.exit(0);
				}
			
				if(test!=0)
				{
					//JOptionPane.showMessageDialog(null, "No match found");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "done");
				}
			}
		});
		removeTeacherButton.setBounds(565, 241, 97, 25);
		admin2teacherPane.add(removeTeacherButton);
		
		removeTeacherKeyTextField = new JTextField();
		removeTeacherKeyTextField.setHorizontalAlignment(SwingConstants.CENTER);
		removeTeacherKeyTextField.setText("Enter Teacher Key to Remove");
		removeTeacherKeyTextField.setBounds(33, 242, 266, 22);
		admin2teacherPane.add(removeTeacherKeyTextField);
		removeTeacherKeyTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			removeTeacherKeyTextField.setText("");
			}
		});
		btnNewButton.setBounds(33, 277, 97, 25);
		admin2teacherPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pwdTextField.setText("");
			}
		});
		btnNewButton_1.setBounds(33, 121, 97, 25);
		admin2teacherPane.add(btnNewButton_1);
	}

}
