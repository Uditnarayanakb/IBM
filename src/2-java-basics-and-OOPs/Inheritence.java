public class Inheritence {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.display_name();

        Car verna = new Car();
        verna.display_name();

        Bike apache = new Bike();
        apache.display_name();
    }
}


class Vehicle{
    String fuel = "Petroleum";
    void display_name(){
        System.out.println("This is generic Vehicle. It runs on: " + fuel);
    }
}

class Car extends Vehicle{
    Car(){
        this.fuel = "Diesel";
    }
    void display_name(){
        System.out.println("This vehicle is a Car. It runs on: " + fuel);
    }
}

class Bike extends Vehicle{
    Bike(){
        this.fuel = "Petrol";
    }
    void display_name(){
        System.out.println("This vehicle is a Bike. It runs on: "+fuel);
    }
}

// class Tripla extends Car, Bike{
//     void display_name(){
//         System.out.println("This vehicle is a Hybrid of bike and Car. It is a bike with 4 wheels");
//     }
// }

