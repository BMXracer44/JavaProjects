import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.WindowConstants;

public class ShowMessageBox{
	     public static void main(String[] args)
	     {
	       String backupDir = "/Users/al/backups";
	       
	       // create a jframe
	       JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	       frame.setVisible(true);
	       frame.setSize(new Dimension(600, 600));//in pixels

	       // show a meesage dialog box by using showMessageDialog method
	       JOptionPane.showMessageDialog(frame,
	           "Problem writing to backup directory: '" + backupDir + "'.", "title here", JOptionPane.ERROR_MESSAGE);
	       
	       JOptionPane.showMessageDialog(null,
		           "This is another message box");
	       frame.setVisible(false);
	       String input = JOptionPane.showInputDialog("Enter your name"); 
	       JOptionPane.showMessageDialog(null, input, "Your Name", JOptionPane.PLAIN_MESSAGE);
	      // frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //click the close button and terminate the system
	       System.exit(0); //to terminate the program 
	     }
}
   
    