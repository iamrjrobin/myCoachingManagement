package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Teacher2results extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField studentidTextField;
	private JLabel lblHmaths;
	private JLabel lblPhysics;
	private JLabel lblChemistry;
	private JLabel lblBiology;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher2results frame = new Teacher2results();
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
	public Teacher2results() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(156, 113, 376, 235);
		contentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(155, 113, 377, 235);
		contentPane.add(scrollBar);
		
		studentidTextField = new JTextField();
		studentidTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		studentidTextField.setBounds(156, 50, 116, 22);
		contentPane.add(studentidTextField);
		studentidTextField.setColumns(10);
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID");
		lblEnterStudentId.setBounds(156, 21, 116, 16);
		contentPane.add(lblEnterStudentId);
		
		JButton showResultButton = new JButton("Show");
		showResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String userinput;
			userinput=studentidTextField.getText();
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
				ResultSet rs=stmt.executeQuery("select *from student ;");
				int test = 0;
				//while(rs.next())
			//	{
					String studentID=rs.getString("s_id");
					//if(userinput.equals(studentID))
					//{
						JOptionPane.showMessageDialog(null, "Successful");
						test=1;
						table.setModel(DbUtils.resultSetToTableModel(stmt.executeQuery("select hmaths,phy,bio,chem,s_id from marks")));
						
					//	break;
				//	}
					//if(test!=1)
					//{
						//JOptionPane.showMessageDialog(null, "No match found\nCheck info and try again");
						//break;
					//}
				//}
				stmt.close();
			}
			catch(Exception s)
			{
				System.err.println( s.getClass().getName() + ": " + s.getMessage() );
		        System.exit(0);
			}
			}
		});
		showResultButton.setBounds(435, 49, 97, 25);
		contentPane.add(showResultButton);
		
		lblHmaths = new JLabel("H.Maths");
		lblHmaths.setBounds(156, 84, 56, 16);
		contentPane.add(lblHmaths);
		
		lblPhysics = new JLabel("Physics");
		lblPhysics.setBounds(235, 85, 56, 16);
		contentPane.add(lblPhysics);
		
		lblChemistry = new JLabel("Chemistry");
		lblChemistry.setBounds(371, 84, 65, 16);
		contentPane.add(lblChemistry);
		
		lblBiology = new JLabel("Biology");
		lblBiology.setBounds(303, 84, 56, 16);
		contentPane.add(lblBiology);
		
		lblId = new JLabel("ID");
		lblId.setBounds(476, 84, 56, 16);
		contentPane.add(lblId);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Teacher2results.this.setVisible(false);
			new Teacher().setVisible(true);
			}
		});
		backButton.setBounds(25, 376, 97, 25);
		contentPane.add(backButton);
	}
}
