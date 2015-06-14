package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import data.Student;


/**
 * Information panel pop-up window that displays further information about a Student
 * from when their entry on the list in the main application window is clicked on.
 * @author CBaker
 *
 */
public class StudentInformation extends JDialog {
	
	private static final long serialVersionUID = 3677564380651976735L;
	
	private JLabel lblStudentName;
	private JLabel lblStudentEmail;
	private JLabel lblStudentNumber;
	private JLabel lblTutorEmail;

	/**
	 * Default constructor in order to construct the the pop-up window with the Student's
	 * details of the Student selected by the user.
	 * @param currentStudent Requires the selected Student object to construct the frame with their details.
	 */
	public StudentInformation(Student currentStudent, JFrame parent)
	{
		super(parent);
		setMinimumSize(new Dimension(450, 250));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		
		
		JPanel jpStudentDetails = new JPanel(new GridLayout(2, 1));
		jpStudentDetails.setBackground(Color.white);
		jpStudentDetails.setBorder(new EmptyBorder(20, 10, 30, 10));
		add(jpStudentDetails, BorderLayout.NORTH);
		
			lblStudentName = new JLabel(currentStudent.getName());
			lblStudentName.setFont(new Font("Calibri", Font.PLAIN, 30));
			lblStudentName.setHorizontalAlignment(SwingConstants.CENTER);
			jpStudentDetails.add(lblStudentName);
		
			lblStudentEmail = new JLabel(currentStudent.getEmail());
			lblStudentEmail.setFont(new Font("Calibri", Font.ITALIC, 26));
			lblStudentEmail.setHorizontalAlignment(SwingConstants.CENTER);
			jpStudentDetails.add(lblStudentEmail);
		
		
		JPanel jpSouth = new JPanel(new BorderLayout());
		jpSouth.setBackground(Color.white);
		add(jpSouth, BorderLayout.SOUTH);
		
			JPanel jpLabelsPanel = new JPanel(new GridLayout(2, 1));
			jpLabelsPanel.setBackground(Color.white);
			jpLabelsPanel.setBorder(new EmptyBorder(0, 20, 50, 20));
			jpSouth.add(jpLabelsPanel, BorderLayout.WEST);
			Font infoFont = new Font("Calibri", Font.PLAIN, 20);
		
				JLabel lblStudentId = new JLabel("Student Number:");
				lblStudentId.setFont(infoFont);
				jpLabelsPanel.add(lblStudentId);
			
				JLabel lblTutor = new JLabel("Tutor:");
				lblTutor.setFont(infoFont);
				jpLabelsPanel.add(lblTutor);
		
			JPanel jpInfoPanel = new JPanel(new GridLayout(2, 1));
			jpInfoPanel.setBackground(Color.WHITE);
			jpInfoPanel.setBorder(new EmptyBorder(0, 0, 50, 20));
			jpSouth.add(jpInfoPanel, BorderLayout.CENTER);
			
				lblStudentNumber = new JLabel(Integer.toString(currentStudent.getStudentNumber()));
				lblStudentNumber.setFont(infoFont);
				jpInfoPanel.add(lblStudentNumber);
				
				lblTutorEmail = new JLabel(currentStudent.getTutor().getEmail());
				lblTutorEmail.setFont(infoFont);
				jpInfoPanel.add(lblTutorEmail);
		
		
		pack();
		setVisible(true);
		
	}
	
	/**
	 * Method to update the pop-up window with another Student's details when a new Student is
	 * selected from the list in the main window and the information panel has already been
	 * constructed before.
	 * @param studentSelected Student object of the Student that has been selected by the user from the list in the main window.
	 */
	public void updateStudentDetails(Student studentSelected)
	{
		lblStudentName.setText(studentSelected.getName());
		lblStudentEmail.setText(studentSelected.getEmail());
		lblStudentNumber.setText(Integer.toString(studentSelected.getStudentNumber()));
		lblTutorEmail.setText(studentSelected.getTutor().getEmail());
		pack();		
	}
	


}
