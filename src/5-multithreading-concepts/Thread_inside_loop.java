public class Thread_inside_loop {
    public static void main(String[] args) {
        // Thread.dumpStack();
        for(int i=1; i<=3; i++){
            String str ="Task"+i;
            Thread t = new Thread(new CustomRunnable(str, 100));
            t.start();
            System.out.println(str+".isAlive: "+ t.isAlive());
            
        }
        // Thread.dumpStack();
    }
}

class CustomRunnable implements Runnable{
    private String threadName;
    private int sleep_time;
    CustomRunnable( String name, int sleep_time){
        this.threadName = name;
        this.sleep_time = sleep_time;
    }
    public synchronized void run() {
        System.out.println("Running " + threadName);
        try {
            /* Print 4 Lines */
            {
                for(int i = 4; i > 0; i--) {
                    System.out.println("Thread: " + threadName + ", " + i);
                    // Thread.dumpStack();
                    Thread.sleep(this.sleep_time);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");

    }

}
