package interfaceExample2;
/**
 * This class demonstrates a class that implements the 
 * Displayable interface (with a default method)
 */
public class InterfaceDefaultMethodDemo 
{
	public static void main(String[] args) {
		
		//Create an instance of the Person class.
		Person p = new Person("Antonio");
		
		//Call interface default method through Person object p, 
		p.displayInConsole(p.getClass().getName()); 
		p.displayInPopupWindow(p.getName());//call displayInPopupWindow defined in the person class

		Displayable p2 = new Person("Bob");
		p2.displayInConsole(p2.getClass().getName()); 
		((Person)p2).displayInPopupWindow((Person)p2.getName()); //because no method names displayInPopupWindow declared in the person class
		//after adding displayInPopupWindow() d=method declaration in the interface
		//then no need type casting
	}
}
