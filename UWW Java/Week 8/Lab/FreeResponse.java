

public class FreeResponse extends Question{

   public FreeResponse(String questionText)
   {
      setText(questionText);
   }
   
   @Override
   public boolean checkAnswer(String response)
   {
      setAnswer(response);
      return true;
   }
   
   
}
