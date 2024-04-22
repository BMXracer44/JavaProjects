//Recursion Example-3: RecursionEx3.java
import java.math.BigInteger; 
//import BigInteger type to demonstrate larger values than
//what long variables can store, for example: 50! = 50*49*48*....*1

public class FactorialCalculator {
  
	//for loop, iteration version
   public static BigInteger factorial(BigInteger bigNumber) {
	   BigInteger fResult = BigInteger.ONE; 
	   for (BigInteger n = bigNumber; n.compareTo(BigInteger.ZERO)>0; 
			   n = n.subtract(BigInteger.ONE))
	       fResult = fResult.multiply(n);	  
	   
	   return fResult;
   }
   
   //define a recursive version of factorial function named factorial2
   public static BigInteger factorial2(BigInteger bigNumber) {
      BigInteger n = bigNumber;

      if(n.compareTo(BigInteger.ZERO) > 0){
         return n.multiply(factorial2(n.subtract(BigInteger.ONE)));
      }
      else{ //base case
         return BigInteger.ONE;
      }
   }
   
   public static void main(String[] args) {
      
      BigInteger number = BigInteger.valueOf(300000);
	  System.out.printf("%d-factorial = %d ", number, factorial(number));
   }
   
 
}

