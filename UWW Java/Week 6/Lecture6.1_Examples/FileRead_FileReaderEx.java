//Use FileReader to read in data

//FileReader is a convenience class for reading character files.
//The constructors of this class assume that the default character encoding
//and the default byte-buffer size are appropriate.
//
import java.io.*; //program uses class FileReader and exception
import java.util.Scanner; //program uses class Scanner

public class FileRead_FileReaderEx{
	public static void main(String[] args) throws IOException {

 // pass the path to the file as a parameter
    FileReader freader = new FileReader("files/filedemo.txt");

    int i;
    while ((i = freader.read()) != -1) 
      System.out.print((char) i);


// Close the file
	  freader.close();

	  System.out.println("\nData read from the file.");
   } //end of main

}//end of class


