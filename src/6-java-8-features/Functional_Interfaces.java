import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional_Interfaces {
    public static void main(String[] args) {
        // Predicate, Supplier, Function
        Predicate<Boolean> complement = (flag) -> !flag ;
        System.out.println(complement.test(false));

        Function <Integer, Float> convert_to_float = int_num -> (float)int_num;
        System.out.println(convert_to_float.apply(10));

        Supplier <String> password = () -> "Test@123";
        System.out.println(password.get());


    }
}


interface Java8_Interfaces{

}