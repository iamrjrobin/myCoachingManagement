package myProject;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.KeyStore.TrustedCertificateEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Adminlogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField adminPassField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlogin frame = new Adminlogin();
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
	public Adminlogin() {
		setTitle("Admin login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterKey = new JLabel("Enter key");
		lblEnterKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterKey.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterKey.setBounds(191, 38, 257, 49);
		contentPane.add(lblEnterKey);
		
		adminPassField = new JPasswordField();
		adminPassField.setEchoChar('*');
		adminPassField.setBounds(269, 126, 113, 22);
		contentPane.add(adminPassField);
		
		JCheckBox showKey = new JCheckBox("Show Key");
		showKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(showKey.isSelected())
			{
				adminPassField.setEchoChar((char)0);
			}
			else
			{
				adminPassField.setEchoChar('*');
			}
			}
		});
		showKey.setBounds(269, 181, 113, 25);
		contentPane.add(showKey);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			String inputAdmin=adminPassField.getText();
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
				//String sql;
				String sql=AdminC.sql();
				ResultSet rs=stmt.executeQuery(sql);
				int test=0;
				while(rs.next())
				{
					String adminkey=rs.getString("a_key");
					if(inputAdmin.equals(adminkey))
					{
						JOptionPane.showMessageDialog(null, "Successful");
						test=1;
						Adminlogin.this.setVisible(false);
						new Admin().setVisible(true);
						break;
					}
					if(test!=1)
					{
						JOptionPane.showMessageDialog(null, "Wrong key");
						break;
					}
				}
			}
			catch(Exception s)
			{
				System.out.print(s.getClass().getName()+": "+ s.getMessage());
				System.exit(0);
			}
			}
			
		});
		continueButton.setBounds(269, 300, 97, 25);
		contentPane.add(continueButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(12, 300, 97, 25);
		contentPane.add(backButton);
	}
}
