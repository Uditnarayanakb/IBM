import java.util.Scanner;

public class Nested_if_else {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if(num > 100){
            if(num < 150){
                System.out.println("The number is smaller than 150");
            }
            else{
                System.out.println("The number is greater than 150");
            }
        }
        else{
            if(num < 50){
                System.out.println("The number is smaller than 50");
            }
            else{
                System.out.println("The number is greater than 50");
            }
        }
    }
}
