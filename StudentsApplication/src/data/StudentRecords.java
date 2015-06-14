package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import studentdata.*;

public class StudentRecords {
	
	private ArrayList<Student> allStudents;
	
	public StudentRecords()
	{
		allStudents = new ArrayList<>();
		loadStudents();
	}
	
	public void addStudent(Student newStudent)
	{
		allStudents.add(newStudent);
	}
	
	public ArrayList<Student> getAllStudents()
	{
		return allStudents;
	}
	
	public void loadStudents()
	{
		Connector server = new Connector();
        boolean success = server.connect("GTeam1", "2eb5555da3241498a24e5c3ffc91715c");
        
        if (success == false) 
        {
        	JOptionPane.showMessageDialog(null, "Fatal Error: \nCould not open connection to the server "
        			+ "\nto retreieve the students data.", "Server Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
        DataTable data = server.getData();
        for(int row =0; row < data.getRowCount(); ++row)
        {
        	int studentNumber = Integer.parseInt(data.getCell(row, 0));
        	String name = data.getCell(row, 1);
        	String email = data.getCell(row, 2);
        	String tutorEmail = data.getCell(row, 3);
        	
        	allStudents.add(new Student(name, email, studentNumber, tutorEmail));
        }
	}
	
	
	

}
