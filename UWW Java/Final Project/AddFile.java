import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddFile {
    public static void initializeFile(){
        //Initializes objects
        Food food = new Food();
        Clothing clothing = new Clothing();
        Electronic electronic = new Electronic();

        //Required for file reading and input
        String fileName = "FoodItems.csv";
        File file = new File(fileName);
        Scanner readFile = null;

        //Error should not occur if all files exist
        try {
            readFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the data file!");
        }        

        //Reads the entire data file to store every object
        while(readFile.hasNext()){
            String line = readFile.nextLine();
            String[] parts = line.split(",");

            food.addFood(parts[0], parts[1], parts[2]);   
        }    
        readFile.close();

        fileName = "ClothingItems.csv";
        file = new File(fileName);

        //Error should not occur if all files exist
        try {
            readFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the data file!");
        }  

        //Reads entire data file to store every object
        while(readFile.hasNext()){
            String line = readFile.nextLine();
            String[] parts = line.split(",");

            clothing.addClothing(parts[0], parts[1], parts[2]);
        }  
        readFile.close();

        fileName = "ElectronicItems.csv";
        file = new File(fileName);

        //Error should not occur if all files exist
        try {
            readFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the data file!");
        }  

        //Reads entire data file to store every object
        while(readFile.hasNext()){
            String line = readFile.nextLine();
            String[] parts = line.split(",");

            electronic.addElectronic(parts[0], parts[1], parts[2]);
        }  
        readFile.close();
    }
    
}
