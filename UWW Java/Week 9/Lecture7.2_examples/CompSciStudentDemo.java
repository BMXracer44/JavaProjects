
//This program demonstrate abstract class and abstract method
public class CompSciStudentDemo{
	public static void main(String[] args)
	{
		//Create a ComSciStudent object
		ComSciStudent csStudent = new ComSciStudent("Jennifer Haynes", "167W98337", 2015);
		//Score values for math, CS, and gen ed hours
		csStudent.setMathHours(12);
		csStudent.setCsHours(20);
		csStudent.setGenEdHours(40);
		
		//Display the student's data
		System.out.println(csStudent); // the toString method in Student class will be called
		
		//Display number of remaining hours
		System.out.println("Hours remaining: " + csStudent.getRemainingHours());
	}
	
	public static void displayGrades(GradedActivity g) {  //define a method to display grades
		
		System.out.println("Score " + g.getScore() + ", grade " + g.getGrade() );
	}
}

