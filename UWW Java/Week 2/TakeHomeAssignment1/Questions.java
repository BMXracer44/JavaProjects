package TakeHomeAssignment1;

import java.util.*;

public class Questions {

    //Initializes scanner which allows input
    Scanner input = new Scanner(System.in);

    //Initialized variable which hold my favorite items
    //Will be used towards the end to compare if we have anything in common
    String myFavoriteAlbum = "Eternal Atake";
    String myFavoriteArtist = "Lil Uzi Vert";
    int myFavoriteAlbumReleased = 2020;
    double myFavoriteAlbumRating = 4.7;
    long myAlbumUnits = 1860000;


    //Starts asking questions from the user
    public void AskQuestions(){
        System.out.println("Hello user!\nWelcome to the first take home assignment!\n");
        Ask();
    }

    //Validates string entry from the user
    //Will quit the program if the user doesn't enter anything or if the user enters a number
    public boolean ValidateString(String words){

        if(words.charAt(0)=='0' || words.charAt(0)=='1' || words.charAt(0)=='2' || words.charAt(0)=='3' || words.charAt(0)=='4' || words.charAt(0)=='5' || words.charAt(0)=='6' || words.charAt(0)=='7' || words.charAt(0)=='8' || words.charAt(0)=='9' || words.charAt(0)=='.' || words.charAt(0) == '-' || words.isEmpty()){
            System.out.print("Invalid response which is either empty or not a string. This results in an error. Goodbye! ");
            System.exit(0);
        }
        else{
            return true;
        }
        return false;
    }

    //Validates integer entry from the user
    //Will quit the program if the user doesn't enter anything or if the user enters a character
    public int ValidateInt(){
        String temp = input.nextLine();
        int num = 0;

        if(temp.isEmpty()){
            System.out.print("Invalid response which is either empty or not an integer. This results in an error. Goodbye! ");
            System.exit(0);  
        }
        else{
            try {
                num = Integer.parseInt(temp);
            } catch (Exception e) {
                System.out.print("Invalid response which is either empty or not an integer. This results in an error. Goodbye! ");
                System.exit(0); 
            }
        } 

        if(num < 0){
            System.out.println("Invalid number!");
            System.exit(0);            
        }

        return num;
    }

    //Will validate double entry from the user
    //Will quit the program if the user doesn't enter anything or enters a character
    public Double ValidateDouble(){
        String temp = input.nextLine();
        double num = 0;        
        
        if(temp.isEmpty()){
            System.out.print("Invalid response which is either empty or not an integer. This results in an error. Goodbye! ");
            System.exit(0);  
        }
        else{
            try {
                num = Double.parseDouble(temp);
            } catch (Exception e) {
                System.out.print("Invalid response which is either empty or not an integer. This results in an error. Goodbye! ");
                System.exit(0); 
            }
        } 

        if(num < 0){
            System.out.println("Invalid number!");
            System.exit(0);
        }        
                        
        return num;
    }
    
    //Will validate long entry from the user
    //Will quit the program if the user doesn't enter anything or enters a character    
    public Long ValidateLong(){
        String temp = input.nextLine();
        long num = 0;

        if(temp.isEmpty()){
            System.out.print("Invalid response which is either empty or not an integer. This results in an error. Goodbye! ");
            System.exit(0);  
        }
        else{
            try {
                num = Long.parseLong(temp);
            } catch (Exception e) {
                System.out.print("Invalid response which is either empty or not an integer. This results in an error. Goodbye! ");
                System.exit(0); 
            }
        } 

        if(num < 0){
            System.out.println("Invalid number!");
            System.exit(0);
        }

        return num;
    }

    //Will validate character entry from the user
    //Will quit the program if the user doesn't enter anything or enters a number or enters anything longer than a character    
    public Boolean ValidateBoolean(){
        String temp = input.nextLine();
        char answer = 'n';

        if(temp.isEmpty()){
            System.out.print("Invalid response which is either empty or not Y or N. This results in an error. Goodbye! ");
            System.exit(0);  
        }
        else{
            try {
                answer = temp.charAt(0);
            } catch (Exception e) {
                System.out.print("Invalid response which is either empty or not Y or N. This results in an error. Goodbye! ");
                System.exit(0); 
            }
        } 

        if(answer == 'y' || answer == 'Y'){
            return true;
        }
        else if(answer == 'n' || answer == 'N'){
            return false;
        }
        else{
                System.out.print("Invalid response which is either empty or not Y or N. This results in an error. Goodbye! ");
                System.exit(0);           
                return false;  
        }

    }

    //Asks all of the questions to be answered by the user and validates entries accordingly
    public void Ask(){
        System.out.print("What is your favorite album?\n\tEnter Title: ");

        String albumName = input.nextLine();
        if(albumName.isEmpty()){
            System.out.print("Invalid response which is either empty or not a string. This results in an error. Goodbye! ");
            System.exit(0);            
        }

        ValidateString(albumName);
    
        System.out.print("\nWhat is your favorite artist?\n\tEnter Artist: ");

        String artistName = input.nextLine();
        if(artistName.isEmpty()){
            System.out.print("Invalid response which is either empty or not a string. This results in an error. Goodbye! ");
            System.exit(0);            
        }

        ValidateString(artistName);

        System.out.print("\nWhat is the year your favorite album released?\n\tEnter Year: ");

        int year = ValidateInt();

        System.out.print("\nWhat is the rating of your favorite album?\n\tEnter rating: ");

        double rating = ValidateDouble();

        System.out.print("\nWhat is the units your favorite album sold?\n\tEnter units sold: ");

        long units = ValidateLong();

        System.out.print("\nDid you enjoy this short quiz?\n\tType Y for yes or N for no: ");

        Boolean enjoy = ValidateBoolean();

        //Prints to console the users information
        System.out.println("\nYour favorite album is " + albumName + ", favorite artist is " + artistName + ", year released: " + year + ", rating: " + rating + ", and units sold: " + units);

        //Prints to console my information
        System.out.println("\nMy favorite album is " + myFavoriteAlbum + ", favorite artist is " + myFavoriteArtist + ", year released: " + myFavoriteAlbumReleased + ", rating: " + myFavoriteAlbumRating + ", and units sold: " + myAlbumUnits + "\n");        



    //Prints to console if the user has anything in common with me    
    if (albumName.toLowerCase().equals(myFavoriteAlbum.toLowerCase())) {
        System.out.println("Both of our favorite albums are " + myFavoriteAlbum);
    }

    //Prints to console if the user has anything in common with me  
    if (artistName.toLowerCase().equals(myFavoriteArtist.toLowerCase())){
        System.out.println("Both of our favorite artists are " + myFavoriteArtist);
    }

    //Prints to console if the user has anything in common with me  
    if (year == myFavoriteAlbumReleased) {
        System.out.println("Both of our favorite albums were released in " + myFavoriteAlbumReleased);
    }

    //Prints to console if the user has anything in common with me  
    if (rating == myFavoriteAlbumRating){
        System.out.println("Both of our favorite albums had the same rating, " + myFavoriteAlbumRating + " stars!");
    }

    //Prints to console if the user has anything in common with me  
    if (units == myAlbumUnits){
        System.out.println("Both of our favorite albums sold " + myAlbumUnits + " units!");
    }

    //Prints to console if the user enjoyed using my program!  
    if (enjoy){
        System.out.println("I'm glad you enjoyed my program!");
    }

    }
}

