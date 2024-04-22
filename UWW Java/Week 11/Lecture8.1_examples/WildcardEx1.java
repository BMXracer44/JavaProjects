import java.util.*;

public class WildcardEx1 {

	public static void main(String[] args) {
		 
	    ArrayList<Cat> catList = new ArrayList<Cat>();
        catList.add(new Cat("Snow"));
        displayAnimal(catList);
        
        LinkedList<Dog> dogList = new LinkedList<Dog>();
        dogList.add(new Dog("Sunny"));
        displayAnimal(dogList);
        
        List<Animal> animalList = new ArrayList<Animal>();
        animalList.addAll(dogList);
        animalList.add(new Dog("Funny"));
        animalList.addAll(catList);
        displayAnimal(animalList); 
	    
	}
   
	 //List<? extends Animal> can be assigned to from all: List<Animal>, List<Cat>, List<Dog>
	public static void displayAnimal(List<? extends Animal> animalList) {
		for (int i=0; i<animalList.size(); i++) {
			System.out.println(animalList.get(i).getClass().getName()); 
			System.out.println(animalList.get(i).getName());
			System.out.println(animalList.get(i).speak());
		}
		
		//version-2, use iterator to access each element in a list
		/*
		Iterator<? extends Animal> iterator = animalList.iterator();
		while(iterator.hasNext()) {
			Animal obj = iterator.next();
			System.out.println(obj.getClass().getName());
			System.out.println(obj.getName());
			System.out.println(obj.speak());
		}
		*/
	}
}
abstract class Animal {
    private String name;    
    protected Animal (String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public abstract String speak();
}

class Cat extends Animal {
    public Cat(String name){
        super(name);
    }
    
    @Override
    public String speak() {
        return "Meaw!";
    }
}

class Dog extends Animal {
    public Dog(String name){
        super(name);
    }
    
    @Override
    public String speak() {
        return "Woof!";
    }
}