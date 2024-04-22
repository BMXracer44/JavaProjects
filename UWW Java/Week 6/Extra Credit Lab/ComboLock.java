import java.util.*;

public class ComboLock
{    
    static Random rand = new Random();

   public static int secret1; //First number to turn right to
   private static int secret2; //First number to turn left to
   private static int secret3; //Last number to turn right to

   // lockState: 
   // 0: nothing entered, 1: secret1 done, 2: secret2 done, 
   // 3: secret3 done and unlocked
   private static int lockState = 0;
   private static int currentNum;

   private static boolean validSoFar = true;

   //Makes the lock object
   public ComboLock(int secret1, int secret2, int secret3) { 
    this.secret1 = secret1;
    this.secret2 = secret2;
    this.secret3 = secret3;
    } //constructor

   public static void reset() { 
    currentNum = 0;
    lockState = 0;
    validSoFar = true;

    } //Resets the state of the lock so that it can be opened again.   

   public static void turnLeft(int ticks) { 
    if(currentNum - ticks < 0){
        currentNum = currentNum + 40 - ticks;
    }
    else{
        currentNum = (currentNum + ticks);
    }

    if(lockState == 1 && currentNum == secret2){
        lockState++;
    }
    } //Turns lock left given number of ticks.

   public static void turnRight(int ticks) {  

    if(currentNum + ticks > 40){
        currentNum = (currentNum + ticks) - 40;
    }
    else{
        currentNum = (currentNum + ticks);
    }

    if(lockState == 0 && currentNum == secret1){
        lockState++;
    } 
    else if(lockState == 0 && currentNum != secret1){
        validSoFar = false;
    }

    if(lockState == 2 && currentNum == secret3){
        lockState++;
    }   
    else if(lockState == 2 && currentNum != secret3){
        validSoFar = false;
    } 
} //Turns lock right given number of ticks

   public static boolean open() { 
    if(lockState == 3 && validSoFar){
        return true;
    }
    else{
        return false;
    }
    } //Returns true if the lock can be opened now 
}