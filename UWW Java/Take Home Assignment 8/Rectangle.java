public class Rectangle extends Quadrilateral{
    
    //Declares necessary variables
    double length;
    double width;

    //Constructor to create a Rectangle
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    //getArea() method returns area of rectangle extending from Shape
    public double getArea() {
        return (length * width);
    }

    //getPerimeter() method returns perimeter of rectangle extending from Shape
    public double getPerimeter() {
        return 2 * (length + width);
    }

    //getName() method returns name of rectangle extending from Shape
    public String getName(){
        return "Rectangle";
    }

    //toString() method returns string of rectangle extending from Shape
    public String toString(){
        return String.format("%s has an area of %.2fm^2 and a perimeter of %.2fm", getName(), getArea(), getPerimeter());
    }
}