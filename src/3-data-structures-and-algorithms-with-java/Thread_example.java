public class Thread_example {
    public static void main(String[] args) {
        
    }
}


class Runnable_demo implements Runnable{
    private Thread t;
    private String threadName;

    Runnable_demo(String threadName){
        this.threadName = threadName;
    }
}

Runnable_demo.start() --> Thread.start() --> Runnable_demo.run()
