import java.util.Scanner;

public class PC {
    // Prints a string and waits for thread2()
    public void thread1()throws InterruptedException
    {
        // synchronized block ensures only one thread
        // running at a time.
        synchronized(this)
        {
            System.out.println("First thread started");

            // releases the lock on shared resource
            wait();

            // and waits till some other method invokes notify().
            System.out.println("First thread resumed");
        }
    }

    public void thread2()throws InterruptedException
    {
        Thread.sleep(5000);

        // synchronized block ensures only one thread
        // running at a time.
        synchronized(this)
        {
            System.out.println("Second thread started");

            // notifies the first thread that it
            // can wake up.
            notify();
            // Sleep
            Thread.sleep(7000);
            System.out.println("I must be printed");

        }
    }
}
