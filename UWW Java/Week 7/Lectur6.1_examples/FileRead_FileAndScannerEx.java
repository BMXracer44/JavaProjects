//This example use File object and Scanner object to read in data

import java.io.*; //program uses class File and exception
import java.util.Scanner; //program uses class Scanner

public class FileRead_FileAndScannerEx{
	public static void main(String[] args) throws IOException {

      //Create a Scanner object for input file name
      Scanner keyboard = new Scanner(System.in);

      //Get the file name
      System.out.print("Enter the filename: ");
      String filename = keyboard.nextLine();

      //Open the file, must use File object here, NOT a string
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
     // inputFile.useDelimiter("\\s*,+\\s*");  //try to read in data from files/filedemo2.txt

	  //Read the next line
     while (inputFile.hasNext())
     {
		 //Read the next
		 String data = inputFile.next();

		 //Display the last name read
		 System.out.println(data);
	 }

	  // Close the file
	  inputFile.close(); //close scanner, also means close the file

	  System.out.println("Data read from the file:" + file.getAbsolutePath()); //file.getName(); 
   } //end of main

}//end of class


