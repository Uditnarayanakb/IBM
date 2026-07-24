import java.util.Scanner;   

public class Login_check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.print("Enter your login id: ");
            String login_id = sc.next();
            System.out.print("Enter your password: ");
            String password = sc.next();
            System.out.println(login_id + "  "+ password);

            if (login_id.equals("Prasunamba") && password.equals("4321")) {
                System.out.println("Welcome to the System");
                break;
            }
            else{
                System.out.println("Invalid Credentials");
            }
        }
        

    }
}
