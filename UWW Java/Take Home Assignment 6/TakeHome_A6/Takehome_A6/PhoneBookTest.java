package Takehome_A6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Initializes class for the main method
public class PhoneBookTest {

    //Initializes the main method
	public static void main(String[] args) throws IOException{
		//Create a PhoneBook object instance
        PhoneBook phoneBook = new PhoneBook();

        //Creates scanner for user input
        Scanner input = new Scanner(System.in);

        //Creates blank file, scanner, and file name, which will eventually be filled in with user input
        String fileName = "";
        File file = null;
        Scanner readFile = null;
		
		//Get file name from user input 
        Boolean userInput = false;
        while(!userInput){

            //Prompts user for input of the file name
            System.out.print("Enter the name of a file you would like to open: ");
            fileName = input.next();
            file = new File(fileName);
            //Tries to find the file and catches the error if there is no file
            try {
                readFile = new Scanner(file);
                userInput = true;
            } catch (FileNotFoundException e) {
                //Tells the user it can't find the file and then prompts the user for the file name again
                System.out.println("Cannot find the sample data file! Try again!");
            }
        }           

        //read in data from the file
        while(readFile.hasNext()){
            //Reads each line and splits each name and phone number into 3 parts, then adds the contact and moves to the next line
            String line = readFile.nextLine();
            String[] parts = line.split(",");

            if(parts.length >= 3){
                phoneBook.addPhone(parts[1], parts[0], parts[2]);
            }
        }
        
        readFile.close();

        //print names and phone numbers from phone list of the PhoneBook object
		phoneBook.print();


        //prompt user to enter a person's name or the first few characters of a name
        //search phone book to find resident names and phone numbers
        Boolean quit = false;
        while(!quit){
            System.out.print("Would you like to search for a contact in the phone book? (Y for yes N for no): ");
            String continueSearch = input.next();
            if(continueSearch.equalsIgnoreCase("Y")){
                System.out.print("Enter a name or the first few characters of a name you would like to search in the phone book: ");
                String search = input.next();
                System.out.println("Find customers:");

                //Creates an array list for all customers that the user searched up
                ArrayList<ResidentPhone> findCustomers = new ArrayList<ResidentPhone>();
                findCustomers.addAll(phoneBook.searchPhone(search));

                for(ResidentPhone phone : findCustomers){
                    System.out.println(phone.getLastName() + ", " + phone.getFirstName() + ", " + phone.getPhoneNumber());
                }
                if(findCustomers.isEmpty()){
                    System.out.println("No customers found.");
                }
            }
            else{
                quit = true;
                input.close();
            }
        }  
        
	}  
   
}
