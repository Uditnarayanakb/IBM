import java.util.ArrayList;
import java.util.Arrays;

public class Task_6_for_each_arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 31, 40, 51));
        // System.out.println(list.toString());
        list.forEach((element)->{
            if(element%2 == 0){
                System.out.println(element+": Even");
            }
            else{
                System.out.println(element+": Odd");
            }
        });
    }
}

