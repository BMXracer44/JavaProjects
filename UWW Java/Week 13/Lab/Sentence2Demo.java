/**
   A tester class for Sentence.
*/
public class Sentence2Demo
{
   public static void main(String[] args)
   {
      Sentence2 s = new Sentence2("Mississippi!");
   
      int n = s.findv2("sip");
      System.out.println(n);
      System.out.println("Expected: 6");      
      
      n = s.findv2("tip");
      System.out.println(n);
      System.out.println("Expected: -1");
	  
	  //add two more testing cases 
	  //(one case return a positive index, another case return -1)

      n = s.findv2("Mss");
      System.out.println(n);
      System.out.println("Expected: -1");

      n = s.findv2("iss");
      System.out.println(n);
      System.out.println("Expected: 1");
	  
   }
}

/**
   class Sentence2
*/
class Sentence2
{
   private String phrase;

   /**
      Construct a Sentence object.
      @param aPhrase the sentence
   */
   public Sentence2(String aPhrase)
   {
      phrase = aPhrase;
   }
   
   /**
      Finds a string of text in a sentence.
      @param text the string to find.
      @return the position where the text is found

   */
   public int findv2(String text)
   {
      return find(text, 0);
   }
   
   /**
      Helper method to find the index of a string.
      @param text the string to find
      @param index the starting index to search
      @return the position where the text is found
   */
   private int find(String text, int index)
   {
      if(index + text.length() >= phrase.length()){
         return -1;
      } 
      else if(phrase.substring(index, index + text.length()).equals(text)){
         return index;
      }
      else{
         return find(text, index + 1);
      }
	   
   }
}

