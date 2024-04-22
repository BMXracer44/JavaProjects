//Week-3 Lecture 3.1 Example, FileAppendDemo.java

import java.io.*; //program uses class PrintWriter

public class FileAppendDemo{
	public static void main(String[] args) throws IOException {

      //Open the file
      FileWriter fwriter = new FileWriter("files/filedemo.txt", true);
      PrintWriter outputFile = new PrintWriter(fwriter);

      outputFile.print(true);
      outputFile.print(123);
      outputFile.println(123.45);
      outputFile.println("name");
      outputFile.printf("Text + data: $%d", 666);
	  // Close the file
	  outputFile.close();
	  fwriter.close();
	  System.out.println("Data append to the file.");
   } //end of main

}//end of class


