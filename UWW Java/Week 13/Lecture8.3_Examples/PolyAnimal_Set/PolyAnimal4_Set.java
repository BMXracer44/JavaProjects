package PolyAnimal_Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import java.util.Iterator;

public class PolyAnimal4_Set  {

	public static void main(String[] args) {
 
		 Animal animal; //define an "Animal" type reference variable
		 Fish goldenF = new Fish();
		 Frog greenF = new Frog();
		 Bird whiteB = new Bird();
//Apply polymorphism: use the same reference variable to reference different object instances from Fish, Frog, and Bird classes
		 animal = goldenF;
		 animal.move();
		 double x=0; 
		 double y=0;
System.out.printf("%s's distance from point(%.1f,%.1f): %.2f feets.\n", animal.getClass().getSimpleName(), x, y, animal.getDistance(x, y));
		 
         animal = greenF;
		 animal.move();
		 x=1.1; y=2.9;
System.out.printf("%s's distance from point(%.1f,%.1f): %.2f feets.\n", animal.getClass().getSimpleName(), x, y, animal.getDistance(x, y));	 
		 
         animal = whiteB;
		 animal.move();
System.out.printf("%s's distance from point(%.1f,%.1f): %.2f feets.\n", animal.getClass().getSimpleName(), x, y, animal.getDistance(x, y));		

//part-2 using an array of "Animal" type reference variable		 
		 Animal[] animals = new Animal[] {new Fish(), new Frog(), new Bird(), goldenF, greenF, whiteB};
	     
		 //randomly pick up an animal in the animals array to move the animal (i.e., change its x,y coordinates
		 Random rand = new Random();
		 long seed = System.currentTimeMillis();
		 rand.setSeed(seed);
		 for (int j=0; j<10; j++) {
			 int i = rand.nextInt(6)+1;
			 animals[i-1].move();
		 }
		 
		 for (Animal a: animals) { //enhanced for loop
			 System.out.printf("%s's distance from point(%.1f,%.1f): %.2f feets.\n", a.getClass().getSimpleName(), 2.0, 2.0, a.getDistance(2, 2));		
		 } 
		 
//part-3: create an animalset which is a HashSet		 
		 Set<Animal> animalset = new HashSet<Animal>();
		 animalset.addAll(Arrays.asList(animals));
		 for (Animal a: animalset) { 
			 System.out.println(a.getClass().getSimpleName());
			 System.out.println(a.getDistance(2.0, 2.0));
		 }
		 //See in zyBook: Chapter 15.7 about how to choose and implement a collection
		 //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashSet.html#contains(java.lang.Object)
		 //Returns true if this set contains the specified element. More formally, returns true if and only if 
		 //this set contains an element e such that Objects.equals(o, e).
		 //Objects.equals(o,e) method call the object's equals() method or the Object's equals() method 
		 System.out.println(animalset.contains(new Frog())); //call the Object's equals() method to compare hashcode of the two Animal objects
		 //contains() method will compare goldenF with each element in the animalset by using their hashcodes

//part-4: create an animalTreeset which is a TreeSet
		 //when store objects in TreeSet it automatically sort the objects that 
		 //implements the Comparable<E> interface
		 //here Animal implements the Comparable<E> interface, we can create a TreeSet to store Animal's subclass objects
		 Set<Animal> animalTreeSet = new TreeSet<Animal>(animalset);
		 Iterator<Animal> animalpoint = animalTreeSet.iterator();
		 while(animalpoint.hasNext()) { 
			 Animal a = animalpoint.next();
			 System.out.println(a.getClass().getSimpleName());
			 System.out.println(a.getDistance(2.0, 2.0));
		 }
	}
	
	
	public static int getUserChoice(String message, Scanner sc, int counts) {
		   int num = 0;
		   while (true)
		   {
			   System.out.print(message);
			   try {
				   num = sc.nextInt();
				   if (num < 1 || num > counts) {  
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


//in order to use Arrays.sort() method to sort the objects stored in an array, we need to implement Comparable interface provided in Java API java.lang package 
//add an implementation of compareTo() method in Animal class, so that we can sort various objects (e.g., Fish, Bird, and Frog type objects that extends the Animal class)
abstract class Animal implements Comparable<Animal> { //Define Animal class as an abstract class
	/* Note: both fields below have a package access scope, 
	 * inside subclass definition, can use those variables directly as the fields in the subclass 
	* that means in subclass, we can assign values to those fields directly
	*/
	double x_coordinates;  
	double y_coordinates; 
	
	private double distance; //define distance as private so that it can not be accessed directly by subclass
	
	//(1) modify this method to be an abstract method
	public void move() {
		++x_coordinates;
		++y_coordinates;
		
		System.out.printf("animal moves %.0f foot\n", Math.sqrt(1) );
	}
	//define a method: getDistance()
	//which will return the distance of an animal from a point(x,y)  
	public double getDistance(double x, double y) {
		double x_distance = x_coordinates - x;
		double y_distance = y_coordinates - y;
		distance = Math.sqrt(x_distance*x_distance + y_distance*y_distance);
	    return distance;
	}
	
	//provide implementation of the compareTo() method (the method declared in the Comparable interface)
	public int compareTo(Animal a) {
		 if (this.distance < a.distance) 
			 return -1;  //-1 indicates "this" object should be put before "a" object in the natural order
		 else if (this.distance == a.distance)
			 return 0;  // the objects are the same in the natural order, 
		 else 
			 return 1; //1 indicates "this" object should be put after "a" object in the natural order
	}
	
		
}

class Fish extends Animal{
	
	//(1) A constructor to set up initial position of Fish at origin point (0,0) 
	public Fish() {
		x_coordinates = 0;
		y_coordinates = 0;

	} 
	
	//(2) A constructor with two parameters to set up initial position of Fish
	public Fish(double x, double y) {
		x_coordinates = x;
		y_coordinates = y;

	} 
	
	//provide implementation of the move() method
	public void move() {
		swim(3);
	}
	
	private void swim(double feet) {
		x_coordinates += feet;
		System.out.printf("%s swim: %.1f feet.\n", this.getClass().getSimpleName(), feet);
	}
	
}

class Frog extends Animal{
	
    //(1) A default constructor to set up initial position of Frog at origin point (0,0) 
	public Frog() {
		x_coordinates = 0;
		y_coordinates = 0;
	} 
	
	//(2) A constructor with two parameters to set up initial position of Frog
	public Frog(double x, double y) {
		x_coordinates = x;
		y_coordinates = y;
	} 
	
	//provide implementation of the move() method
	public void move() {
		jump(5);
	}
	
	private void jump(double feet) {
		y_coordinates += feet;
		System.out.printf("%s jump: %.1f feet.\n", this.getClass().getSimpleName(), feet);
	}
	
}

class Bird extends Animal{
  //(1) A default constructor to set up initial position of Bird at origin point (0,0) 
	public Bird() {  
		x_coordinates = 0;
		y_coordinates = 0;
	} 
	
	//(2) A constructor with two parameters to set up initial position of Bird
	public Bird(double x, double y) {
		x_coordinates = x;
		y_coordinates = y;
	}
	
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
