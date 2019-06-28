package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Teacher extends JFrame {

	private JPanel teacherHomePane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher frame = new Teacher();
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
	public Teacher() {
		setTitle("Teacher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 451);
		teacherHomePane = new JPanel();
		teacherHomePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(teacherHomePane);
		teacherHomePane.setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Teacher.this.setVisible(false);
			new Coaching().setVisible(true);
			}
		});
		backButton.setBounds(37, 347, 97, 25);
		teacherHomePane.add(backButton);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")

			public void actionPerformed(ActionEvent e) {
				
				
				String userteacherkey=passwordField.getText();
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
					ResultSet rs= stmt.executeQuery("select *from teacher;");
					int test=0;
					while(rs.next())
					{
						String teacherkey=rs.getString("t_key");
						if(userteacherkey.equals(teacherkey))
						{
							JOptionPane.showMessageDialog(null, "Successful");
							test=1;
							Teacher.this.setVisible(false);
							new TeacherFinal().setVisible(true);
							break;
						}
						if(test!=1)
						{
							JOptionPane.showMessageDialog(null, "Wrong info");
							break;
						}
					}
				}
				catch(Exception s)
				{
					System.err.println( s.getClass().getName() + ": " + s.getMessage() );
			        System.exit(0);
				}
				
			}
		});
		continueButton.setBounds(556, 347, 97, 25);
		teacherHomePane.add(continueButton);
		
		JLabel headingLabel = new JLabel("Please enter teacher key");
		headingLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingLabel.setBounds(189, 40, 330, 53);
		teacherHomePane.add(headingLabel);
		
		JLabel keyLabel = new JLabel("Key");
		keyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		keyLabel.setBounds(189, 142, 56, 16);
		teacherHomePane.add(keyLabel);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
						
		});
		passwordField.setBounds(405, 139, 116, 22);
		teacherHomePane.add(passwordField);
		
		JCheckBox keyCheckBox = new JCheckBox("Show key");
		keyCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(keyCheckBox.isSelected())
			{
				passwordField.setEchoChar((char)0);
			}
			else
			{
				passwordField.setEchoChar('*');
			}
			}
		});
		keyCheckBox.setBounds(403, 170, 116, 25);
		teacherHomePane.add(keyCheckBox);
	}
}
