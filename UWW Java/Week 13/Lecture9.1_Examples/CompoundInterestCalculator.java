//Recursion Practice (2)

public class CompoundInterestCalculator {
  
	  
   public static void main(String[] args) {
      
      double principal = 100;  //initial investment amount (e.g., $100)
      double interestRate = 0.05;  //annual interest rate (e.g., 0.05)
      int compoundFrq = 12; //number of times to calculate interests per year (e.g., 12)
      int years = 3; //number of investment years (e.g., 3)
      
      double interestRateCompound = interestRate/compoundFrq;
      int  totalCompoundTimes = compoundFrq*years;  
	  System.out.printf("Given: P=$%,.2f, r=%.2f, n=%d, and y=%d%n", 
			  principal, interestRate, compoundFrq,years);
	//step-1 complete the following code		  
	 double accAmount = totalAmount(principal, interestRate, totalCompoundTimes, compoundFrq);
	 System.out.printf("Total accumulated amount: $%,.2f%n", accAmount);
	 System.out.printf("Total interest: $%,.2f", accAmount - principal);
   }
   
   //step-2  define totalAmount as a recursion function 
   public static double totalAmount(double amountS, double rate, int times, int compoundFrq) {
	   //Base case, times = 1, accAmount = principal * (1 + rate)
      if(times == 0) {
         return amountS;
      }
      else{
         return totalAmount(amountS, rate, times - 1, compoundFrq) * (1 + rate / compoundFrq);
      }
   }
}

