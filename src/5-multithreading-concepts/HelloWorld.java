import java.util.*;

class Parent{
    void method1(){
        int age = 40;
        System.out.println(age);
    }
}

class Child extends Parent{
    void method2(){
        // System.out.println(super.method1());
    }
}

class HelloWorld{
    public static void main(String []args){
        
        System.out.println("HelloWorld");
        
        // Child obj = new Child();
        // obj.method2();
    }
}