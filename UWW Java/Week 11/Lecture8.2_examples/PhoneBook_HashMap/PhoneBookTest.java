package PhoneBook_HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PhoneBookTest {
	static String defaultFile = "sampleData.csv";
	public static void main(String[] args) throws IOException{  //for IOException thrown from BufferedReader 
		//Create a PhoneBook object instance
		PhoneBook myPhoneBook = new PhoneBook();
		
		//read in data from a file
		BufferedReader data_input = new BufferedReader(new FileReader(defaultFile));
                
        //read in data from the file
        String finput = "";
	    while ( (finput = data_input.readLine()) != null ) {
	        
	    	String[] tokens = finput.split(",");
	        String lname = tokens[0].trim();
	        String fname = tokens[1].trim();
	        String phone = tokens[2].trim();
	        
	        myPhoneBook.addPhone(new String[] {lname, fname}, phone);
	    }
	    data_input.close(); //close BufferedReader
        System.out.println("\nPhone List:");
        myPhoneBook.print();
        
        //prompt user to enter a person's name or the first few characters of a name
        //search phone book to find resident names and phone numbers
        Scanner keyboard = new Scanner(System.in);
        searchPhoneBook(keyboard, myPhoneBook);
        
	}
    public static void searchPhoneBook(Scanner keyboard, PhoneBook myPhoneBook){
    	//prompt user to enter a person's name or the first few characters of a name
        System.out.print("\nEnter a name to search: ");
        String searchKey = keyboard.next();
        HashMap<String[], String> result = myPhoneBook.searchPhone(searchKey);
        
        if (result.size() > 0) {
        	System.out.println("Find Customers:");
        	result.forEach((key, value) -> System.out.println(Arrays.toString(key)+": "+value));
        }
        else
        	System.out.printf("Did not find customer with name starts with \"%s\"", searchKey);    
    	
    }
    
}
