package threads.interrupt;

public class TestRun {
    // demonstration of how the threaded task could be interrupted
    public static void main(String[] args) {
        ThreadedTask threadedTask = new ThreadedTask();
        Thread task = new Thread(threadedTask);
        // experiments show that running new task should be carefully performed! the same task could be re-run until it completes!
        task.start();
        task.interrupt(); // interruption by the main thread
        // even after sending above commands, the main thread could run faster than launched one that causes the exception
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("*****another run without interruption*****");
        // task.start();  // seems that it's impossible to re-run the same thread, so re-create it below
        task = new Thread(threadedTask);
        task.start();
        try {
            task.join(); //suspend this main thread till the task completes
        } catch (InterruptedException e) {}

        // mixing up two methods: run() and start():
        System.out.println("*****another run*****");
        task = new Thread(threadedTask); task.setName("Not main thread");
        Thread.currentThread().setName("Main thread");
        task.run(); // the method run() will be run by the Main thread!
        task.start();  // the task can be relaunched but now properly attached to the another thread
    }
}
