//FileWriteDemo2.java

import java.util.Scanner; // program uses class Scanner
import java.io.*; //program uses class PrintWriter

public class FileWrite_FileWriter_AppendData_Ex {
	public static void main(String[] args) throws IOException {
      String filename;
      String friendName;
      int numFriends;

      //create a Scanner object for keyboard input
      Scanner keyboard = new Scanner(System.in);

      //get the number of friends.
      System.out.print("How many friends do you have? ");
      numFriends = keyboard.nextInt();

      //Consume the remaining newline character.
      keyboard.nextLine();

      //Get the file name
      System.out.print("Enter the filename: ");
      filename = keyboard.nextLine();

      //Open the file
      PrintWriter outputFile = new PrintWriter(filename);
 
      //Get data and write it to the file
      for (int i = 1; i<= numFriends; i++)
      {
		  //Get the name of a friend.
		  System.out.print("Enter the name of friend " + "number " + i + ": ");
		  friendName = keyboard.nextLine();

		  //Write the name to the file
		  outputFile.println(friendName);
	  }
	  // Close the file, 
      outputFile.close();
     
      //add 2nd part, to append data to the same file
      //use FileWriter object to special append mode
      FileWriter newWriter = new FileWriter(filename, true);
      PrintWriter outputFile2 = new PrintWriter(newWriter);
      int friendAge =0;
      for (int i = 1; i<= numFriends; i++)
      {
		  //Get the name of a friend.
		  System.out.print("Enter the age of friend " + "number " + i + ": ");
		  friendAge = keyboard.nextInt();

		  //Write the name to the file
		  outputFile2.println(friendAge);
	  }
      
	  System.out.println("Data written to the file.");
	  outputFile2.close();
	  
	  keyboard.close();
   } //end of main

}//end of class


