// Business.java
public class Business {
	private String name;
	private String address;
	private Integer id;
	private int years;
	
   public Integer getId() {return id;}
   public int getYears() {return years;}
   
   public void setId(int id) { this.id = id;}
   public void setYears(int years) { this.years = years;}
   
   public void setName(String name) {
	   this.name = name;   
   }
   
   public void setAddress(String address) {
	   this.address = address;   
   }
  
   public String getName() {return name;}
   
   public String getAddress() {return address;}
      
   @Override
   public String toString() {
	   return name + " -- " + address + " -- " + id + " -- " + years;
   }
   
   @Override
   public boolean equals(Object another) {
	   Business other = (Business) another;
	   if (this.name.equals(other.name) && this.address.equals(other.address)) {
	       System.out.println("The two business have the same name and address!");
		   return true;
	   }
	   else {
		   System.out.println("The two business do not have the same name and address!");
		   return false;
	   }
   }
}