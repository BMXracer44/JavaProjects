import java.util.*;
import javax.swing.*;

public class Main{
    public static void main(String[] args){

        //Shopping cart lists all items user buys
        ArrayList<Item> shoppingCart = new ArrayList<>();
        double budget;
        Food food = new Food();
        Clothing clothing = new Clothing();
        Electronic electronic = new Electronic();

        //Sets up all the CSV files so the  program can add the products to inventory
        AddFile.initializeFile();
        
        //Intro statement
        JOptionPane.showMessageDialog(null, "Welcome to the grocery store manager!");

        //Ask for budget
        budget = Budget.setBudget();

        //Below statement asks user what department they want to shop in
        //And then calls the addToCart method to add items to the shopping cart
        Shop.shop(shoppingCart, electronic, clothing, food);

        Iterator<Item> iterator = shoppingCart.iterator();
        while(iterator.hasNext()) {
            Item item = iterator.next();
            if(item == null){
                iterator.remove();
            }
        }

        boolean goodPrice = false;

        while(!goodPrice){
            int totalPrice = 0;
            for (Item item : shoppingCart) {
                    totalPrice += Integer.parseInt(item.getPrice()) * Integer.parseInt(item.getStock());
            }

            //Prints out all items in the shopping cart
            Item.printRecipt(shoppingCart);
    
            if(totalPrice <= budget){
                double fee = Budget.paymentOption();
                System.out.printf("Total price: $%.2f", (totalPrice * fee));
                goodPrice = true;
            }
            else{
                System.out.println("You went overbudget. Please remove items from your cart and try again.\n");
                shoppingCart = Item.removeFromCart(shoppingCart);
            }
        }    
    }
}