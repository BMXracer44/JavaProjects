/**
 * This program demonstrates deep copy vs. shadow copy of field objects
 * Class composition
 */
public class CourseDemo {

	public static void main(String[] args) {
		//Create an Instructor object
		Instructor myInstructor = new Instructor ("Cao", "Tina", "LT2247");

		//Create a Textbook object
		Textbook myTextbook = new Textbook("Java: How to Program", 
				"Paul Deitel, Harvey Deitel", "Pearson");
		
		//Create a course object
		Course myCourse1 = new Course ("Intermediate Java, section-01", myInstructor, myTextbook);
		
		//Create a courseV2 object to illustrate the problem caused by shadow copy 
		CourseV2 myCourse2 = new CourseV2 ("Intermediate Java, section-02", myInstructor, myTextbook);
		
		myInstructor.reset(null, null, null);
		myTextbook.reset(null, null, null);
		
		//Display the course information, compare the outputs
		System.out.println(myCourse1);
		System.out.println(myCourse2);
		
	}

}

