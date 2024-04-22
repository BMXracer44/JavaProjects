

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionTestDemo {

	public static void main(String[] args) {
		
		// Create a quiz an ArrayList named "quiz" that contains all kinds of questions
		ArrayList<Question> quiz = createQuiz();
	    // display quiz
        displayQuiz(quiz);
	}
	
	/**
	 * create a quiz that is an ArrayList of all kinds of questions
	 * @return an ArrayList of questions as a quiz
	 */
	//step-4: add java code to complete this method
	public static ArrayList<Question> createQuiz(){
		ArrayList<Question> quiz = new ArrayList<Question>();
		
		//create a new FillInQuestion question and add it to quiz
		quiz.add(new FillInQuestion("What year is it?", "2023"));		//create a new ChoiceQuestion question and add it to quiz
		//create a new MultiChoiceQuestion question and add it to quiz
		MultiChoiceQuestion multiChoiceQuestion = new MultiChoiceQuestion();
		multiChoiceQuestion.setText("Which of the people below have been presidents?");
		
		multiChoiceQuestion.addChoice("Donald Trump", true);
		multiChoiceQuestion.addChoice("Elon Musk", false);
		multiChoiceQuestion.addChoice("George Bush", true);
		multiChoiceQuestion.addChoice("Steve Jobs", false);
		quiz.add(multiChoiceQuestion);

		ChoiceQuestion question = new ChoiceQuestion();
		question.setText("What is 2+2");
		question.addChoice("2", false);
		question.addChoice("3", false);
		question.addChoice("4", true);
		question.addChoice("5", false);
		quiz.add(question);

		//create a new NumericQuestion question and add it to quiz
		quiz.add(new NumericQuestion("What is .5 * 3?", 1.5));
		//create a new FreeResponse question and add it to quiz
		quiz.add(new FreeResponse("Do you like jazz?"));		
	    return quiz;
	}
	
	/**
	 * display quiz questions and ask user to answer those questions
	 * @param quiz
	 */
	//step-5: add java code to complete this method
	public static void displayQuiz(ArrayList<Question> quiz) {
		Scanner input = new Scanner(System.in);
		int i = 1;
		//add a loop here to display each question in the quiz
		for(Question question : quiz) {
			System.out.println("Question #" + i);
			question.display();
			System.out.println("Question Type: " + question.getClass());
			String guess = input.nextLine();
			System.out.println(question.checkAnswer(guess));
			i++;
		}
		//get user answer from keyboard input
		//check user answer and display result (i.e., true or false, means answer is correct or not)
	}

}
