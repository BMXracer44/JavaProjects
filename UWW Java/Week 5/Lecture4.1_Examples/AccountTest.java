//import java.util.ArrayList;
//import java.util.Random;
import java.util.*;

//This class is used to create object instance and test the program Account.java

public class AccountTest{
	public static void main(String[] args) {
		
//when in the case that no constructor defined in a class, compiler will create a default constructor, 
//that default constructor will be called when creating object instances from that class.
		Account aa = new Account(); //Originally errored out because there is no default constructor in account class
		System.out.println("Account name: " + (aa.getName().isEmpty()? "N/A": aa.getName()) );
		
//when in the case that at least one constructor defined in a class, then compiler will not create a default constructor,
//Those programmer-defined constructor(s) will be called when creating object instances from that class
		
		//(1) add code here to create an account object named "myAccount", 
		//and provide an account name (e.g., ask user to enter a name) and account balance
		Account myAccount = new Account("Alex", 1000);
			//System.out.print("Input your account name: "); Sets account name 
			//myAccount.setName(input.nextLine()); 

			//System.out.print("\nEnter your account balance: "); Sets account balance
			//myAccount.deposit(input.nextDouble());
				
		//(2) display myAccount's name and balance 
		System.out.printf("My account:%s/n Account balance: $%.2f\n", myAccount.getName(), myAccount.getBalance());
		System.out.printf("My account info: %s\n", myAccount); //Uses toString method automattically
				
		//(3) deposit $500 to myAccount.
		myAccount.deposit(500);		
		System.out.println(myAccount);
		
		//(4) create an array of three checking accounts
		Account[] checkingAccounts = new Account[3];
		checkingAccounts[0] = new Account("Checking1", 10);		
		checkingAccounts[1] = new Account("Checking2", 3000);	
		checkingAccounts[2] = new Account("Checking3", 35.55);			

		//(5) call printAccounts() method to print out all checking accounts info.
		printAccounts(checkingAccounts);
				
		//(6) create an ArrayList of 10 saving accounts
		ArrayList<Account> savingAccounts = new ArrayList<Account>();
		Random r = new Random();
		for(int i = 1; i <= 10; i++){
			savingAccounts.add(new Account("Saving"+i, r.nextDouble(1000)));
		}		
				
		//(7) call printAccounts() method to print out all saving accounts info.
		printAccounts(savingAccounts);	
		
		
	}

//define a printAccounts method to print out accounts in an array
	public static void printAccounts(Account[] accountArray){
		System.out.println("-".repeat(50));
		System.out.printf("%-15s|%30s\n", "AccountName", "Balance");
		System.out.println("-".repeat(50));
		for(Account a : accountArray){
			System.out.println(a);
		}
		System.out.println("-".repeat(50)); 
	}

	public static void printAccounts(ArrayList<Account> accountList){
		System.out.println("-".repeat(50));
		System.out.printf("%-15s|%30s\n", "AccountName", "Balance");
		System.out.println("-".repeat(50));
		for(Account a : accountList){
			System.out.println(a);
		}
		System.out.println("-".repeat(50));
	} 
}