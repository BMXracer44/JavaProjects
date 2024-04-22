//Imports things required to help the project run properly
import java.util.*;

//Class the initializes the object and and validates the guesses
public class ComboLockTest {
    //Initializes variables needed for the user to guess the combination
    private static int guess1;
    private static int guess2;
    private static int guess3;
    private static String spin1 = "";
    private static String spin2 = "";
    private static String spin3 = ""; 
    
    static Random rand = new Random();
    private static int secret1 = rand.nextInt(40); 
    private static int secret2 = rand.nextInt(40); 
    private static int secret3 = rand.nextInt(40); 

    //Creates the lock object
    static ComboLock lock = new ComboLock(secret1, secret2, secret3); 
          
    static Scanner input = new Scanner(System.in);
    static boolean quit = false;  

    //Main method creates the guess for the user
    public static void main(String[] args){
        //Introduction statement
        System.out.println("Welcome to the lock picking test!");
        System.out.println("In order to pick the lock, you need to turn right to the first number, left to the second number, and then right to the third number.");
        
        //While loop controls how long the program keeps running
        while(!quit){

            //Asks for guesses from the user
            guess1 = numberGuess();
            spin1 = stringGuess();

            guess2 = numberGuess();
            spin2 = stringGuess();

            guess3 = numberGuess();
            spin3 = stringGuess();

            //Inputs the guesses to see if the user was correct
            spin(spin1, guess1);
            spin(spin2, guess2);
            spin(spin3, guess3); 
            
            //Checks to see if the user has opened the lock and responds properly
            if(ComboLock.open()){
                quit = true;
            }
            else{
                System.out.println("You did not open the lock.");
                System.out.println("Would you like to try again? Y for yes, N for no: ");
                String cont = input.next();
                if(cont.equalsIgnoreCase("n")){
                    quit = true;
                    break;
                }
                else if(cont.equalsIgnoreCase("y")){
                    ComboLock.reset();
                }
            }    
        }
        if(ComboLock.open()){
            System.out.println("Congragulations! You opened the lock!");
            System.exit(0);
        }
        else{
            //Exit statement
            System.out.println("Sorry, but you did not open the lock.");
            System.out.println("The combo was " + secret1 + ", " + secret2 + ", " + secret3);
            System.exit(0);
        }
        

    }   

    //Method used to check if the user input is valid
    //Checks to see that user input is greater than 0 and less than 40
    //If user input is invalid, it asks the user to input the value again
    public static int numberGuess(){
        System.out.print("\nWhat is the guess of your spin (Between 0 and 39): ");
        try {
            int guess = Integer.parseInt(input.next());
            if(guess > 40 || guess < 0){
                throw new NumberFormatException();
            }
            return guess;
        } catch (Exception NumberFormatException) {
            System.out.println("Invalid number. Guess again!");
            return numberGuess();
        }
    }  
    
    //Method used to check if the user input is valid
    //Checks to see that the user input is either R or L 
    //If input is invalid, it asks the user to reenter the input
    public static String stringGuess(){
        System.out.print("\nWhat direction will you turn the dial (Type R for right or L for left): ");
        String spin = input.next();        
        if(spin.equalsIgnoreCase("R")){
            return "r";
        }
        else if(spin.equalsIgnoreCase("L")){
            return "l";
        }   
        else{
            System.out.println("Invalid direction. Try again!");
            return stringGuess();
        }
    }  
    
    //Spins the lock to see if the lock has been opened
    public static void spin(String spin, int guess){
        if(spin.equalsIgnoreCase("r")){
            ComboLock.turnRight(guess);
        }
        else{
            ComboLock.turnLeft(guess);
        }        
    }
}   
