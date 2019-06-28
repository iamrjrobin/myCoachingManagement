package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TeacherFinal extends JFrame {

	private JPanel teacherFinalPane;
	private JTextField studentIDTextField;
	private JTextField phyMarks;
	private JTextField bioMarks;
	private JTextField chemMarks;
	private JTextField hmathMarks;
	private JTextField teacherkeytextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherFinal frame = new TeacherFinal();
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
	public TeacherFinal() {
		setType(Type.POPUP);
		setTitle("Teacher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 460);
		teacherFinalPane = new JPanel();
		teacherFinalPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(teacherFinalPane);
		teacherFinalPane.setLayout(null);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		exitButton.setBounds(143, 356, 97, 25);
		teacherFinalPane.add(exitButton);
		
		studentIDTextField = new JTextField();
		studentIDTextField.setBounds(484, 66, 116, 22);
		teacherFinalPane.add(studentIDTextField);
		studentIDTextField.setColumns(10);
		
		JLabel headingLabel = new JLabel("Enter Student Marks");
		headingLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingLabel.setBounds(246, 13, 203, 43);
		teacherFinalPane.add(headingLabel);
		
		phyMarks = new JTextField();
		phyMarks.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			char c=e.getKeyChar();
			if (Character.isLetter(c)&&!e.isAltDown())
			{
				e.consume();
			}
			}
		});
		phyMarks.setBounds(484, 111, 116, 22);
		teacherFinalPane.add(phyMarks);
		phyMarks.setColumns(10);
		
		bioMarks = new JTextField();
		bioMarks.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if (Character.isLetter(c)&&!e.isAltDown())
				{
					e.consume();
				}
			}
		});
		bioMarks.setBounds(484, 152, 116, 22);
		teacherFinalPane.add(bioMarks);
		bioMarks.setColumns(10);
		
		chemMarks = new JTextField();
		chemMarks.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if (Character.isLetter(c)&&!e.isAltDown())
				{
					e.consume();
				}
			}
		});
		chemMarks.setBounds(484, 199, 116, 22);
		teacherFinalPane.add(chemMarks);
		chemMarks.setColumns(10);
		
		hmathMarks = new JTextField();
		hmathMarks.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if (Character.isLetter(c)&&!e.isAltDown())
				{
					e.consume();
				}
			}
		});
		hmathMarks.setBounds(484, 244, 116, 22);
		teacherFinalPane.add(hmathMarks);
		hmathMarks.setColumns(10);
		
		JLabel studentID = new JLabel("Student ID");
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setBounds(100, 69, 97, 16);
		teacherFinalPane.add(studentID);
		
		JLabel phyLabel = new JLabel("Physics");
		phyLabel.setBounds(119, 114, 56, 16);
		teacherFinalPane.add(phyLabel);
		
		JLabel bioLabel = new JLabel("Biology");
		bioLabel.setBounds(119, 155, 56, 16);
		teacherFinalPane.add(bioLabel);
		
		JLabel chemLabel = new JLabel("Chemistry");
		chemLabel.setBounds(119, 202, 78, 16);
		teacherFinalPane.add(chemLabel);
		
		JLabel hmathsLabel = new JLabel("Higher Maths");
		hmathsLabel.setBounds(119, 247, 104, 16);
		teacherFinalPane.add(hmathsLabel);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			Connection con=null;
			String userteacherkey;
			String ID;
			float bio,chem,hmaths,phy;
			userteacherkey=teacherkeytextfield.getText();
			ID=studentIDTextField.getText();
			bio=Float.parseFloat(bioMarks.getText());
			chem=Float.parseFloat(chemMarks.getText());
			hmaths=Float.parseFloat(hmathMarks.getText());
			phy=Float.parseFloat(phyMarks.getText());
//			avg=(s1.bio+s1.chem+s1.phy+s1.hmaths)/4;
			StudentC s1=new StudentC(hmaths, phy, bio, chem);
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
			stmt.executeUpdate("insert into marks(hmaths,phy,bio,chem,s_id,t_key)values('"+s1.hmaths+"','"+s1.phy+"','"+s1.bio+"','"+s1.chem+"','"+ID+"','"+userteacherkey+"')");
			
			
			JOptionPane.showMessageDialog(null, "done!");
			//stmt.close();
			}
			catch(Exception s)
			{
				System.out.print(s.getClass().getName()+": "+ s.getMessage());
				JOptionPane.showMessageDialog(null, "Failed to save. Check informations again\nClick OK to termiante program");
				System.exit(0);
			}
			
			}
		});
		saveButton.setBounds(569, 356, 97, 25);
		teacherFinalPane.add(saveButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TeacherFinal.this.setVisible(false);
			new Teacher().setVisible(true);
			}
		});
		backButton.setBounds(34, 356, 97, 25);
		teacherFinalPane.add(backButton);
		
		JLabel lblTeacherKey = new JLabel("Teacher key");
		lblTeacherKey.setBounds(119, 287, 78, 16);
		teacherFinalPane.add(lblTeacherKey);
		
		teacherkeytextfield = new JTextField();
		teacherkeytextfield.setBounds(484, 284, 116, 22);
		teacherFinalPane.add(teacherkeytextfield);
		teacherkeytextfield.setColumns(10);
		
		JButton studentButton = new JButton("Student Results");
		studentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TeacherFinal.this.setVisible(false);
			new Teacher2results().setVisible(true);
			}
		});
		studentButton.setBounds(303, 356, 130, 25);
		teacherFinalPane.add(studentButton);
		
		JButton modButton = new JButton("Modify");
		modButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Connection con=null;
				String userteacherkey;
				String ID;
				float bio,chem,hmaths,phy;
				userteacherkey=teacherkeytextfield.getText();
				ID=studentIDTextField.getText();
				bio=Float.parseFloat(bioMarks.getText());
				chem=Float.parseFloat(chemMarks.getText());
				hmaths=Float.parseFloat(hmathMarks.getText());
				phy=Float.parseFloat(phyMarks.getText());
//				avg=(s1.bio+s1.chem+s1.phy+s1.hmaths)/4;
				StudentC s1=new StudentC(hmaths, phy, bio, chem);
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
				
				
				
				//stmt.execute("delete from marks where s_id='"+ID+"';");
				
				//stmt.executeUpdate("insert into marks(hmaths,phy,bio,chem,s_id,t_key)values('"+s1.hmaths+"','"+s1.phy+"','"+s1.bio+"','"+s1.chem+"','"+ID+"','"+userteacherkey+"')");
				
				stmt.executeUpdate("update marks set hmaths= '"+s1.hmaths+"', phy='"+s1.phy+"',bio='"+s1.bio+"',chem='"+s1.chem+"',s_id='"+ID+"',t_key='"+userteacherkey+"' where s_id='"+ID+"' ;");
				
				
				JOptionPane.showMessageDialog(null, "done!");
				stmt.close();
				}
				catch(Exception s)
				{
					System.out.print(s.getClass().getName()+": "+ s.getMessage());
					JOptionPane.showMessageDialog(null, "Failed to save. Check informations again\nClick OK to termiante program");
					System.exit(0);
				}
				
				
			}
		});
		modButton.setBounds(460, 356, 97, 25);
		teacherFinalPane.add(modButton);
	}
}
