
/**
 * The student class is an abstract class that holds general data 
 * about a student, Classes representing specific types of students
 * inherit from this class
 */
public abstract class Student {
	
	private String name;	//Student name
	private String idNumber;	//Student ID
	private int yearAdmitted;	//Year admitted
	
	/**
	 * The constructor sets the student's name, ID number, and year admitted
	 */
	public Student(String n, String id, int year)
	{
		name = n;
		idNumber = id;
		yearAdmitted = year;
	}
	
	/** The toString method returns a String containing the student's data
	 */
	public String toString()
	{
		String str;
		str = "Name: " + name + "\nID number: " + idNumber + "\nYear Admitted: " + yearAdmitted;
		return str;
	}
	
	/** The getRemainingHours method is abstract. 
	 * It must be overridden in a subclass.
	 * @return The hours remaining for the student
	 */
	public abstract int getRemainingHours(); //no function body, only header
	
}
