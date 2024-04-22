/**************************************
//http://javaprojectspaul.blogspot.com/2013/03/ticketnumber.html
  Filename: TicketNumber.java
  Created by: Paul Steidle
  Created on: 1/24/13
  Purpose: Travel Tickets Company sells tickets for airlines, tours, and other travel-related
services. Because ticket agents frequently mistype long ticket numbers, Travel Tickets
has asked you to write an application that indicates invalid ticket number entries.
The class prompts a ticket agent to enter a six-digit ticket number. Ticket numbers
are designed so that if you drop the last digit of the number, then divide the number
by 7, the remainder of the division will be identical to the last dropped digit. This
process is illustrated in the following example:
 *
 * Step 1 Enter the ticket number; for example, 123454.
Step 2 Remove the last digit, leaving 12345.
Step 3 Determine the remainder when the ticket number is divided by 7. In this case, 12345 divided
by 7 leaves a remainder of 4.
Step 4 Assign the Boolean value of the comparison between the remainder and the digit dropped
from the ticket number.
Step 5 Display the result�true or false�in a message box.
 *
 *
 * Accept the ticket number from the agent and verify whether it is a valid number.
Test the application with the following ticket numbers:
l 123454; the comparison should evaluate to true
l 147103; the comparison should evaluate to true
l 154123; the comparison should evaluate to false
Save the program as TicketNumber.java.
 *
 *
*************************************/
//Import predefined swing package for dialog/input boxes
import javax.swing.*;
import java.util.*;

public class TicketNumber2 { //begin class
    public static void main(String[] args){

        //Prompt user with ticket number using JOptionPane box, input will be accepted as string
        String ticketString = JOptionPane.showInputDialog(null, "Enter your six digit ticket number: ");

        //Convert ticketString to integer data type
        int ticketNum = Integer.parseInt(ticketString);

        //Divide ticket number by 10 to remove last digit
        int removeDigit = ticketNum/10;

        //Store removed digit in a variable
        int lostDigit = ticketNum%10;

        //Use modulus operator to determine remainder of ticket number after dividing by 7 and store into a variable
        int remainderTicket = removeDigit%7;

        /*use boolean logic to determine if the dropped digit from the ticket number equals the remainderTicket
         * If it does, a dialog box will confirm the ticket is valid
         * If it does not, a dialog box will confirm the ticket is invalid.
         */

        if(lostDigit == remainderTicket){
            JOptionPane.showMessageDialog(null, "This is a valid number.");
        }
 else
     JOptionPane.showMessageDialog(null, "Ticket is invalid");

  }//end main

}//end class