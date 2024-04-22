package Test;

public class Practice1 {
    
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Test2.print();

        System.out.println(5.6+5.8);
        //round the number
        double result = 5.6 + 5.89;
        //One decimal place
        double resultR1 = Math.round(result*10)/10.0;

        //Two decimal places
        double resultR2 = Math.round(result*100)/100.00;

        System.out.println(result);
        System.out.println(resultR1);
        System.out.println(resultR2);

        double m1 = 9.99;
        double m2 = 5.99;
        double total = m1 + m2;

        int dollars = (int) total;
        int cents = (int) ((total - dollars)*100);
        System.out.println("Your total is " + dollars + " and " + cents + " cents");


    }
}
