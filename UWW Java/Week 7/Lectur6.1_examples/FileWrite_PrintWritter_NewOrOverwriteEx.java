//This example use PrintWriter to write data to a text file

import java.util.Scanner; // program uses class Scanner
import java.io.*; //program uses class PrintWriter

public class FileWrite_PrintWritter_NewOrOverwriteEx{
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

		  //Write the friend names to the file 
		  outputFile.println(friendName);
	  }
	  // Close the file, what if we do not close file?
      //outputFile.flush(); //push data to file
	  outputFile.close(); 
	  System.out.println("Data written to the file.");
   } //end of main

}//end of class


