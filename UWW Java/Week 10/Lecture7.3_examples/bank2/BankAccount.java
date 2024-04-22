package bank2;

public abstract class BankAccount {
	private String name;   //bank account name: private, accessible by the class itself
    protected double balance;  //bank account balance: protected, accessible by subclasses, but not by other classes 

    //constructor for setting up name and balance when creating a new bank account object (from a subclass)
    public BankAccount(String name, double balance) {
    	this.name = name;
    	this.balance = balance;
    }
    
    public String getName() {  //public method to return the account name (private data)
        return this.name;
    }

    public void setName(String name) {  //public method to set the account name
        this.name = name;
    }
    
    public double viewBalance() {  //public method to return the account balance
    	return this.balance;
    }

    public void deposite(double amount) {  //public method to increase bank account balance
     this.balance += amount;
    }
   /*
    public boolean withdraw(double amount) { //public method to reduce bank account balance
        if (balance > amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    */
    public abstract boolean withdraw(double amount);
    
    public String toString() {
    	return String.format("Account name:%s%nAccount balance: $%,.2f%n", this.name, this.balance);
    }
    
}
