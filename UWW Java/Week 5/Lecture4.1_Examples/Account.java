// Version-1: Account.java
// Account class that contains an name instance variable 
// and methods to set and get its value.

import java.text.DecimalFormat;

public class Account {
   private String name; // instance variable
   private double value; 
   //add instance variable (or property or attribute): balance
   
   
   //add a constructor, to provide customized initialization for a new account name and balance
   public Account(String name, double value){
      this.name = name;
      if(value > 0){
         this.value = value;
      } 
      else{
         this.value = 0;
      }
   }

   //Add another constructor without parameter (default)
   public Account(){
      this.name = "N/A"; //Customized default value for name
      this.value = 0; //Customized default value for value (Balance)
   }
   
   
   //add method: deposit() //i.e., set balance, instead of giving setBalance as the method name, "deposit" is a more proper name 
   public void deposit(double depositAmount) {
      if(depositAmount > 0){
         this.value = value + depositAmount;
      }
   }

   //add method: getBalance() //i.e., get balance
   public double getBalance() {
      return value;
   }
   
   // method to set the name in the object              
   public void setName(String name) { 
      this.name = name; // store the name
   }         
   
   
   // method to retrieve the name from the object
   public String getName() {
      return name; // return value of name to caller        
   }   
   
   // add method: toString()  //This is a common practice to convert account information into a string, which makes easy to print out account info.
   public String toString() {
	   DecimalFormat moneyFormat = new DecimalFormat("$###,###.##");
      //return a formatted string contains account info: name andn balance
	   return String.format("%-15s|%30s", this.name, moneyFormat.format(value));
   }
   
}

