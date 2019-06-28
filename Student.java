package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class Student extends JFrame {

	private JPanel studentPane;
	private JPasswordField studentPasswordField;
	private JTextField idTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 469);
		studentPane = new JPanel();
		studentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(studentPane);
		studentPane.setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Student.this.setVisible(false);
			new Coaching().setVisible(true);
			}
		});
		backButton.setBounds(34, 361, 97, 25);
		studentPane.add(backButton);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String userstudentKey=studentPasswordField.getText();
				//String studentKey  ;
				String userID=idTextField.getText();
			//	String ID;
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
				Statement stmt =null;
				try 
				{
					stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select *from student ;");
					int test = 0;
					while(rs.next())
					{
						String studentKey=rs.getString("s_key");
						String ID=rs.getString("s_id");
						
						if((userstudentKey.equals(studentKey))&&(userID.equals(ID)))
						{
							//Student.this.setVisible(false);
							JOptionPane.showMessageDialog(null, "Successful");
							test=1;
							//new StudentFinal().setVisible(true);
							table.setModel(DbUtils.resultSetToTableModel(stmt.executeQuery("select hmaths,phy,bio,chem,s_id from marks where s_id='"+ID+"';")));
							
							break;
						}
						if(test!=1)
						{
							JOptionPane.showMessageDialog(null, "Wrong info");
							break;
						}
//						else
//						{
//							JOptionPane.showMessageDialog(null, "Wrong key");
//							
//						}
					}
					
				}
				catch(Exception s)
				{
					System.err.println( s.getClass().getName() + ": " + s.getMessage() );
			        System.exit(0);
				}
				
				
			}
			
		});
		continueButton.setBounds(548, 361, 97, 25);
		studentPane.add(continueButton);
		
		JLabel headLabel = new JLabel("LogIN");
		headLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setBounds(12, 13, 68, 51);
		studentPane.add(headLabel);
		
		studentPasswordField = new JPasswordField();
		studentPasswordField.setToolTipText("");
		studentPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		studentPasswordField.setEchoChar('*');
		studentPasswordField.setBounds(12, 168, 157, 22);
		studentPane.add(studentPasswordField);
		
		JCheckBox keyCheckBox = new JCheckBox("Show key");
		keyCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(keyCheckBox.isSelected())
				{
					studentPasswordField.setEchoChar((char)0);
				}
				else
				{
					studentPasswordField.setEchoChar('*');
			
				}
				}
			
		});
		keyCheckBox.setBounds(12, 199, 113, 25);
		studentPane.add(keyCheckBox);
		
		idTextField = new JTextField();
		idTextField.setHorizontalAlignment(SwingConstants.CENTER);
		idTextField.setBounds(12, 108, 157, 22);
		studentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Key");
		lblNewLabel.setBounds(12, 143, 56, 16);
		studentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(12, 77, 56, 16);
		studentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(305, 65, 355, 276);
		studentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(305, 65, 355, 275);
		studentPane.add(scrollBar);
		
		JLabel lblHmath = new JLabel("H.Math");
		lblHmath.setBounds(308, 48, 46, 16);
		studentPane.add(lblHmath);
		
		JLabel lblPhysics = new JLabel("Physics");
		lblPhysics.setBounds(377, 48, 46, 16);
		studentPane.add(lblPhysics);
		
		JLabel lblBiology = new JLabel("Biology");
		lblBiology.setBounds(456, 48, 54, 16);
		studentPane.add(lblBiology);
		
		JLabel lblChemistry = new JLabel("Chemistry");
		lblChemistry.setBounds(522, 48, 68, 16);
		studentPane.add(lblChemistry);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(602, 48, 56, 16);
		studentPane.add(lblId);
	}
}
