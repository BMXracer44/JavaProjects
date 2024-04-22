package Assignment;

import java.util.*;
import javax.swing.*;

public class ESPGame {

    //Initializes the frame (Dialog/Output box)
    JFrame frame = new JFrame();

    //Initializes an array for the various colors 
    String[] color = { "Red", "Green", "Blue", "Yellow", "Purple"};

    //Initializes variables
    int compGuess = 0;
    int games = 0;
    int similar = 0;

    //Initiaizes array to count the number of times the user and the computer has guessed a specific color
    int[] colorCounter = new int[10];

    //Control varible initialized to tell the program when to quit
    Boolean quit = false;

    //Method to actually play the game
    public void playGame() {
        //Checks that the program is supposed to keep running
        while(!quit){
            //Checks user input by running method
            String userColor = UserInput();
            if(!"q".equals(userColor)){
                String computerColor = ComputerInput();
                //If user input and computer input are the same, it adds one to a varible that keeps track
                if(userColor.equals(computerColor)){
                    similar++;
                }
            }
            //If user input is q, program quits and conclusion statement executes
            else{
                System.out.println("\nYou have played " + games + " games!");
                System.out.println("You and the computer guessed the same color " + similar + " times!\n");
                Output(color, colorCounter);
            }
        }
    }

    //Computer input method
    //Chooses random number and searches the array for the corresponding color and uses that as an input
    private String ComputerInput() {
       compGuess = (int) (Math.random() * 5);

       System.out.println("The computer has selected " + color[compGuess].toLowerCase());
        switch(compGuess){
            case 0:
                colorCounter[1]++;
                break;
            case 1:
                colorCounter[3]++;
                break;    
            case 2:
                colorCounter[5]++;
                break;
            case 3:
                colorCounter[7]++;
                break;  
            case 4:
                colorCounter[9]++;
                break;                        
        } 
        return color[compGuess].substring(0,1).toLowerCase();
    }


    //User input method
    //Asks user to enter a letter in the input box and then adds a count to the counter array for the corresponding color input 
    private String UserInput(){
    String input = JOptionPane.showInputDialog(frame, "Enter color (r, g, b, y, p) or q to quit");
        switch(input.toLowerCase()){
            case "r":
                colorCounter[0]++;
                games++;
                break;
            case "g":
                colorCounter[2]++;
                games++;
                break;    
            case "b":
                colorCounter[4]++;
                games++;
                break;
            case "y":
                colorCounter[6]++;
                games++;
                break;  
            case "p":
                colorCounter[8]++;
                games++;
                break;    
            case "q":
                quit = true;
                break;
            default: 
                System.out.println("Invalid input!");
                System.exit(1);                                  
        }  
        return input.toLowerCase(); 
    }
    
    //Output method
    //Prints the color, the times the user entered a color, and the times the computer guessed a specific color
    public static void Output(String color[], int colorCounter[]){
        System.out.println("Color     User     Computer");
        for(int i = 0; i < 10;){
            for(int j = 0; j < 5; j++){
                System.out.printf("%-9s ", color[j]);
                System.out.printf("%3d ", colorCounter[i]);
                System.out.printf("%9d%n", colorCounter[i + 1]);
                i = i + 2;
            }
        }
        //Ends program
        System.exit(0);
    }
}

