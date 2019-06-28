package myProject;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Admin2sInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin2sInfo frame = new Admin2sInfo();
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
	public Admin2sInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 92, 320, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JButton infoButton = new JButton("Show");
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				//String studentKey,ID, Name;
				//studentKey=studentKeyField.getText();
				//ID=IDTextField.getText();
				//Name=studentNameField.getText();
				//StudentC s1=new StudentC(studentKey, ID, Name);
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
				//stmt.executeUpdate("select *from student");
				
				
				table.setModel(DbUtils.resultSetToTableModel(stmt.executeQuery("select s_id,s_name,s_key from student")));
				stmt.close();
				//JOptionPane.showMessageDialog(null, "done!");
				}
				catch(Exception s)
				{
				
				}
			}
		});
		infoButton.setBounds(246, 30, 97, 25);
		contentPane.add(infoButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Admin2sInfo.this.setVisible(false);
			new Admin().setVisible(true);
			}
		});
		backButton.setBounds(12, 325, 97, 25);
		contentPane.add(backButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(135, 63, 56, 16);
		contentPane.add(lblId);
		
		JLabel lblKey = new JLabel("Key");
		lblKey.setBounds(256, 62, 56, 16);
		contentPane.add(lblKey);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(371, 63, 56, 16);
		contentPane.add(lblName);
	}
}
