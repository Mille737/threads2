import java.util.Scanner;

// PC (Produce Consumer) class with produce() and
// consume() methods.
public class PC {
    // Prints a string and waits for consume()
    public void produce()throws InterruptedException
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

    // Sleeps for some time and waits for a key press. After key
    // is pressed, it notifies produce().
    public void consume()throws InterruptedException
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
