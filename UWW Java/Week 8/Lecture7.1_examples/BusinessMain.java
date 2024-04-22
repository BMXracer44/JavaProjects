
public class BusinessMain {

	public static void main(String[] args) {
//Part-1: use toString() method with vs. without overriding in derived class
		 Object myObj = new Object();
	     Integer num = 100;
	     Business someBusiness = new Business();     

	     // Call toString() on each object and print result
	     System.out.println("myObj = " + myObj.toString()); //call toString() method defined in Object class
	     System.out.println("myObj = " + myObj); 
	     System.out.println("num = " + num.toString());//call toString() method defined in Integer class
	     System.out.println("num = " + num);
	     System.out.println("someBusiness = " + someBusiness.toString());
	     System.out.println("someBusiness = " + someBusiness);//call toString() method defined in Object class
	
	     // toString() method will be automatically called by default when print out object instance 
	     Business aaaBus = new Business();
	     Restaurant tacoRest = new Restaurant();

	     aaaBus.setName("AAA Business");
	     aaaBus.setAddress("5 Race St");

	     tacoRest.setName("Tom's Tacos");
	     tacoRest.setAddress("600 Pleasure Ave");
	     tacoRest.setRating(5);
	     
	     System.out.println(aaaBus);
	     System.out.println(tacoRest);

//Part-2: use equals() method with or without overriding in derived class	   
	     boolean compareResult = aaaBus.equals(tacoRest);
	     System.out.println("compare result-1: " + compareResult);
	     
	     tacoRest.setName(aaaBus.getName());
	     tacoRest.setAddress(aaaBus.getAddress());
	     compareResult = aaaBus.equals(tacoRest);
	     System.out.println("compare result-2: " + compareResult);
	}

}
