package myProject;

import java.awt.BorderLayout;
import myProject.StudentC;
import java.awt.EventQueue;
import myProject.TeacherFinal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StudentFinal extends JFrame {

	private JPanel studentFinalPane;
	private JTextField chemTextField;
	private JTextField bioTextField;
	private JTextField hmathsTextField;
	private JTextField phyTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFinal frame = new StudentFinal();
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
	public StudentFinal() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 475);
		studentFinalPane = new JPanel();
		studentFinalPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(studentFinalPane);
		studentFinalPane.setLayout(null);
		
		chemTextField = new JTextField();
		chemTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//chemTextField.setText(String.valueOf(s1.chem));
			}
		});
		chemTextField.setEditable(false);
		chemTextField.setBounds(499, 242, 116, 22);
		studentFinalPane.add(chemTextField);
		chemTextField.setColumns(10);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			StudentFinal.this.setVisible(false);
			new Student().setVisible(true);
			}
		});
		backButton.setBounds(37, 373, 97, 25);
		studentFinalPane.add(backButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		exitButton.setBounds(518, 373, 97, 25);
		studentFinalPane.add(exitButton);
		
		JLabel chemLabel = new JLabel("Chemistry");
		chemLabel.setBounds(53, 245, 67, 16);
		studentFinalPane.add(chemLabel);
		
		JLabel bioLable = new JLabel("Biology");
		bioLable.setBounds(53, 210, 67, 16);
		studentFinalPane.add(bioLable);
		
		bioTextField = new JTextField();
		bioTextField.setEditable(false);
		bioTextField.setBounds(499, 207, 116, 22);
		studentFinalPane.add(bioTextField);
		bioTextField.setColumns(10);
		
		JLabel hmathsLabel = new JLabel("H.Maths");
		hmathsLabel.setBounds(53, 175, 56, 16);
		studentFinalPane.add(hmathsLabel);
		
		hmathsTextField = new JTextField();
		hmathsTextField.setEditable(false);
		hmathsTextField.setBounds(499, 172, 116, 22);
		studentFinalPane.add(hmathsTextField);
		hmathsTextField.setColumns(10);
		
		JLabel phyLabel = new JLabel("Physics");
		phyLabel.setBounds(53, 140, 56, 16);
		studentFinalPane.add(phyLabel);
		
		phyTextField = new JTextField();
		phyTextField.setEditable(false);
		phyTextField.setBounds(499, 137, 116, 22);
		studentFinalPane.add(phyTextField);
		phyTextField.setColumns(10);
	}
}
