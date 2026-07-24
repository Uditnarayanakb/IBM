public class Multiple_inheritence {
    public static void main(String[] args) {
        
    }
}

/**
 * InnerMultiple_inheritence
 */

interface Vehicle {
    String fuel_type = "Petroleum";
    void display_name();
}

interface Bike extends Vehicle {
    void de();
}

interface Car extends Vehicle{
    void display_name();
}

class Tripla implements Bike, Car{
    void display_name(){
        System.out.println("Triplaaaa");
    }
}
