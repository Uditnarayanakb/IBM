import java.util.function.Supplier;

public class Hello_lambda {
    public static void main(String []args){
        // System.out.println("");
        Runnable helloWorld = ()->System.out.println("Hello World");
        helloWorld.run();

        Supplier<String> printHello = ()->"Hello";

        System.out.println(printHello.get());
    }
}
