package InheritanceProject;

public class Mountainbike {
    private double weight;
    private int quantity;
    private double price;
    private String name;
    private String size;

    public Mountainbike(String name, double price){
        this.name = name;
        this.price = price;
        quantity = 1;
    }

    public void Fullsuspension(String name, double price){
        this.name=name;
        this.price = price;
        quantity = 1;
    }

    public void Dirtjumper(String name, double price){
        this.name=name;
        this.price = price;
        quantity = 1;
    }


    public String getName(){
        return name;
    }
}
