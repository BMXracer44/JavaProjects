package Test;

public class Test { //Public class can be accessed anywhere
    public static void print(){
     System.out.println("Hello from test class!");
    }
}

class Test2{ //Not public, accessible form inside the package only
    public static void print(){
        System.out.println("Hello from test class!");
    }
}
