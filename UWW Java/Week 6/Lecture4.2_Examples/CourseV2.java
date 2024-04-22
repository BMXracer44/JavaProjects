/**
 * This courseV2 class is used to illustrate 
 * that the shadow copy may create a security hole in the program 
 *
 */
public class CourseV2 {

	private String courseName;	// Name of the course
	private Instructor instructor;	// instructor of the course
	private Textbook textBook;  //textbook 
	
	/** 
	 * This Constructor initializes a course information 
	 *  @param  name The name of the course
	 *  @param  instr The instructor of the course, use shadow copy
	 *  @param  text The textbook of the course, use shadow copy
	 */
	public CourseV2 (String name, Instructor instr, Textbook text)
	{
		courseName = name;  
		
		//Create a new Instructor object  
		//by assigning an Instructor object reference variable directly to 
		//instance variable: instructor (which is a reference variable)  
		instructor = instr;  //shadow copy, creates a security hole
		//Create a new Textbook object  
		//by assigning an Instructor object reference variable directly to 
		//instance variable: instructor (which is a reference variable) 
		textBook = text;  //shadow copy, creates a security hole
		
	}
	
	/**
	 * getCourseName method
	 * @return the name of the course
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * getInstructor method
	 * @return a reference to a copy of this course's Instructor object
	 */
	public Instructor getInstructor() {
		//return a copy of the instructor object
		return new Instructor (instructor);
	}
	
	/**
	 * getTextBook method
	 * @return a reference to a copy of this course's Textbook object
	 */
	public Textbook getTextBook() {
		//return a copy of the instructor object
		return new Textbook (textBook);
	}
	
	/**
	 * toString method
	 * @return A string containing a Textbook object information.
	 */
	public String toString()
	{
		//Create a string representing the information about object.
		String str = "Course name: " + courseName + 
				"\nInstructor information: " + instructor +
				"\nTextbook information: " + textBook;
		//return the string
		return str;
	}
}
