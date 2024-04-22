package PolymorphismEx1;
//This program demonstrate polymorphic reference variable
public class PolymorphicDemo{
	public static void main(String[] args)
	{
		//Create an array of GradedActivity references
		GradedActivity[] tests = new GradedActivity[3];
		
		//The first test is a regular exam with a numeric score of 75.
		tests[0] = new GradedActivity();
		tests[0].setScore(95);
		
		//The second test is a pass/fail exam, the student missed 5 out of 20 questions
		// and the minimum passing grade is 60.
		tests[1] = new PassFailExam(20, 5, 60);
		
		//The third test is the final exam, There were 50 questions and the student missed 7
		tests[2] = new FinalExam(50, 7);
//		tests.getPointsEach(); //ERROR!, Won't work! 
		
		//Display the grades
		for (GradedActivity test: tests) //enhanced for loop
			displayGrades(test);  //call displayGrades method
	}
	
	public static void displayGrades(GradedActivity g) {  //define a method to display grades
		
		System.out.println("Score " + g.getScore() + ", grade " + g.getGrade() );
	}
}

