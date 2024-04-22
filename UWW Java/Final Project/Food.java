//Each CSV file is used to read products, price, and quantity in stock (in that order)

//Ansh will discuss this file

import java.util.*;

public class Food extends Item{ //Inherits from Item because each Food object is an Item

    //Stores all the electronic objects
    private static ArrayList <Item> foodList = new ArrayList<Item>();

    //Adds electronic objects to the list
    public void addFood(String foodName, String price, String stock){
        foodList.add(new Item(foodName, price, stock));
    }

    //Uses print statement in the item class
    public void print(){
        super.print(foodList);
    }

    public static Item shop(){
        return Item.addToCart(foodList);
    }

    @Override
    public void removeFromList(){
        foodList.remove(this);
    }


}
