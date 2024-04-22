
// Die-rolling program using an array as frequency counters
// use java.security.SecureRandom class to generate random numbers
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/security/SecureRandom.html

import java.security.SecureRandom;

public class RollDieEx2 {
   public static void main(String[] args) {
      SecureRandom randomNumbers = new SecureRandom(); 
      int[] frequency = new int[7]; // array of frequency counters

      // roll die 60,000,000 times; use die value as frequency index
      for (int roll = 1; roll <= 60_000_000; roll++) {
         ++frequency[1 + randomNumbers.nextInt(6)];  //use randomly generated faces 1-6 as indices of frequency counters
      } 

      System.out.printf("%s%10s%n", "Face", "Frequency");
   
      // output each array element's value
      for (int face = 1; face < frequency.length; face++) {
         System.out.printf("%4d%10d%n", face, frequency[face]);
      } 
   } 
} 




