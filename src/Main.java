// Java program to demonstrate inter-thread communication
// (wait() and notify()) in Java

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final PC pc = new PC();

        // Create a thread object that calls pc.produce()
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.thread1();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create another thread object that calls
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.thread2();
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
    }
}
