

import java.util.Scanner;

public class FillInQuestion extends Question
{   
   //constructor 
   public FillInQuestion(String questionText, String correctResponse)
   {
      super.setText(questionText);
      setAnswer(correctResponse);
   }
   
   //add another constructor
   public FillInQuestion(String questionText)
   {
      setText(questionText);

   }
   
   /**
   Sets the question text.
   @param questionText the text of this question
  */
   @Override
	public void setText(String questionText)
	{
	   Scanner parser = new Scanner(questionText);
	   parser.useDelimiter("_");
	   String question = parser.next();
	   String answer = parser.next();
	   question = question + "____" + parser.next();
	
	   super.setText(question);
	   super.setAnswer(answer);
	}
}