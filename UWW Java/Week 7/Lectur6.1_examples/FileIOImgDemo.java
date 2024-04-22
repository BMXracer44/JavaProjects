import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class FileIOImgDemo {
	
  public static void main(String[] args) throws Exception {
    Image image1 =null, image2=null, image3 = null;
    try {
      // Read from a file
      File file = new File("StartNow.png");
      image1 = ImageIO.read(file);

      // Read from an input stream
      InputStream is = new BufferedInputStream(new FileInputStream("Halloween.jfif"));
      image2 = ImageIO.read(is);
      is.close();
      
     // Read from a URL
      URL imageLocation = new URL("https://horstmann.com/java4everyone/duke.gif");
      image3 = ImageIO.read(imageLocation);
   
      //Read in image file, 
      InputStream in = imageLocation.openStream();
      FileOutputStream out = new FileOutputStream("duke2.gif"); //To write binary data to a file, use a FileOutputStream
      boolean done = false;
      while (!done)
      {
    	//The read method of an input stream reads a single byte and returns −1 when no further input is available. 
    	 int input = in.read(); // −1 or a byte between 0 and 255, 
         if (input == -1) { done = true; }
         else { out.write(input); }   //The write method of an output stream writes a single byte.
      }
      
      in.close();
      out.close();
      
      
     } catch (IOException e) {
    	System.out.println(e);
    }

	// Use a label to display the image 
    JFrame frame = new JFrame();
    JPanel labelPanel = new JPanel();
    JLabel label1 = new JLabel(new ImageIcon(image1));
    JLabel label2 = new JLabel(new ImageIcon(image2));
    JLabel label3 = new JLabel(new ImageIcon(image3));
    labelPanel.add(label1);
    labelPanel.add(label2);
    labelPanel.add(label3);
    frame.setContentPane(labelPanel); 
    frame.setVisible(true);
    frame.setSize(new Dimension(600, 600));//in pixels
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}

