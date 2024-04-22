package InheritanceProject;
import java.util.*;

public class Shop {
    private int storage;
    private ArrayList <Mountainbike> inventory;

    public Shop(){
        storage = 50;
        inventory = new ArrayList<Mountainbike>();
    }

    public void AddItem(Mountainbike mountainbike){
        if(inventory.size() < storage){
            inventory.add(mountainbike);
        }
    }

    public void DisplayInventory(){
        for(int i = 0; i < inventory.size(); i++){

            System.out.println(inventory.get(i).getName());
    }
}

    public Mountainbike GetBike(int index){
        return inventory.get(index);
    }
}