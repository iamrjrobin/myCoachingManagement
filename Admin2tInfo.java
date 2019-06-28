package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Admin2tInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin2tInfo frame = new Admin2tInfo();
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
	public Admin2tInfo() {
		setTitle("Teacher Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Admin2tInfo.this.setVisible(false);
			new Admin().setVisible(true);
			}
		});
		backButton.setBounds(27, 302, 97, 25);
		contentPane.add(backButton);
		
		table = new JTable();
		table.setBounds(165, 93, 351, 170);
		contentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(165, 99, 351, 163);
		contentPane.add(scrollBar);
		
		JButton btnShowInfo = new JButton("Show info");
		btnShowInfo.addActionListener(new ActionListener() {
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
			Statement stmt=null;
			try
			{
				stmt=con.createStatement();
				table.setModel(DbUtils.resultSetToTableModel(stmt.executeQuery("select t_key from teacher")));
				stmt.close();
			}
			catch(Exception s)
			{
				
			}
			}
		});
		btnShowInfo.setBounds(288, 33, 97, 25);
		contentPane.add(btnShowInfo);
		
		JLabel lblTeacherKey = new JLabel("Teacher Key");
		lblTeacherKey.setBounds(165, 64, 86, 16);
		contentPane.add(lblTeacherKey);
	}
}
