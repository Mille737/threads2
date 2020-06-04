// Java program to demonstrate inter-thread communication
// (wait(), join() and notify()) in Java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {

        final PC pc = new PC();

        // Create a thread object that calls pc.produce()
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create another thread object that calls
        // pc.consume()
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }
}
