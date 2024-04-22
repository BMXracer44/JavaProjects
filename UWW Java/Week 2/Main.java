import Test.*;
//Unit 2.1

//"Public" is an access/modifier which specifies the scope of a field, method, constructor, or class. 
//"Public" Means that class can be accessed by and classes from any package

//Protected is accessible in the same package and outside the packkage in a child class. 
//"Private" is only accessible inside the package

class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Test.print(); //Call print method from Test class
        //Test2.print(); //Call print method from Test2 Class
    }
}