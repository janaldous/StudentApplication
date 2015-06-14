package data;

/**
 * Person superclass that store the basic data of a new person that is standard for
 * all new people objects created.
 * @author CBaker
 *
 */

public class Person {
	
	private String name;
	private String email;
	
	/**
	 * Default constructor that requires the name and e-mail address of the person being
	 * created.
	 * @param name The full name of the person required (case doesn't matter as their name is automatically converted to Title case)
	 * @param email The email address of the person
	 */
	public Person(String name, String email) 
	{
		this.name = toTitleCase(name);
		this.email = email;
	}
	
	/**
	 * Method that converts a String to title case by capitalising the first letter of each word
	 * @param string The String that needs the first letter of each new word capitalised
	 * @return Provides the a new String with each new word capitalised.
	 */
	protected String toTitleCase(String string)
	{
		String[] stringPassed = string.split(" ");
		String result = "";
		for(int i=0; i < stringPassed.length; ++i)
		{
			try
			{
				result += stringPassed[i].substring(0, 1).toUpperCase() + stringPassed[i].substring(1) + " ";
			}
			catch (Exception e)
			{
				continue;
			}
		}
		return result.trim();
		
	}
	
	/**
	 * Method that provides the object data as a String.
	 */
	public String toString()
	{
		return (name + " <" + email + ">");
	}
	
	/**
	 * Method to get the Person's name
	 * @return Person's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Method to get the Person's email address
	 * @return Person's email address
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * Method to set/amend the Person's name
	 * @param name The amended name of the Person required to be stored
	 */
	public void setName(String name)
	{
		this.name = toTitleCase(name);
	}
	
	/**
	 * Method to set/amend the Person's email address
	 * @param email The amended email address of the Person required to be stored
	 */
	public void setEmail(String email)
	{
		this.email = toTitleCase(email);
	}
	
	

}
