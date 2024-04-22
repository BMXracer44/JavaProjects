package bank2;

public class CheckingAccount extends BankAccount implements Transfer, Payable{ //step-3: add implements Transfer and Payable interfaces  
	
	private double maxWithDraw;  //has a withDraw limit when withdraw each time
	
    //constructor for setting up name and balance when creating a new bank account object (from a subclass)
    public CheckingAccount(String name, double balance) {
    	super(name, balance);  //call BankAccount constructor to set up name and balance 
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
    public boolean withdraw(double amount) { //public method to reduce bank account balance
    	if (amount > maxWithDraw)
    	{
    		System.out.println("Can not withdraw. Has a withdraw limit!");
    		return false;
    	}
    	
    	if (balance > amount) {
            balance -= amount;
            System.out.printf("withdraw: $%.2f, current balance is: $%,.2f%n", amount, balance);
            return true;
        } else {
        	System.out.println("Can not withdraw. No enough balance!");
            return false;
        }
    }
    
    //override toString method in the BankAccount
    public String toString() {
    	String accountInfo = super.toString();
    	accountInfo +=  String.format("--- maxmum withdraw limit: $%.2f", getMaxWithDraw()); 
    	return accountInfo;
    }
    
    //step-3: must override/implement: public abstract boolean makePayment(double amount); in Payable interface
    public boolean makePayment(double amount){
        if(withdraw(amount)){
            return true;
        }
        else{
            return false;
        }
    }
    
    //step-3: must override/implement:  public abstract boolean transfer(BankAccount acc, double amount); in Transfer interface
    public boolean transfer(BankAccount acc, double amount){
        if(withdraw(amount)){
            acc.deposit(amount);
            return true;
        }
        else{
            return false;
        }
    }
    
}
