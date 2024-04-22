import java.util.*;

import javax.swing.JOptionPane;

public class Shop {

    public static void shop(List<Item> shoppingCart, Electronic electronic, Clothing clothing, Food food){
        boolean quit = false;

        while(!quit){
            shoppingCart.add(chooseDepartment(electronic, clothing, food));     
            quit = validContinue();
        }
    }

    public static boolean validContinue(){
        
        int answer = JOptionPane.showConfirmDialog(null, "Would you like to continue shopping? (Y for yes/N for no): ", "Choice: ", JOptionPane.YES_NO_OPTION);

        if(answer == 1){
            //Sets quit equal to false which keep the program running
            return true;
        }
        else if(answer == 0){
            return false;
        }
        return true;   
    }

    //User chooses department and then chooseDepartment method calls the addToCart method
    public static Item chooseDepartment(Electronic electronic, Clothing clothing, Food food){

        String userInput = JOptionPane.showInputDialog("Would you like to shop for clothing, electronics, or food? (C for clothing, E for electronics, and F for food): ");
            
        //addToCart method in item class requires ArrayList of items to be sent in as a parameter
        if(userInput.equalsIgnoreCase("E")){
            electronic.print();
            return Electronic.shop();
        }
        else if(userInput.equalsIgnoreCase("C")){
            clothing.print();
            return Clothing.shop();
        }
        else if(userInput.equalsIgnoreCase("F")){
            food.print();
            return Food.shop();
        }
        else{
            System.out.println("Invalid input. Please try again.");
            chooseDepartment(electronic, clothing, food);
        }
        return null;
    }
}
