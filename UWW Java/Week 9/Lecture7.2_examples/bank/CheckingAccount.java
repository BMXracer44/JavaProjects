package bank;

public class CheckingAccount{  //step-2: extends as a subclass of BankAccount class
	
	private double maxWithDraw;  //has a withDraw limit when withdraw each time
	
    //constructor for setting up name and balance when creating a new bank account object (from a subclass)
    public CheckingAccount(String name, double balance) {
    	super(name, balance);
    	maxWithDraw =  500;  //default value for maximum withdraw limit $500  
    	System.out.printf("Create a checking account with a withdraw limit: $%.2f%n", maxWithDraw);
    }
    
    //setMaxWtihDraw method
    public void setMaxWithDraw(double max) {
    	maxWithDraw = max;
    }
    
    //getMaxWtihDraw method
    public double getMaxWithDraw() {
    	return maxWithDraw;
    }
    
    //override withdraw method in the BankAccount   
    public boolean withdraw(double amount) { //Step-3: Complete withdraw method
        if(amount > maxWithDraw){
            System.out.println("Can not withdraw. Over withdraw limit!");
            return false;
        }

        //call withdraw method in super class
        return super.withDraw(amount); //withdraw(amount) would call this method 

        /*
        if(balance > amount){
            balance -= amount;
            System.out.printf("withdraw: $%,.2f, current balance is: $%,.2f\n", amount, balance);
            return true;
        }
        else{
            System.out.println("Cannot withdraw, not enough balance");
            return false;
        }*/
    	
    }
    
    //override toString method in the BankAccount
    public String toString() {
    	String accountInfo = super.toString();
    	accountInfo +=  String.format("--- maxmum withdraw limit: $%.2f", getMaxWithDraw()); 
    	return accountInfo;
    }
    
}
