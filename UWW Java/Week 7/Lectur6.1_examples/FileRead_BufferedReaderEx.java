//A BufferedReader is another way for reading data from streams
//	It uses an internal buffer which allows it to read much larger streams (such as large files)
//	We prefer using a BufferedReader to a Scanner in almost every instance

//use BufferedReader, FileReader, and String or File objects to read in data
import java.io.*; //program uses class FileReader and exception

public class FileRead_BufferedReaderEx{
	public static void main(String[] args) throws IOException {

	// Create a file object or use a string to specify the path and file name
	  // File file = new File("files/filedemo.txt");
	   
		String filename = "files/filedemo.txt";
	
	 //	A BufferedReader requests a Reader instance in its constructor
	 //	The FileReader class is a Reader and is a perfect fit for this application
	 //	Since we don't need the FileReader outside of the BufferedReader, 
	 // just instantiate a new one to pass as an argument
		
	 //  BufferedReader br = new BufferedReader(new FileReader(file)); //use File object 
		
	   BufferedReader br = new BufferedReader(new FileReader(filename));  //use file name string
	
/* Note: There is no hasNextLine() method for BufferedReader
 * But readLine() will return null when there is no line to read
 * We want to loops so long as there are more lines to read
 * To phrase it another way, loop while the line we read was not null
 * But we have to store this result somehow...
 * The solution: an assignment expression in Java (i.e. someVariable = someExpression) returns the value of the expression
 * So, the expression (a = b) will return the value of a AFTER the assignment is performed
 * Here, we set 'st' equal to the result of readLine()
 * If the expression of that assignment is not null, keep looping  
 *  
 *  */
	   String st;
	   while ((st = br.readLine()) != null){
	     System.out.println(st);
	  }
	   br.close();
	 System.out.println("\nData read from the file.");
   } //end of main

}//end of class


