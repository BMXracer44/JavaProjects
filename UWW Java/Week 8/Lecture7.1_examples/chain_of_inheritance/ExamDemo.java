package chain_of_inheritance;
import java.util.Scanner;

public class ExamDemo{
	public static void main(String[] args)
	{
		int questions;   //number of questions
		int missed;  //number of questions missed
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("How many questions in the final exam? ");
		questions = keyboard.nextInt();
		
		System.out.println("How many questions missed in the final? ");
		missed = keyboard.nextInt();
		
		//create a final exam object
		FinalExam finalexam = new FinalExam(questions, missed);
		
		//Display the test results
		System.out.printf("\nFinalExam:\n Each question counts: %.2f points", finalexam.getPointsEach() );
		System.out.printf("%n The final exam score is : %.2f out of 100", finalexam.getScore() );
		System.out.printf("%n The final exam grade is : %s\n", finalexam.getGrade() );
		
		//create a PassFail exam object
		System.out.println("How many questions in the pass or fail exam? ");
		questions = keyboard.nextInt();
		
		System.out.println("How many questions missed in the pass or fail exam? ");
		missed = keyboard.nextInt();
		
		System.out.println("What is the minimum passing score? ");
		double passScore = keyboard.nextDouble();
		
		PassFailExam newExam = new PassFailExam(questions, missed, passScore);
		
		//Display the test results
		System.out.printf("\nPassFailExam:\n Each question counts: %.2f points", newExam.getPointsEach() );
		System.out.printf("%n The PassFail exam score is : %.2f out of 100", newExam.getScore() );
		System.out.printf("%n The PassFail exam grade is : %s", newExam.getGrade() );
		keyboard.close();
	}
}
