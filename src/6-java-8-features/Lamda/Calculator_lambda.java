
@FunctionalInterface
interface Math{
    double perform(int a, int b);
}

public class Calculator_lambda {
    public static void main(String[] args) {
        Math add = (a, b) -> a+b;
        Math subtract = (a, b) -> a-b;
        Math multiply = (a, b) -> a*b;
        Math division = (a, b) -> a/b;

        System.out.println(add.perform(20, 10));
        System.out.println(subtract.perform(20, 10));
        System.out.println(multiply.perform(20, 10));
        System.out.println(division.perform(20, 10));

    }
}
