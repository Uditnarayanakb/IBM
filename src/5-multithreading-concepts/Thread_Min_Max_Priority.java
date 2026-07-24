public class Thread_Min_Max_Priority {
    public static void main(String[] args) {
        CustomRunnable run_obj1 = new CustomRunnable("Morning", 200);
        
        CustomRunnable run_obj2 = new CustomRunnable("Afternoon", 100);
        CustomRunnable run_obj3 = new CustomRunnable("Night", 0);

        Thread t1 = new Thread(run_obj1);
        
        Thread t2 = new Thread(run_obj2);
        Thread t3 = new Thread(run_obj3);

        t1.start();
        t2.start();
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.start();
        t3.setPriority(Thread.MAX_PRIORITY);

    }
}

// 2sec 1sec and 0secclass CustomThread extends Thread{

class CustomRunnable implements Runnable{
    private String threadName;
    private int sleep_time;
    CustomRunnable( String name, int sleep_time){
        this.threadName = name;
        this.sleep_time = sleep_time;
    }
    public void run() {
        System.out.println("Running " + threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(this.sleep_time);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");

    }

}

