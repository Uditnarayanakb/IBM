public class Encapsulation {
    public static void main(String[] args) {
        Parent obj = new Parent("Vaishni");

        System.out.println(obj.get_name());
        
        obj.set_name("Vaishnavi");
        
        System.out.println(obj.get_name());
    }
}

class Parent{
    private String name;
    Parent(){

    }

    Parent(String name){
        this.name = name;
    }

    String get_name(){
        return this.name;
    }
    
    void set_name(String name){
        this.name = name;
    }
}
