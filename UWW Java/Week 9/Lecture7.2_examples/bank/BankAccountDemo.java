package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountDemo {

		public static void main(String[] args) {
			
            //Step-4(1): Create a new CheckingAccount, call createAccount() method
			//type casting to CheckingAccount for returned object
			CheckingAccount myChecking = (CheckingAccount) createAccount("checking");
			
			//withdraw 300, 
			myChecking.withdraw(300);
			//withdraw 600,
			myChecking.withdraw(600);
			//withdraw 200
			myChecking.withdraw(200);

			printAccountInfo(myChecking);
			//Step-4(2): Create a new SavingAccount, call createAccount() method 
			SavingAccount mySaving = (SavingAccount) createAccount("saving");
			
			//withdraw 500,
			mySaving.withdraw(500);
			//withdraw 1000, 
			mySaving.withdraw(1000);

			printAccountInfo(mySaving);
			
			//step-5(1): create an Array that can hold 3 bank account (either checking or saving accounts)
			BankAccount[] accounts = new BankAccount[3];
			for ( int i = 0; i < accounts.length; i++ ){
				if(i % 2 == 0){
					accounts[i] = new CheckingAccount("checkin", 0);
				}
				else{
					accounts[i] = new SavingAccount("saving", 0);	
					}
			}
		
		    //step-5(2): printout account info by calling printAccountInfo method
		    for (BankAccount acc: accounts){
				printAccountInfo(acc);
			}

		}  //end of main method

		private static BankAccount createAccount(String accountType)
		{
			Scanner keyboard = new Scanner(System.in);
			System.out.println("\nCreate a "+ accountType + " account:");
			System.out.println("Enter an account name: ");
			String accountName = keyboard.nextLine(); 
			
			double  accountBalance = readInput("Enter balance for that account: ", keyboard);
			
			BankAccount newAcc = null; 
			
			if (accountType.equalsIgnoreCase("checking"))
			{
				newAcc = new CheckingAccount(accountName, accountBalance);
			
			}
			
			else if (accountType.equalsIgnoreCase("saving"))
			{
				newAcc = new SavingAccount(accountName, accountBalance);
			
			}

			return newAcc;
		}
		
	
		private static void printAccountInfo(BankAccount account)
		{
            System.out.println(account.getClass().getSimpleName());
            System.out.println(account);
		}
		
		
		public static double readInput(String message, Scanner sc) {
			   double num = 0;
			   while (true)
			   {
				   System.out.print(message);
				   try {
					   num = sc.nextDouble();
					   if (num < 0) {  
						//   String errMsg = "Entered a negative number " + num;
						  // throw new InputMismatchException(errMsg);
						   throw new InputMismatchException();
					   }
					   else break; 
				   }
				   catch(InputMismatchException e) {
					  // System.out.println(e.getMessage());
					   System.err.println("Invalid input! Try again!");
					   sc.nextLine(); //to ignore invalid input, i.e., take invalid input from input stream buffer
				   }
				
			   }
			   
			   return num;
		}
}

