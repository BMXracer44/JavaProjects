//use FileInputStream and Scanner objects to open file and read in data
//use FileInputStream to read streams of raw bytes of data from a file 
	import java.util.Scanner;
	import java.io.FileInputStream;
	import java.io.IOException;

	public class FileRead_FileInputStreamAndScannerEx {
	   public static void main(String[] args) throws IOException { //add a throws statement here to throw IOException to JVM to handle the exception
	      FileInputStream fileByteStream = null; // File input stream to read in data byte by byte
	      Scanner inFS = null;                   // Scanner object
	      int fileNum;                           // Data value from file

	      // Try to open file
	      System.out.println("Opening file myfile.txt.");
//common good practice: use relative path instead of absolute path to indicate the location of a file
//In Eclipse, the default data file location (without specifying file path) is the project folder      

	      fileByteStream = new FileInputStream("myfile.txt"); //will look for the text file in the project folder
	      inFS = new Scanner(fileByteStream); //use scanner object to read in data from file input stream
	 
	      // File is open and valid if we got this far (otherwise exception thrown)
	      System.out.println("Reading and printing numbers.");

	      while (inFS.hasNextInt()) { //use Scanner object methods such as hasNext(), hasNextLine(), hasNextInt() to find next data in the file
	      //the hasNextInt() method will return true if there are more data in the file, otherwise, return false	  
	         fileNum = inFS.nextInt();  //(2) what if we want to read in data as string?
	         
	         System.out.println("num: " + fileNum);
	      }

	      // Done with file, so try to close it
	      System.out.println("Closing file myfile.txt.");
	      fileByteStream.close(); // closes this file input stream and releases any system resources associated with the stream.
	      inFS.close(); //closes the Scanner object to avoid resource leaking
	      
	   }
	}

