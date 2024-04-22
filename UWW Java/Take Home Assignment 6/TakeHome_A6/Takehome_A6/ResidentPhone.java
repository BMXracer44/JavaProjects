package Takehome_A6;

public class ResidentPhone {
	//add private fields: last_name, first_name, phone_number
	private String last_name;
	private String first_name;
	private String phone_number;
	
    
    //default constructor
	public ResidentPhone(){
		last_name = null;
		first_name = null;
		phone_number = null;
	}
    
    //constructor with three parameters
	public ResidentPhone(String first_name, String last_name, String phone_number){
		this.last_name = last_name;
		this.first_name = first_name;
		this.phone_number = phone_number;
	}
	 
	 
	 //public method: getFirstName
	 public String getFirstName(){
		return first_name;
	 }
	 
	 //public method: setFirstName
	 public void setFirstName(String first_name){
		this.first_name = first_name;
	 }
	 
	//public method: getLastName
	public String getLastName(){
		return last_name;
	}
	
	 //public method: setLastName
	public void setLastName(String last_name){
		this.last_name = last_name;
	}
	 
	 //public method: getPhoneNumber
	public String getPhoneNumber(){
		return phone_number;
	}
	
	 //public method: setPhoneNumber
	public void setPhoneNumber(String phone_number){
		this.phone_number = phone_number;
	}
	 
	 
	 //public method: toString 
	public String toString(){
		return last_name + ", " + first_name + ": " + phone_number;
	}

}
