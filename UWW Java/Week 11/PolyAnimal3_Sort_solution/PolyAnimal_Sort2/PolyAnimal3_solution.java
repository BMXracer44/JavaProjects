package PolyAnimal_Sort2;
import java.util.*;

public class PolyAnimal3_solution  {

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

//part-3: Use Arrays.sort() and customized Comparator		 
		 Random rand = new Random();
		 long seed = System.currentTimeMillis();
		 rand.setSeed(seed);
		 
         for (Animal a: animals) {
		      a.changeWeight(rand.nextDouble(5));
		      System.out.printf("%s's weights: %.1f\n", a.getClass().getSimpleName(), a.getWeight() );
         }

         System.out.println("\nAfter sort based on weights in descending order.");
         Arrays.sort(animals, new sortByDescending());
         for (Animal a: animals)
         {
        	 System.out.printf("%s's weights: %.1f\n", a.getClass().getSimpleName(), a.getWeight() );
         }
         
         System.out.println("\nAfter sort based on weights in ascending order.");
         Arrays.sort(animals, new sortByAscending());
         for (Animal a: animals)
         {
        	 System.out.printf("%s's weights: %.1f\n", a.getClass().getSimpleName(), a.getWeight() );
         }
	}

}

class sortByDescending implements Comparator<Animal>{
    // Sorting in descending order of weight
    public int compare(Animal a, Animal b)
    {
        if (a.getWeight() > b.getWeight())
            return -1;
        else if (a.getWeight() == b.getWeight())
	        return 0;
        else
        	return 1;
    }
} 

class sortByAscending implements Comparator<Animal>{
    // Sorting in ascending order of weight
    public int compare(Animal a, Animal b)
    {
        if (a.getWeight() < b.getWeight())
            return -1;
        else if (a.getWeight() == b.getWeight())
	        return 0;
        else
        	return 1;
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
	double weight;
	
	private double distance; //define distance as private so that it can not be accessed directly by subclass
	
	public double getWeight() {
		return weight;
	}
	
	public void changeWeight(double cw) {
	    weight += cw;
	    if (weight < 0) weight = 0;
	}
	
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
			 return -1;  //"this" object should be put before "a" object in the natural order
		 else if (this.distance == a.distance)
			 return 0;  // the objects are the same in the natural order, 
		 else 
			 return 1; //"this" object should be put after "a" object in the natural order
	}
}

class Fish extends Animal {

	//(1) A constructor to set up initial position of Fish at origin point (0,0) 
	public Fish() {
		x_coordinates = 0;
		y_coordinates = 0;
        weight = 0.5;
	} 
	
	//(2) A constructor with two parameters to set up initial position of Fish
	public Fish(double x, double y, double w) {
		x_coordinates = x;
		y_coordinates = y;
		weight = w;
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
		weight = 0.1;
	} 
	
	//(2) A constructor with two parameters to set up initial position of Frog
	public Frog(double x, double y, double w) {
		x_coordinates = x;
		y_coordinates = y;
		weight = w;
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
		weight = 1;
	} 
	
	//(2) A constructor with two parameters to set up initial position of Bird
	public Bird(double x, double y, double w) {
		x_coordinates = x;
		y_coordinates = y;
		weight = w;
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
