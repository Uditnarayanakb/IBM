public class Break_and_continue {
    public static void main(String[] args) {
        for(int i=0;i<10; i++){
            if (i==3){
                break;
            }
            System.out.print(i+" ");
        }
        System.out.println("loop exited when i became 3");
        
        for(int i=0;i<10; i++){
            if (i>2 && i<7){
                continue;
            }
            System.out.print(i+" ");
        }
        System.out.println("loop skipped the values between 2 and 7");
        
    }
}
