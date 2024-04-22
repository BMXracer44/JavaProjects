/**
 * This course class is used to illustrate 
 * that use deep copy may avoid to cause a security hole in the program 
 *
 */
public class Course {

	private String courseName;	// Name of the course
	private Instructor instructor;	// instructor of the course
	private Textbook textBook;  //textbook 
	
	/** 
	 * This Constructor initializes a course information 
	 *  @param  name The name of the course
	 *  @param  instr The instructor of the course, use deep copy
	 *  @param  text The textbook of the course, use deep copy
	 */
	public Course (String name, Instructor instr, Textbook text)
	{
		courseName = name;  
		
		//Create a new Instructor object by using deep copy
		//passing instr as an argument to the copy constructor
		instructor = new Instructor(instr);//create a new Instructor object instance
		
		//Create a new Textbook object by using deep copy  
		//passing text as an argument to the copy constructor
		textBook = new Textbook(text);//create a new Textbook object instance
		
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
