//Each CSV file is used to read products, price, and quantity in stock (in that order)

//Ansh will discuss this file

import java.util.*;

public class Electronic extends Item{ //Inherits from Item because each Electronic object is an Item
    
    //Stores all the electronic objects
    private static ArrayList <Item> electronicList = new ArrayList<Item>();

    //Adds electronic objects to the list
    public void addElectronic(String electronicName, String price, String stock){
        electronicList.add(new Item(electronicName, price, stock));
    }

    //Uses print statement in the item class
    public void print(){
        super.print(electronicList);
    }

    public static Item shop(){
        return Item.addToCart(electronicList);
    }

    @Override
    public void removeFromList(){
        electronicList.remove(this);
    }

}
