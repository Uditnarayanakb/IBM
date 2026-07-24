
@FunctionalInterface
interface Math{
    abstract double floatCompute(double a, double b);

    default int intDivision(int a, int b){
        return a+b;
    }
    default String StringConcat(String a, String b){
        return a+b;
    }
}

public class Task_4_SAM {
    public static void main(String[] args) {
        Math calc = (x,y)-> x+y;
        System.out.println(calc.floatCompute(20.5, 30.7));
        System.out.println(calc.intDivision(20, 10));
        System.out.println(calc.StringConcat("Hello", "World"));
    }

}
