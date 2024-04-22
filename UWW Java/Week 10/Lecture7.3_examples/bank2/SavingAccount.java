package bank2;

public class SavingAccount extends BankAccount implements Transfer{ //step-2: add implements Transfer interface 
	
	private double minBalance;  //has a minimum balance requirement when withdraw
	
    //constructor for setting up name and balance when creating a new bank account object (from a subclass)
    public SavingAccount(String name, double balance) {
    	super(name, balance);//BankAccount constructor 
    	minBalance = 1000; 
    	System.out.printf("Create a saving account with a minimum balance requirement: $%.2f%n", minBalance);
    }
    
    //set minBalance
    public void setMinBalance(double min)
    {
    	minBalance = min; 
    }
    
    //get minBalance
    public double getMinBalance()
    {
    	return minBalance; 
    }
    
    //override withdraw method in the BankAccount    
    public boolean withdraw(double amount) { //public method to reduce bank account balance
        if ( (balance - amount) >= minBalance) {
            balance -= amount;
            System.out.printf("withdraw: $%.2f, current balance is: $%,.2f%n", amount, balance);
            return true;
        } else {
        	System.out.println("Can not withdraw. Minimum balance required!");
            return false;
        }
    }
    
    //override toString method in the BankAccount
    public String toString() {
    	String accountInfo = super.toString();
    	accountInfo += String.format("--- minimum balance required: $%.2f", getMinBalance()); 
    	return accountInfo;
    }
    
    //step-2: must override/implement:  public abstract boolean transfer(BankAccount acc, double amount); in Transfer interface
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
