//Each CSV file is used to read products, price, and quantity in stock (in that order)

import java.util.*;

public class Clothing extends Item{ //Inherits from Item because each Clothing object is an Item

    //Stores all the clothing objects
    private static ArrayList <Item> clothingList = new ArrayList<Item>();

    //Adds clothing objects to the list
    public void addClothing(String clothingName, String price, String stock){
        clothingList.add(new Item(clothingName, price, stock));
    }

    //Uses print statement in the item class
    public void print(){
        super.print(clothingList);
    } 

    //Uses shop method in the item class
    public static Item shop(){
        return Item.addToCart(clothingList);
    }

    @Override
    public void removeFromList(){
        clothingList.remove(this);
    }


}
