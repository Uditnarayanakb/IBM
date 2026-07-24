import java.util.Scanner;
public class Swtich_case {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a Case, 1 or 2: ");
        int num = sc.nextInt();

        switch (num) {
            case 1:
                System.out.println("You have choosen case 1.");
                break;

            case 2:
                System.out.println("You have choosen case 2.");
                break;

            default:
                System.out.println("You have choosen Default Case.");
                break;
        }

        sc.close();
    }
}
