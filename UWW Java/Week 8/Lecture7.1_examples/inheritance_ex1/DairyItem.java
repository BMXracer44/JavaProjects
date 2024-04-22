package inheritance_ex1;
import inheritance_ex1.ProduceItem;

public class DairyItem extends ProduceItem{ //DairyItem class is defined as a subclass of ProduceItem
    //apply variable hiding
    private int itemQuantity;
    private String itemName;

    private int percentageFat; //instance variable for DairyItem only 

    //add Contructor with one parameter
    public DairyItem(String itemName){
        super(); //super keyword is used to call super class constructor
        //because in super classes, only have default constructor, so we do not have to call the default constructor
        this.itemName = itemName;
        this.itemQuantity = 1;
    }
    //We will decide percentage fat and expiration date later

    //add getters and setters for percentageFat
    public void setPercentageFat(int percent){
        percentageFat = percent;
    }

    public int getPercentageFat(){
        return percentageFat;
    }

    //Override because quantity is set in GenericItem
    //Overriding method defined in GenericItem
    @Override
    public void setQuantity(int itemQuantity){
        if(itemQuantity >= 0){
            this.itemQuantity = itemQuantity;
        }
        else{
            this.itemQuantity = Math.abs(itemQuantity); 
        }
    }

    @Override
    public String toString(){
        return String.format("Dairy item\nName: %s\nQuantity: %s\nExpiration Date: %s\nPercentage Fat: %d\n", 
            itemName, itemQuantity, getExpiration(), percentageFat);
    }

}
