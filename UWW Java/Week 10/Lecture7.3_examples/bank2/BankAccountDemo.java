package bank2;

public class BankAccountDemo {

	public static void main(String[] args) {
		
		// define an Array that can hold 3 bank accounts (two checking accounts and one saving accounts)
		BankAccount[] accounts = new BankAccount[3];
       //step-4: create new checking account and saving account objects
		accounts[0] = new CheckingAccount("checking1", 400);
		accounts[1] = new CheckingAccount("checking2", 1000);
		accounts[2] = new SavingAccount("saving1", 2000);
		
	    for (BankAccount acc: accounts) 
		     printAccountInfo(acc);
		
	    //step-5(a) make payment from checking1, $124.5
		((Payable)accounts[0]).makePayment(124.5); 

	    // call checkBalance method to check account balance in checking1
	    checkBalance(accounts[0]);
        
	    //step-5(b) transfer $200 from checking2 to checking1
	    ((Transfer)accounts[1]).transfer(accounts[0], 200);

	    // call checkBalance method to check account balances in checking2 and checking1
		checkBalance(accounts[1]);
		checkBalance(accounts[0]);
    
	    //step-5(c) transfer $1000 from saving1 to checking1
		((Transfer)accounts[2]).transfer(accounts[0], 1000);

	    // call checkBalance method to check account balances in checking1 and saving1
		checkBalance(accounts[2]);
		checkBalance(accounts[0]);
	    
	    
	}  //end of main method
	
	
	/**
	 * checkBalance method: check current balance of a bank account
	 * @param acc
	 */
	public static void checkBalance(BankAccount acc) {
   
       System.out.printf("\nAccount: %s, current balance: $%.2f\n", acc.getName(), acc.viewBalance());
       System.out.printf("%s\n", "*".repeat(10));
   }
   
	/**
	 * printAccountInfo method: print out a bank account info.
	 * @param account
	 */
   private static void printAccountInfo(BankAccount account)
	{
       System.out.println(account.getClass().getName());
       System.out.println(account);
	}
   

}

