package Assignment;

//Imports needed tools for program to execute
import java.util.*;

//Declares class name and initializes variables and scanner 
public class OrderTest {
    static Scanner input = new Scanner(System.in);
    static int foodQuantity; 
    static int sideQuantity;
    static int drinkQuantity;
    static int orderID = 1;
    static Boolean quit = false; 

    //Initializes main method
    public static void main(String[] args){       
        //This variable I is used to keep track of the OrderID for each order;     
        int i = 1;

        //While loop decides whether or not the program continues to run or stops
        while(!quit){
            MakeOrder(i);
            //Increases OrderID each time the program loops through
            i++;
        }

        //Prints the orders to the console
        Order.printOrders(Order.orderList);
    }    

    //Method used to declare the object called order
    public static void MakeOrder(int orderID){ 
        //Declares default variables incase user does not want to order a specific dish with each order
        String foodChoice = "None";
        String sideChoice = "None";
        String drinkChoice = "None";
        int foodQuantity = 0;
        int sideQuantity = 0;
        int drinkQuantity = 0;

        //Asks if user would like a main dish
        //If user wants a main dish, then it will ask what kind of dish and how many
        System.out.print("Would you like a main dish with this order? (Y for yes, N for no): ");
        if(boolValidation()){
            System.out.print("\nEnter your food choice:\n(Enter C for chicken ($4.99), B for beef ($5.99), or S for seafood ($6.99): ");
            foodChoice = foodValidation();
    
            System.out.print("\nEnter your food quantity: ");
            foodQuantity = intValidation();

            //Helps calculate total price for the order
            Order.totalPrice(foodChoice, foodQuantity);
        }  

        //Asks if user would like a side dish
        //If user wants a dish dish, then it will ask what kind of dish and how many        
        System.out.print("\nWould you like a side dish with this order? (Y for yes, N for no): ");   
        if(boolValidation()){
            System.out.print("\nEnter your side choice:\n(Enter F for Fries ($3.99), S for salad ($2.99), or M for mashed potatoes ($4.99): ");
            sideChoice = sideValidation();
    
            System.out.print("\nEnter your side quantity: ");
            sideQuantity = intValidation(); 

            //Helps calculate total price for the order
            Order.totalPrice(sideChoice, sideQuantity);
        }     


        //Asks if user would like a drink
        //If user wants a drink, then it will ask what kind of drink and how many        
        System.out.print("\nWould you like a drink with this order? (Y for yes, N for no): "); 
        if(boolValidation()){
            System.out.print("\nEnter your drink choice:\n(Enter S for soda ($2.99), W for water ($0.99), or C for coffee ($3.99): ");
            drinkChoice = drinkValidation();   
                
            System.out.print("\nEnter your drink quantity: ");
            drinkQuantity = intValidation();

            //Helps calculate the total price for the order
            Order.totalPrice(drinkChoice, drinkQuantity);
        }   
    
        //Creates order object
        Order order = new Order(orderID, foodQuantity, foodChoice, sideQuantity, sideChoice, drinkQuantity, drinkChoice);
        //Adds order object to a list
        Order.orderList.add(order);

        //Calls quit method to see if the user is done with the program or not
        quit();
    }

        //Sees if the user enter the correct variable and asks the user to re-input the variable if entered incorrectly
        public static int intValidation(){
            String test = input.nextLine();

            //Checks to see if the user entered a variable greater than 0 
            if(Integer.parseInt(test) < 1){
                System.out.println("Invalid input. Try again: ");
                return intValidation();                
            }
            try {
                return Integer.parseInt(test);
            } catch (Exception e) {
                System.out.println("Invalid input. Try again: ");
                return intValidation();
            }
        }

        //Sees if the user enter the correct variable and asks the user to re-input the variable if entered incorrectly
        public static Boolean boolValidation(){
            String test = input.nextLine();
            if(test.equalsIgnoreCase("y")){
                return true;
            }
            else if(test.equalsIgnoreCase("n")){
                return false;
            }
            else{
                System.out.print("\nInvalid input. Try again: ");
                return boolValidation();
            }
            
        }
    
        //Sees if the user enter the correct variable and asks the user to re-input the variable if entered incorrectly        
        public static String foodValidation(){
            String test = input.nextLine();
    
            switch(test.toLowerCase()){
                case "c":
                    return "Chicken";
                
                case "b":
                    return "Beef";
    
                case "s":
                    return "Seafood";
                default:
                    System.out.println("Invalid input. Try again: ");
                    return foodValidation();
            }
        }
 
        //Sees if the user enter the correct variable and asks the user to re-input the variable if entered incorrectly        
        public static String sideValidation(){
            String test = input.nextLine();
    
            switch(test.toLowerCase()){
                case "f":
                    return "Fries";
                
                case "s":
                    return "Salad";
    
                case "m":
                    return "Mashed Potatoes";
                default:
                    System.out.println("Invalid input. Try again: ");
                    return sideValidation();
            }
        }
    
        //Sees if the user enter the correct variable and asks the user to re-input the variable if entered incorrectly        
        public static String drinkValidation(){
            String test = input.nextLine();
    
            switch(test.toLowerCase()){
                case "s":
                    return "Soda";
                
                case "w":
                    return "Water";
    
                case "c":
                    return "Coffee";
                default:
                    System.out.println("Invalid input. Try again: ");
                    return drinkValidation();
            }
        }     

        //Asks the user if they would like to quit the program or add another order
        public static void quit(){
            System.out.print("\nWould you like to add another order? Y for yes, N for no: ");
            if(!boolValidation()){
                quit = true;
            }
        }     

    }
