public class Swap {
    public static void main(String[] args) {
        int x = 10, y = 20;

        System.out.println("value of x and y: "+x+" "+y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("value of x and y: "+x+" "+y);
    }
}
