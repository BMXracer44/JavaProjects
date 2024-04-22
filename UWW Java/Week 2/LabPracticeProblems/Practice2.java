import java.util.*;

public class Practice2 {
       public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Problem 2
        //Prompts user for phone number
        System.out.print("Enter a phone number with no parentheses or dashes: ");
        //Initializes phone number variable
        String number = "";
        //Records phone number and stores it in a variable
        while(number.isEmpty()){
            number = input.nextLine();
        }
        //Output statement
        System.out.println("Your phone number with parentheses and dashes is: (" +  number.substring(0, 3) + ") " + number.substring(3, 6) + "-" + number.substring(6));

int temp = 180;

if (temp > 90) {

   System.out.println("This porridge is too hot.");

     // cool down

   temp = temp - (temp > 150 ? 100 : 20);

} 

else if (temp < 70) {

      System.out.println("This porridge is too cold.");             

      // warm up

      temp = temp + (temp < 50 ? 30 : 20);

}

if (temp == 80) {

   System.out.println("This porridge is just right!");

}

    int num = 4;
    float flat = 4;
    short shat = 16;

    System.out.println(num + flat + shat);
    num = 8;
    num++;
    ++num;
    num %= 5;
    System.out.println(num);
    }
} 
