public class Circle extends Shape {

    //Declares necessary variables
    double radius;

    //Constructor to create a Circle
    public Circle(double radius){
        this.radius = radius;
    }

    //getRadius() method returns radius of circle extending from Shape
    public double getRadius() {
        return radius;
    }

    //getName() method returns name of circle extending from Shape    
    public String getName(){
        return "Circle";
    }
    
    //getArea() method returns area of circle extending from Shape
    public double getArea(){
        return Math.PI * (Math.pow(radius, 2));
    }

    //getPerimeter() method returns perimeter of circle extending from Shape
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    //toString() method returns string of circle extending from Shape
    public String toString(){
        return String.format("%s has an area of %.2fm^2 and a perimeter of %.2fm", getName(), getArea(), getPerimeter());
    }

} 
