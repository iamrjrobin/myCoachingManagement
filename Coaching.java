package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Coaching extends JFrame {

	private JPanel homePane;
	private JTextField customTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coaching frame = new Coaching();
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
	public Coaching() {
		setTitle("Coaching Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 529);
		homePane = new JPanel();
		homePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(homePane);
		homePane.setLayout(null);
		
		JLabel welcome = new JLabel("Welcome to the management system");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setForeground(new Color(0, 0, 0));
		welcome.setFont(new Font("Arial Black", Font.BOLD, 16));
		welcome.setBounds(175, 30, 410, 36);
		homePane.add(welcome);
		
		JLabel lblSelectYourOption = new JLabel("Select your option");
		lblSelectYourOption.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectYourOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectYourOption.setBounds(266, 109, 212, 44);
		homePane.add(lblSelectYourOption);
		
		JButton studentButton = new JButton("Student");
		studentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Coaching.this.setVisible(false);
			new Student().setVisible(true);
			}
		});
		studentButton.setBounds(319, 192, 97, 25);
		homePane.add(studentButton);
		
		JButton teacherButton = new JButton("Teacher");
		teacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Coaching.this.setVisible(false);
				new Teacher().setVisible(true);
			}
		});
		teacherButton.setBounds(319, 253, 97, 25);
		homePane.add(teacherButton);
		
		JButton adminButton = new JButton("Admin");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Coaching.this.setVisible(false);
			new Adminlogin().setVisible(true);
			}
		});
		adminButton.setBounds(319, 317, 97, 25);
		homePane.add(adminButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					File f=new File("custom.txt");
					String c=null;
					Scanner sc=new Scanner(f);
					while(sc.hasNext())
					{
						c=sc.nextLine();
					}
					int s=c.length();
					JOptionPane.showMessageDialog(null, "Length of last custom text was "+s);
					
					System.exit(0);
				}
				catch (Exception s) 
				{
					
				}
				finally 
				{
					System.exit(0);
				}
			}
		});
		exitButton.setBounds(32, 431, 97, 25);
		homePane.add(exitButton);
		
		customTextField = new JTextField();
		customTextField.setHorizontalAlignment(SwingConstants.CENTER);
		customTextField.setBounds(247, 395, 252, 36);
		homePane.add(customTextField);
		customTextField.setColumns(10);
		
		JButton saveCustomButton = new JButton("Save random text");
		saveCustomButton.addActionListener(new ActionListener() {
			String custom=null;
			public void actionPerformed(ActionEvent e) {
			try
			{
				File f=new File("custom.txt");
				FileWriter fw=new FileWriter(f);
				custom=customTextField.getText();
				
				fw.write(custom);
				fw.close();
			}
			catch(IOException s)
			{
				
			}
			}
		});
		saveCustomButton.setBounds(298, 444, 137, 25);
		homePane.add(saveCustomButton);
		
		JLabel lblEnterARandom = new JLabel("Enter a random text here");
		lblEnterARandom.setBounds(298, 366, 157, 16);
		homePane.add(lblEnterARandom);
	}
}
