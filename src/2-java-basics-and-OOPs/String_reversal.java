import java.util.Scanner;
class String_reversal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");

        String str = sc.next();
        String new_str = "";

        for(int i=str.length()-1;i>=0; i--){
            new_str+= str.charAt(i);
        }  
        System.out.println("String after reversal: "+ new_str);
        sc.close();
    }
}