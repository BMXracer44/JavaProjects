/**
 * This Instructor class holds data about an instructor
 *
 */
public class Instructor {

	private String lastName;	//last name
	private String firstName;	//first name
	private String officeNumber; //Office number
	
	/** 
	 * This Constructor initializes the last name, first name, and office number 
	 *  @param  lname The Instructor's last name
	 *  @param  fname The instructor's first name
	 *  @param  office The office number
	 */
	public Instructor (String lname, String fname, String office)
	{
		lastName = lname;
		firstName = fname;
		officeNumber = office;
	}
	
	/** 
	 * The copy constructor initialize the object
	 * as a copy of another Instructor object
	 * @param instr The Instructor object to copy
	 */
	public Instructor (Instructor instr) // a copy constructor that is used to create a copy of an existing object
	{
		lastName = instr.lastName;
		firstName = instr.firstName;
		officeNumber = instr.officeNumber;
	}
	/**
	 * The reset method sets a value for each field,
	 * @param lname The instructor's last name
	 * @param fname The instructor's first name
	 * @param office The instructor's office number
	 */
	public void reset(String lname, String fname, String office)
	{
		lastName = lname;
		firstName = fname;
		officeNumber = office;
	}
	
	/**
	 * toString method
	 * @return A string containing the instructor information.
	 */
	public String toString()
	{
		//Create a string representing the information about object.
		String str = "\n Last name: " + lastName + "\n First name: " + firstName +
				"\n Office number: " + officeNumber;
		//return the string
		return str;
	}
}
