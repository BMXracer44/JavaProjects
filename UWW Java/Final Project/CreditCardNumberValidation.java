import javax.swing.*;

public class CreditCardNumberValidation {

    public static void payPalValidation(){
        String email = "";
        email = JOptionPane.showInputDialog("Enter your PayPal address (Your email address)");

        if(!email.contains("@")){
            System.out.println("Please enter a valid email address!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Payment successful!");
        }

    }
	public static void creditCardPayment() {
        boolean quit = false;

        while (!quit) {
            String input = JOptionPane.showInputDialog("Enter a credit card number (16 digit number without the \"-\")");

            quit = validateInput(input);
        }
    }

    // Validate and format the credit card number input
    private static boolean validateInput(String input) {
        if(input.length() == 16){
            JOptionPane.showMessageDialog(null, "Payment successful!");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid input format. Please enter a valid credit card number.");
            return false;
        }
    }
}
