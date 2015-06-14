package data;

/**
 * Student subclass that extends/inherits from the Person class with additional capabilities
 * to store data specific to a student.
 * 
 * It also includes a Person object storing the details of the student's personal tutor
 * @author CBaker
 * @see Person
 * 
 */
public class Student extends Person{
	
	/**
	 * Inherits name & email fields from the Person parent class.
	 */
	private int studentNumber;
	private Person tutor;
	
	/**
	 * Default constructor in order to create an instance of a Person that is a student.
	 * @param name Full name of the Student required
	 * @param email Student's email address required
	 * @param studentNumber Student's ID number required (should be an integer)
	 * @param tutorEmail Email address of the Student's personal tutor required.
	 */
	public Student(String name, String email, int studentNumber, String tutorEmail)
	{
		super(name, email);		//sends data to the constructor of the parent Person class
		this.studentNumber = studentNumber;
		String[] emailSplit = tutorEmail.split("@");
		String[] tutorNameArray = emailSplit[0].split("\\.");
		String tutorName = "";
		for(int i=0; i < tutorNameArray.length; ++i)
		{
			tutorName += tutorNameArray[i] + " ";
		}
		//creates a new Person by splitting the up the tutor's email address.
		tutor = new Person(super.toTitleCase(tutorName), tutorEmail);
	}
	
	/**
	 * Method to provide the data stored in this Student object as a String
	 */
	public String toString()
	{
		return (getName() + " (" + studentNumber + ")");
	}
	
	/**
	 * Method to get the Student's ID number
	 * @return Student Number
	 */
	public int getStudentNumber()
	{
		return studentNumber;
	}
	
	/**
	 * Method to set/amend the Student's ID Number
	 * @param studentNumber Amended student's number required.
	 */
	public void setStudentNumber(int studentNumber)
	{
		this.studentNumber = studentNumber;
	}
	
	/**
	 * Method to get the Student's Tutor details
	 * @return Tutor's name and e-mail address
	 */
	public Person getTutor()
	{
		return tutor;
	}

	/**
	 * Method to set/amend the Student's tutor details
	 * @param tutor new/existing Person object required to amend the tutor details stored for the Student
	 */
	public void setTutor(Person tutor)
	{
		this.tutor = tutor;
	}
	
	

}
