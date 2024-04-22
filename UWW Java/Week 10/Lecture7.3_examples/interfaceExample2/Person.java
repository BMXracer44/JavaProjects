package interfaceExample2;
import javax.swing.JOptionPane;

/**
 * This class implements the displayable interface, but does not override the
 * default display method
 *
 */
public class Person implements Displayable 
{
	private String name;
	//constructor
	public Person(String n)
	{
		name = n;
	}
	public String getName() {return name;}
	public void displayInPopupWindow(String s) {
		JOptionPane.showMessageDialog(null, s);
	}  
	
	
}
