import java.util.*;

public class Item {
    private String name;
    private String price;
    private String stock;

    public Item(){
        name = null;
        price = null;
        stock = null;
    }

    public Item(String name, String price, String stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }

    public String getStock(){
        return stock;
    }

    public void removeFromList(){
        //implemented in child classes
    }

    public void setStock(String change){
        stock = Integer.toString((Integer.parseInt(stock) - Integer.parseInt(change)));
        if(Integer.parseInt(stock) == 0){
            removeFromList();
        }
    }

    public String print(Item item){
        return (item.getName() + ", $" + item.getPrice() + " each, " + item.getStock() + " in stock\n");
    }

    public static void print(ArrayList<Item> items){
        for(Item item : items){
            System.out.println(item.getName() + ", $" + item.getPrice() + " each, " + item.getStock() + " in stock\n");
        }
    }

    public static void printRecipt(ArrayList<Item> items){
        System.out.println("----------------------------------");
        for(Item item : items){
            if(item != null){
                System.out.println(item.getStock() + " " + item.getName() + "\t $" + (Integer.parseInt(item.getPrice()) * Integer.parseInt(item.getStock())));
            }
        }
        System.out.println("----------------------------------");
    }


    //adds items to cart
    public static Item addToCart(ArrayList<Item> items){
        String addCart = "";
        boolean found = false;
        int quantityInt = 0;

        Scanner input = new Scanner(System.in);
        
        System.out.println("What product would you like to buy: ");
        addCart = input.nextLine().trim();

        //Loops through every item in inventory
        for(Item item : items){
            //Checks if the item exists in the inventory
            if(item.getName().equalsIgnoreCase(addCart)){
                found = true;
                System.out.println("How many of these items would you like to add?");
                String quantity = input.nextLine();
                try {
                    quantityInt = Integer.parseInt(quantity);
                    if(quantityInt <= 0){
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity!");
                    quantityInt = 0;
                }
                //Checks that there is enough in quantity
                //E.g if the quantity is 10 and we only have 5 in stock, it would return null
                if(quantityInt > Integer.parseInt(item.getStock())){
                    System.out.println("There is not enough products in stock!");
                    return null;
                }
                else if (quantityInt == 0){
                    return null;
                }

                //setStock method works because it is defined with a String parameter and 
                //parses the String inside the method
                item.setStock(Integer.toString(quantityInt));
                return new Item(item.getName(), item.getPrice(), Integer.toString(quantityInt));
            }
        } 

        if(!found){
            System.out.println(addCart + " not found in inventory!");
        }
        return null;    
    }

    public static ArrayList<Item> removeFromCart(ArrayList<Item> items){
        Scanner input = new Scanner(System.in);
        int i = 1;
        int remove = 0;
        int removeStock = 0;

        for (Item item : items) {
            if(item == null){
                items.remove(item);
            }
        }

        for (Item item : items) {
            System.out.print(i + " ");
            System.out.println(item.print(item));
            i++;
        }

        System.out.println("Which items would you like to remove from your cart? (1-" + (i - 1) + ")");
        String temp = input.nextLine();
        try {
            //Remove variable selects the item to be removed (index)
            remove = Integer.parseInt(temp) - 1;
            if(remove < 0 || remove > i - 1){
                throw new NumberFormatException();
            }
        } catch (Exception e) {
            System.out.println("Invalid item!");
            removeFromCart(items);
        }

        System.out.println("How many of these items would you like to remove? (1-" + items.get(remove).getStock() + ")");
        temp = input.nextLine();

        try {
            //RemoveStock variable selects the quantity of items
            removeStock = Integer.parseInt(temp);
            if(removeStock < 0 || removeStock > Integer.parseInt(items.get(remove).getStock())){
                throw new NumberFormatException();
            }
        } catch (Exception e) {
            System.out.println("Invalid quantity!");
            removeFromCart(items);
        }
        
        if(removeStock == Integer.parseInt(items.get(remove).getStock())){
            items.remove(remove);
        } 
        else{
            items.get(remove).setStock(Integer.toString(removeStock));
        }

        return items;

    }
}
