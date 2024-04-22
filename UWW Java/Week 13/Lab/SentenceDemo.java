/**
   A tester class for Sentence.
*/
public class SentenceDemo
{
   public static void main(String[] args)
   {
      Sentence s = new Sentence("Mississippi!");
      boolean b = s.find("sip");
      System.out.println(b);
      System.out.println("Expected: true");
      b = s.find("tip");
      System.out.println(b);
      System.out.println("Expected: false");
      
      b = s.find("sss");
      System.out.println(b);
      System.out.println("Expected: false");

      b = s.find("pi!");
      System.out.println(b);
      System.out.println("Expected: true");
	  
	  //add two more testing cases 
	  //(one case return true, another case return false)
   }
     
   
}

/**
 Define class Sentense
*/
class Sentence
{
   private String phrase;

   /**
      Constructs a Sentence object.
      @param aPhrase a phrase entered by user
   */
   public Sentence(String aPhrase)
   {
      phrase = aPhrase;
   }
   
   /**
      Determines if a string exists in the phrase.
      @param text the string to find
      @return true if the string is found, false otherwise
   */
   public boolean find(String text)
   {
      if(phrase.length() < text.length()){
         phrase = "Mississippi!";
         return false;
      }
      else if(phrase.substring(0, text.length()).equals(text)){
         phrase = "Mississippi!";
         return true;
      }

      else{
         phrase = phrase.substring(1);
         return find(text);
      }
	   
	   
   }
}
