//A BufferedReader is another way for reading data from streams
//	It uses an internal buffer which allows it to read much larger streams (such as large files)
//	We prefer using a BufferedReader to a Scanner in almost every instance

//use BufferedReader, FileReader, and String or File objects to read in data
import java.io.*; //program uses class FileReader and exception
import java.util.ArrayList;

public class FileRead_BufferedReaderEx2{
	public static void main(String[] args) throws IOException {
//"files" folder is saved in "Week-5" project folder in Eclipse   
	String filename = "files/myfile3.csv";  //note csv file is just a text file that using comma (,) as delimiter to separate each data in the file
	
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
	   String[] personInfo = {"Name", "Phone", "Address", "Zip Code"};
	   ArrayList<String[]> personInfo2 = new ArrayList<String[]>();
	   while ((st = br.readLine()) != null){
		   String[] token = st.split(",");
		   personInfo2.add(token);
	       for (int i=0; i<token.length; i++)
		       System.out.println(personInfo[i] + ": " + token[i]);
	       
	  }
	  System.out.printf("%-10s\t%-10s\t%-30s\t%-10s\n", "Name", "Phone", "Address", "Zip Code"); 
	  for (String[] s: personInfo2) {
		  System.out.printf("%-10s\t%-10s\t%-30s\t%-10s\n", s[0], s[1], s[2], s[3]);
	  }
	  br.close();
	 System.out.println("\nData read from the file.");
   } //end of main

}//end of class


