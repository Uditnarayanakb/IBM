public class Hello {
    void display(){
        System.out.println("This is my name: ");
    }

    public static void main(String[] args) {
        Fruit f1 = new Fruit("Apple", "Sweet");

        
        Fruit f2 = new Fruit("Lemon", "Sour");

        System.out.println("Fruit 1: "+ f1.name +" " + f1.flavour);
        System.out.println("Fruit 2: "+ f2.name +" " + f2.flavour);


    }
}

class Fruit{
    String name;
    String flavour;

    Fruit(String name, String flavour){
        this.name = name;
        this.flavour = flavour;
    }
}

