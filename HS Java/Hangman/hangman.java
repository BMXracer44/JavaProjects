package Hangman;
import java.util.*;

public class hangman {
    public static void main(String[] args) {
        
        String[] phrasesList = new String[]{"speed i am speed", "may the force be with you", "houston we have a problem", "i have a feeling we aren't in kansas anymore", 
        "i dont have friends i got family", "i am groot", "i want to play a game", "you gonna eat your tots", "i have to return some videotapes", 
        "youre a wizard harry"};
        
        String currentPhrase;
        ArrayList<String> guesses = new ArrayList<String>();
        ArrayList<String> finalOutput = new ArrayList<String>();
        int lives = 0;

        currentPhrase = phrasesList[(int)(Math.random() * phrasesList.length)];
        System.out.println(currentPhrase);

        for(int i = 0; i < currentPhrase.length(); i++){
            if(currentPhrase.substring(i, i + 1).equals(" ")){
                System.out.print(" ");
            }
            else{
                System.out.print("_");
            }
        }
        System.out.println();
        //Prints out "_" for each letter and " " for each space
        //making it easy to read, then goes to the next line to get input
        
        

        while(!finalOutput.equals(currentPhrase)){
            System.out.print("Guess a single letter: ");
            Scanner input = new Scanner(System.in);
            guesses.add(input.nextLine());
            //Takes input and records it in guesses

            for(int i = 0; i < 7;){
                if(//letter in word, don't update i)
            }
            else{
                i++;
                System.out.println("Letter not in phrase");
            }

        }
      }
}

//if guess in list then update i with the letter 
//if guess in guesses then say no repeat guesses