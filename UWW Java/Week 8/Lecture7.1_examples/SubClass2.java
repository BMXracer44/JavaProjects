//to demonstrate how superclass and subclass constructors work

public class SubClass2 extends SuperClass2 { //set up inheritance 
	/* constructor */
	public SubClass2(int arg)
	{
		super(arg + 1); //call SuperClass2's constructor with one argument
		System.out.println("This is a subclass constructor with argument: " + arg);
	}
	
	public SubClass2()
	{
		//super(arg + 1); //call SuperClass2's constructor with one argument
		System.out.println("This is a subclass constructor without argument. ");
	}
}
