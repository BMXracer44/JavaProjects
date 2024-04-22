package Assignment;

//Imports needed tools for the program to work properly
import java.text.DecimalFormat;
import java.util.*;

//Initializes the class and the variables for the program
public class Order {   
   Scanner input = new Scanner(System.in);      
   private int orderID;  
   private int foodQuantity; 
   private String foodItem;
   private int sideQuantity;
   private String sideItem;
   private int drinkQuantity;
   private String drinkItem;
   static ArrayList<Order> orderList = new ArrayList<>();  
   static double[] foodPrices = {4.99, 5.99, 6.99};
   static double[] sidePrices = {3.99, 2.99, 4.99};
   static double[] drinkPrices = {2.99, .99, 3.99}; 
   static double totalPrice;     


   //Creates order object
   public Order(int orderID, int foodQuantity, String foodItem,  int sideQuantity, String sideItem, int drinkQuantity, String drinkItem){
      this.orderID = orderID;
      this.foodQuantity = foodQuantity;
      this.foodItem = foodItem;
      this.sideQuantity = sideQuantity;
      this.sideItem = sideItem;
      this.drinkQuantity = drinkQuantity;
      this.drinkItem = drinkItem;
   }

   //Calculates total price for all the orders combined 
   public static double totalPrice(String choice, int quantity){

      if(choice.equals("Chicken")){
         totalPrice += quantity * Order.foodPrices[0];
      }
      else if(choice.equals("Beef")){
         totalPrice += quantity * Order.foodPrices[1];
      }
      else if (choice.equals("Seafood")){
         totalPrice += quantity * Order.foodPrices[2];
      }
        
      if(choice.equals("Fries")){
         totalPrice += quantity * Order.sidePrices[0];
     }
     else if(choice.equals("Salad")){
         totalPrice += quantity * Order.sidePrices[1];
     }
     else if (choice.equals("Mashed Potatoes")){
         totalPrice += quantity * Order.sidePrices[2];
     }

     if(choice.equals("Soda")){
         totalPrice += quantity * Order.drinkPrices[0];
      }
      else if(choice.equals("Water")){
         totalPrice += quantity * Order.drinkPrices[1];
      }
      else if(choice.equals("Coffee")){
         totalPrice += quantity * Order.drinkPrices[2];
      }

      return totalPrice;
   }

   //Returns the tax for all the orders
   public static double getTax(){
      return totalPrice * .05;
   }

   //Calculates the final total price with tax
   public static double finalTotal(){
      return (totalPrice + getTax());
   }

   //Next few lines are getter and setter methods for each object
   public int getOrderID() {
      return orderID;
   }
                   
   public void setOrderID(int orderID) { 
      this.orderID = orderID; 
   }  
     
   public int getFoodQuantity() {
      return foodQuantity;
   }
              
   public void setFoodQuantity(int foodQuantity) { 
      this.foodQuantity = foodQuantity; 
   } 

   public String getFoodItem() {
      return foodItem;
   }
                   
   public void setFoodItem(String foodItem) {  
      this.foodItem = foodItem; 
   }  
     
   public int getSideQuantity() {
      return sideQuantity;
   }
              
   public void setSideQuantity(int sideQuantity) { 
      this.sideQuantity = sideQuantity; 
   }      

   public String getSideItem() {
      return sideItem;
   }
              
   public void setSideItem(String sideItem) { 
      this.sideItem = sideItem; 
   }     

   public int getDrinkQuantity() {
      return drinkQuantity;
   }
              
   public void setDrinkQuantity(int drinkQuantity) { 
      this.drinkQuantity = drinkQuantity; 
   }   
     
   public String getDrinkItem() {
      return drinkItem;
   }
              
   public void setDrinkItem(String drinkItem) { 
      this.drinkItem = drinkItem; 
   }     

   //Prints the orders and the total price to the console for the user to see 
   public static void printOrders(ArrayList<Order> orders){
      DecimalFormat moneyFormat = new DecimalFormat("$###.##");
      //Sorts through all the orders in the order list and uses getters to print each order
      for(Order a : orders){
         System.out.print("\n" + a.getOrderID() + ":\n" );    
         if(a.getFoodQuantity() > 0){
            System.out.print(a.getFoodQuantity() + " " + a.getFoodItem() + "\n");
         }
         if(a.getSideQuantity() > 0){
            System.out.print(a.getSideQuantity() + " " + a.getSideItem() + "\n");
         }    
         if(a.getDrinkQuantity() > 0){
            System.out.print(a.getDrinkQuantity() + " " + a.getDrinkItem() + "\n");
         }
      } 
      //Prints the the final price, tax, and total to the console for the user to see
      System.out.println("Price: " + moneyFormat.format(Order.totalPrice) + "\n" + "Tax: " + moneyFormat.format(Order.getTax()) + "\n" + "Total: " + moneyFormat.format(Order.finalTotal()));  
                   
   }    
}
