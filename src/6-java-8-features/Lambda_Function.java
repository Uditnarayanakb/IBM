public class Lambda_Function {
    public static void main(String[] args) {
        Runnable obj1 = new Runnable() {
            public void run(){
                System.out.println("hello world");
            }
        };

        obj1.run();

        Runnable obj2 = ()->{
            System.out.println("This runnable object 2");
        };
        
        obj2.run();

        /*------------------------------ */
        Operation sum = (int a, int b)->{
            return a+b;
        };

        Operation multiplication = (int a, int b)->{
            return a*b;
        };

        System.out.println(sum.operation(4, 5));
        System.out.println(multiplication.operation(4, 5));
    }
}

/**
 * InnerLambda_Function
 */
interface Operation {
    int operation(int a, int b);
}



