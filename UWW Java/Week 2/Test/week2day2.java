package Test;

import java.util.*;

class Main {
    public static void main(String[] args) {

        int num = 4;

        System.out.printf("Print num %d", num);

        String m = "300";
        String n = "29.89";

        //System.out.printf("%10d,%8.1f, String: %10s%5s\n",
            //Integer.parseInt(m), Double.parseDouble(n), "$" + m+n);

        int num1 = 2, num3 = 3;
        System.out.println("\nbefore casting: num1/num3 = " + 2/3); //num1/num3
        double result = (double) num1/num3;
        System.out.println("after casting: (double)num1/num3 = " + result);
        System.out.println("How about this casting: (double)(num1/num3) = " + (double) (num1/num3));

        //Initializes scanner
        Scanner input = new Scanner(System.in);
        
        //Asks user for number
        System.out.print("Enter the number: ");
        //Stores user input
        int userInput = input.nextInt();
        //Outputs user input
        System.out.println(userInput);
        
        //Asks user for name
        System.out.print("Enter your name: ");
        //Stores user input
        String name = input.nextLine();
        while (name.isBlank()) {
            name = input.nextLine();
        }

        //Outputs user input
        System.out.println(name);
    }
}