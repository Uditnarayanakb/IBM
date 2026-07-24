package org.example;


public class Demo06_PerformanceService {

    public void quickOperation() throws InterruptedException {

        // Simulates a fast operation
        Thread.sleep(100);

        System.out.println("Quick Operation Completed");
    }

    public void slowOperation() throws InterruptedException {

        // Simulates a slow operation
        Thread.sleep(1000);

        System.out.println("Slow Operation Completed");
    }
}