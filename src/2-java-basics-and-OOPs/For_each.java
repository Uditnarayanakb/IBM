import java.util.*;
public class For_each {
    public static void main(String[] args) {
        ArrayList <String>ls = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 Employee Names:");
        for(int i=0;i<3;i++){
            String str = sc.next();
            ls.add(str);
        }
        System.out.println("The input names are as follows: ");
        for (String str : ls) {
            System.out.println(str);
        }
    }
}
