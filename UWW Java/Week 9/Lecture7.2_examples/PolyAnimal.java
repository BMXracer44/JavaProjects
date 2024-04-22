
import java.util.InputMismatchException;
import java.util.Scanner;

public class PolyAnimal {

	public static void main(String[] args) {

		 Animal animal = new Animal();
		 Fish goldenF = new Fish();
		 Frog greenF = new Frog();
		 Bird whiteB = new Bird();
		 
//implement polymorphism: case-1: use method overriding to provide different implementations for the same method prototype 		 
		 animal.move();
		 goldenF.move();
		 greenF.move();
		 whiteB.move();
		
//implement polymorphism: case-2: use superclass reference variable to reference objects of subclasses
//animals array is polymorphic.		 
/*		 Animal[] animalOptions = new Animal[] {new Fish(), new Frog(), new Bird()};
		 String message = "\nChoose one type of animals that you want to create: ";
		 message += "\n1. Fish\n2. Frog\n3. Bird\n4. quit\n";
		 
		 Scanner input = new Scanner(System.in);
         int animalTypes = animalOptions.length + 11;
		 int validChoice = 1;
		 while( (validChoice = getUserChoice(message, input))!= animalTypes) {     
			 animalOptions[validChoice-1].move();
		 }
*/		   

	}
	
	
	public static int getUserChoice(String message, Scanner sc) {
		   int num = 0;
		   while (true)
		   {
			   System.out.print(message);
			   try {
				   num = sc.nextInt();
				   if (num < 1 || num > 4) {  
					   throw new InputMismatchException();
				   }
				   else break; 
			   }
			   catch(InputMismatchException e) {
				   System.err.println("Invalid input! Try again!");
				   sc.nextLine(); //to ignore invalid input, i.e., take invalid input from input stream buffer
			   }
			
		   }
		   
		   return num;
	   }


}

class Animal{
	protected double x_coordinates;  //subclasses can access protected members in a superclass 
	protected double y_coordinates;
	
	public void move() {
		++x_coordinates;
		++y_coordinates;
		
		System.out.printf("animal moves %.0f foot\n", Math.sqrt(1) );
	}
	
}

class Fish extends Animal{
	
	public void move() {
		swim(3);
	}
	
	private void swim(double feet) {
		x_coordinates += feet;
		System.out.printf("%s swim: %.1f feet.\n", this.getClass().getSimpleName(), feet);
	}
}

class Frog extends Animal{
	public void move() {
		jump(5);
	}
	
	private void jump(double feet) {
		y_coordinates += feet;
		System.out.printf("%s jump: %.1f feet.\n", this.getClass().getSimpleName(), feet);
	}
	
}

class Bird extends Animal{
	public void move() {
		fly(5);
	}
	
	private void fly(double feet) {
		x_coordinates += feet;
		y_coordinates += feet;
		double distance = Math.sqrt(feet*feet + feet*feet);
		System.out.printf("%s fly: %.1f feet.\n", this.getClass().getSimpleName(), distance);
	}
}
