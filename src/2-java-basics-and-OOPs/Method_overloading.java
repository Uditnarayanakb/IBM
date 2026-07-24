public class Method_overloading {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.print_num(2);

        obj.print_num(1, 4);
        
    }
}

class Parent{

    void print_num(int num){
        System.out.println("This is num: "+num);
    }
}

class Child extends Parent{
    void print_num(int num1, int num2){
        System.out.println("These are the numbers: "+num1+" "+num2);
    }
}
