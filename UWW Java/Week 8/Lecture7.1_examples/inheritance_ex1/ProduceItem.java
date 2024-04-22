package inheritance_ex1;

//use "extends" keyword to define the inheritance relationship among ProduceItem and GenericItem
//GenericItem is the direct superclass of the ProduceItem class
//ProduceItem is a subclass/derived class of the GenericItem class
public class ProduceItem extends GenericItem{ 
	   private String expirationDate;

	   public void setExpiration(String newDate) {
	      expirationDate = newDate;
	   }
	   public String getExpiration() {
	      return expirationDate;
	   }  
	   
	   //add a public method printProduct
	   public void printProduct() {  
		   System.out.println("Product: ");
		   printItem(); //call printItem() method inherited from GenericItem class
		   System.out.println(expirationDate);
	
	   }

	   //add a public method toString()
	   public String toString(){
			return String.format("Produce Item: %s (%d) and Expiration: %s", getName(), getQuantity(), expirationDate); //Cannot access itemName and itemQuantity because the variables are private in the Super class. Need to use public methods
	   }
		
	}