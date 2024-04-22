
//Use java.util.Random class to generate random numbers
//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html
import java.util.Random; //program uses class Random
import java.util.Scanner; //program uses class Scanner

public class RollDiceEx1{
	public static void main(String[] args){

		String again = "y";
		int die1;
		int die2;

   //Create a Scanner object to read keyboard input
   Scanner keyboard = new Scanner(System.in);

   //Create a Random object to generate random numbers
   Random rand = new Random();   //default behavior depends on JRE 
   long seed1 = 3;  //set a static seed, the same long integer value for each run
   rand.setSeed(seed1); //we will see the same sequence of random numbers generated for each run
   long seed2 = System.currentTimeMillis(); //set a dynamic seed, different integer value for each run
   rand.setSeed(seed2); //we will see the different sequences of random numbers generated for each run 
   
   //Simulate rolling the dice
	   while(again.equalsIgnoreCase("y"))
	   {
		   System.out.println("Rolling the dice ...");
		   die1 = rand.nextInt(6) + 1;
		   die2 = rand.nextInt(6) + 1;
		   System.out.println("Their values are: " + die1 + ", and " + die2);

		   System.out.println("Roll them again (y=yes)? ");
		   again = keyboard.nextLine();

	   }
	   keyboard.close();
   }//end of main

}//end of class


