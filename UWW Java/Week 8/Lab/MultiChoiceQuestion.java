
/**
   A question with multiple choices and multiple correct answers.
*/
import java.util.ArrayList;
import java.util.Scanner;


public class MultiChoiceQuestion extends ChoiceQuestion
{
   private ArrayList<String> allAnswers;

   /**
     Constructs a choice question with no choices.
   */
   public MultiChoiceQuestion()
   {
      super();
      allAnswers = new ArrayList<String>();
   }

   /**
     Adds a correct answer for this question.
     @param correctResponse the answer to add
   */
   public void setAnswer(String correctResponse)
   {
      allAnswers.add(correctResponse);
   }

   /**
      Checks a given response for correctness.
      @param response the response to check
      @return true if the response was correct, false otherwise
   */
   public boolean checkAnswer(String response)
   {
      Scanner answers = new Scanner(response);
      // this is so that people don't enter the same answer multiple times
      ArrayList<String> correctAnswersSeen = new ArrayList<String>();
      int totalAnswers = 0;
      while (answers.hasNext())
      {
         String answer = answers.next();
         if (allAnswers.contains(answer)
            && !correctAnswersSeen.contains(answer))
         {
            correctAnswersSeen.add(answer);
         }
         totalAnswers++;
      }
      answers.close();
      return correctAnswersSeen.size() == allAnswers.size()
         && totalAnswers == allAnswers.size();
   }

   /**
      Displays the question with additional instructions for several correct answers.
   */
   public void display()
   {
      super.display();
      
      System.out.println("There are several correct answers, list all "
         + "of them separated by spaces.");
   }
   

}

