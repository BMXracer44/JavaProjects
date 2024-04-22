import java.util.*;

public class Main{
    public static void main(String[] args){

        //Creates list for the shapes to be assigned to
        Shape[] shapes = new Shape[7];

        //Creates all of the shapes
        shapes[0] = (new Circle(5));
        shapes[1] = (new Rectangle(7, 9));
        shapes[2] = (new Square(10));
        shapes[3] = (new RightTriangle(2, 8));    
        shapes[4] = (new Circle(6));
        shapes[5] = (new RightTriangle(5, 5));
        shapes[6] = (new Rectangle(10, 10));

        System.out.println("\n---All Shapes---\n");

        //Prints out all of the shapes in the order of which they were assigned
        for(Shape shape : shapes){
            System.out.println(shape.toString());
        }

        System.out.println("\n---Shapes sorted by area---\n");

        //Sorts the list by area
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getArea));

        //Prints out all the shapes sorted by areas
        for(Shape shape : shapes){
            System.out.println(shape.toString());
        }

        System.out.println("\n---Top 5 shapes by perimeter---\n");

        //Sorts all the shapes by perimeter and then reverses the list
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getPerimeter).reversed());

        //Prints out 5 of the shapes with the greatest perimeter
        for(int i = 1; i < 6; i++){
            System.out.println(i + ". " + shapes[i-1].toString());
        }

        
    }
}
