import java.util.*;

public class Main {

    public static void main(String[] args){

        //Initializing scanner
        Scanner input = new Scanner(System.in);

        //Will be used to validate input
        long ccNumber = 0;

        //Input statement
        System.out.print("Enter your credit card number: ");
        //Records input
        String creditCardNumber = input.nextLine();

        //Formats input so following code can execute correctly
        
            creditCardNumber = creditCardNumber.replaceAll(" ", "");
            creditCardNumber = creditCardNumber.replaceAll("-", "");

            //Exits program if credit card number has a character in it
            try {
                ccNumber = Long.parseLong(creditCardNumber);
            } catch (Exception e) {
                System.out.println(creditCardNumber.substring(0, 4) + "-" + creditCardNumber.substring(4, 8) + "-" + creditCardNumber.substring(8, 12) + "-" + creditCardNumber.substring(12, 15) + " is invalid.");
                System.exit(1);
            }

            //Initializes variables to check if input is valid
            int numberOverFour = 0;
            int everyOther = 0;
            int total = 0;

            //For and if loop to validate input
            //Sorts through every number in the input
            for(int i = 0; i < creditCardNumber.length(); i++){
                //Sums all individual numbers in the input
                total += Integer.parseInt(creditCardNumber.substring(i, i + 1));
                //Sorts through every other number in input
                if(i % 2 == 0){
                    //Adds every other number in input
                    everyOther += Integer.parseInt(creditCardNumber.substring(i, i + 1));
                    if(Integer.parseInt(creditCardNumber.substring(i, i + 1)) > 4){
                        //Records if every other input is greater than 4
                        numberOverFour++;
                    }                

                }
            }    

            //Totals all the numbers up for validation
            total = total + numberOverFour + everyOther;

            //Validates length of input is correct length
            if(creditCardNumber.length() != 16){
                //Exits program if input is too short or too long
                System.out.println("Input is either too short or too long! Goodbye!");
                //System.exit(1);            
            }       

            //Validation statement
            if(total % 10 == 0){
                //Validation statement
                System.out.println(creditCardNumber.substring(0, 4) + "-" + creditCardNumber.substring(4, 8) + "-" + creditCardNumber.substring(8, 12) + "-" + creditCardNumber.substring(12, creditCardNumber.length()) + " is valid.");
                System.exit(1);             
            }
            else{
                //Invalid if total is not divisible by 10
                System.out.println(creditCardNumber.substring(0, 4) + "-" + creditCardNumber.substring(4, 8) + "-" + creditCardNumber.substring(8, 12) + "-" + creditCardNumber.substring(12, creditCardNumber.length()) + " is invalid.");
                System.exit(1);     
            }

    }
}
