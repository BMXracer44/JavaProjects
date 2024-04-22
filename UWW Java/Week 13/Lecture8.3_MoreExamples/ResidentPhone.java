
public class ResidentPhone {
	//add private fields: last_name, first_name, phone_number
	private String last_name;
	private String first_name;
    private String phone_number;
    
    //default constructor
    public ResidentPhone () {
   	 last_name = "unknown";
   	 first_name = "unknown";
   	 phone_number = "unknown";
    }
    //constructor with three parameters
	 public ResidentPhone(String lname, String fname, String number) {
		 last_name = lname;
		 first_name = fname;
		 phone_number = number;
	 }
	 
	 //public method: getFirstName
	 public String getFirstName() {
		 return first_name;
	 }
	 //public method: setFirstName
	 public void setFirstName(String name) {
		 first_name = name;
	 }
	//public method: getFirstName
	 public String getLastName() {
		 return last_name;
	 }
	 //public method: setFirstName
	 public void setLastName(String name) {
		 last_name = name;
	 }
	 //public method: getPhoneNumber
	 public String getPhoneNumber() {
		 return phone_number;
	 }
	 //public method: setPhoneNumber
	 public void setPhoneNumber(String number) {
		 phone_number = number;
	 }
	 
	 //public method: toString 
	 public String toString() {
		 return String.format("%s,%s: %s", last_name, first_name, phone_number);
	 }
}
