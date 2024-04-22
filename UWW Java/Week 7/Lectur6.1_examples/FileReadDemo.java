
import java.io.*; //program uses class File and exception
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; //program uses class Scanner

import javax.swing.JOptionPane;

public class FileReadDemo{
	public static void main(String[] args) throws IOException {

      //Create a Scanner object for input file name
      Scanner keyboard = new Scanner(System.in);
      BufferedReader br = null;
      File newFile  = null;
      	  
	  //Get the file name
       System.out.print("Enter the filename: ");
       String filename = keyboard.nextLine();
       newFile = new File(filename);
	   br = new BufferedReader(new FileReader(filename));  //use file name string
    	   
      String st;
	  String[] personInfo = {"Name", "Phone", "Address", "Zip Code"};
	  ArrayList<String[]> personInfo2 = new ArrayList<String[]>();
     
	  while ((st = br.readLine()) != null){
		  String[] token = st.split(",");
		  
          System.out.println("\ndata line read in: " + st);
		  personInfo2.add(token);
		   
	       for (int i=0; i<token.length; i++)
		       System.out.println(personInfo[i] + ": " + token[i]);
		       
		  }
      System.out.printf("%-10s\t%-10s\t%-30s\t%-10s\n", "Name", "Phone", "Address", "Zip Code"); 
	  for (String[] s: personInfo2) {
		  System.out.printf("%-10s\t%-10s\t%-30s\t%-10s\n", s[0], s[1], s[2], s[3]);
	  }
      
      if (br !=null )
         br.close();
      
      keyboard.close();
	  System.out.println("\nData read from the file:" + newFile.getAbsolutePath());
   } //end of main


}//end of class


