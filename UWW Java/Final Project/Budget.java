import javax.swing.*;

public class Budget {
    public static double setBudget(){
        double budget = 0;

        String temp = JOptionPane.showInputDialog("What is your budget for today's shopping trip? (Enter without the \"$\")");

        try{
            budget = Double.parseDouble(temp);
            if(budget <= 0){
                throw new NumberFormatException();
            }
        }
        catch(Exception e){
            System.out.println("Invalid budget!");
            setBudget();
        }
        return budget;
    }

    //prompts user for payment option and returns the fee amount of that option
    public static double paymentOption(){
        while(true){
            String[] options = {"Credit Card", "Mobile Pay", "PayPal", "Cash"};

            int result = JOptionPane.showOptionDialog(null, "Choose a payment option: ", "Options", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (result) {
                case 0:
                    CreditCardNumberValidation.creditCardPayment();
                    return 1.035;
                case 1:
                    JOptionPane.showMessageDialog(null, "Payment successful!");
                    return 1.035;
                case 2:
                    CreditCardNumberValidation.payPalValidation();
                    return 1.02;
                case 3:
                    JOptionPane.showMessageDialog(null, "Payment successful!");
                    return 1;
            }
        }
    }
}
