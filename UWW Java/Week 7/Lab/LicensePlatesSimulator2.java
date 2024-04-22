//Imports items neccessary for the program to run as intended
import java.io.*;
import java.util.*;

//Declares class
public class LicensePlatesSimulator2{

    //Declares main class
    public static void main(String[] args) throws IOException{
        //Write a Java Application to generate 100 regular automobile license plates
        //by using random generator, and then save them to a text file (.txt) named "license_plates".
        Random rGenerator = new Random();

        //define a ArrayList of Strings to store the licensePlates
        ArrayList<String> plates = getRandomPlates(rGenerator,100);

        //output to a text file
        String filename = "license_plates.txt";
        File file = new File(filename);
        PrintWriter outputFile = new PrintWriter(new FileWriter(file, false));
        for (String p: plates) {
            outputFile.println(p);
        }

        System.out.println("Data is saved to " + file.getAbsolutePath());

        //Outputs 50 more licence plates to the file
        ArrayList<String> morePlates = getRandomPlates(rGenerator, 50);
        for (String p: morePlates) {
            outputFile.println(p);
        }
        
        //Creates scanner which will help us read the file
        Scanner readFile = new Scanner(file);
        
        //Closes file and saves the data to it
        outputFile.close();

        //Reads file and prints out all the licence plates
        while(readFile.hasNext()){
            String line = readFile.next();
            System.out.println(line);
        }
        System.out.println("Data read from " + file.getAbsolutePath());
        readFile.close();
    }

    //Method to get a random plate using the random generator
    public static ArrayList<String> getRandomPlates(Random rGenerator, int numR) {

        ArrayList<String> plates = new ArrayList<String>();

        //Creates positions for the number and letters for each plate
        String p1="", p2="";

        //Creates new license plates with random letters and numbers
        for (int i = 0; i < numR; i++) {
            p1 = getRandom(rGenerator, 65, 90, 3); //'A'-'Z'
            p2 = getRandom(rGenerator, 48, 57, 4); //'0'-'9'
            plates.add(p1 + "-" + p2);
        }

        return plates;
    }

    //Method for getting a random part for the license plates
    public static String getRandom(Random rGenerator, int min, int max, int numR) {
        char random;
        String randomPart = "";
        for (int i = 0; i < numR; i++) {

            random = (char)(rGenerator.nextInt(max - min + 1) + min);
            randomPart+= random;
        }
        return randomPart;
    }
}