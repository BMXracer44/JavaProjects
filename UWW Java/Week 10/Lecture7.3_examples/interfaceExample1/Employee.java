package interfaceExample1;
// Employee.java
// Employee abstract superclass that implements Payable.

public abstract class Employee implements Payable {  //Payable interface, add common functionality: getPaymentAmount()
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;

   // constructor
   public Employee(String firstName, String lastName, 
      String socialSecurityNumber) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;
   } 

   // return first name
   public String getFirstName() {return firstName;}

   // return last name
   public String getLastName() {return lastName;}

   // return social security number
   public String getSocialSecurityNumber() {return socialSecurityNumber;}

   // return String representation of Employee object
   @Override
   public String toString() {
      return String.format("%s %s%nsocial security number: %s", 
         getFirstName(), getLastName(), getSocialSecurityNumber());
   }

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here

   // must implement getPaymentAmount (i.e., provide concrete definition of the method) here enables the entire Employee
   // class hierarchy to be used in an app that processes Payables 
   @Override     
   public double getPaymentAmount(){
      return earnings();
   }            
} 


