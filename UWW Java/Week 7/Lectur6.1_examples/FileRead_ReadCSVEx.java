//A BufferedReader is another way for reading data from streams
//	It uses an internal buffer which allows it to read much larger streams (such as large files)
//	We prefer using a BufferedReader to a Scanner in almost every instance

//use BufferedReader, FileReader, and String or File objects to read in data
import java.io.*; //program uses class FileReader and exception
import java.util.ArrayList;

public class FileRead_ReadCSVEx{
	public static void main(String[] args) throws IOException {
//"files" folder is saved in the project folder in Eclipse   
	String filename = "files/myfile3.csv";  //note csv file is just a text file that using comma (,) as delimiter to separate each data in the file
	BufferedReader br = new BufferedReader(new FileReader(filename));  //use file name string
	
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


