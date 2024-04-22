public class RightTriangle extends Polygon{
    
    //Creates necvessary variables
    double base;
    double height;

    //Constructor for triangle class
    public RightTriangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    //getArea() method returns area of triangle extending from Shape
    public double getArea(){
        return ((base * height) / 2);
    }

    //getPerimeter() method returns perimeter of triangle extending from Shape
    public double getPerimeter(){
        return base + height + (Math.sqrt((Math.pow(base, 2) + Math.pow(height, 2))));
    }

    //getName() method returns name of triangle extending from Shape
    public String getName(){
        return "Right Triangle"; 
    }

    //toString() method returns string of triangle extending from Shape
    public String toString(){
        return String.format("%s has an area of %.2fm^2 and a perimeter of %.2fm", getName(), getArea(), getPerimeter());
    }

    //getNumberofSides() method returns number of sides of triangle extending from polygon
    public int getNumberOfSides(){
        return 3;
    }
}