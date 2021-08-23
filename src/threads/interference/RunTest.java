package threads.interference;

public class RunTest {
    // so, below, is a simple example of running independent task on two different threads
    // plus unsafe run of a task on two independent threads that caused the interference between them
    public static void main(String[] args) {
        // actually, below is demonstration that it's safe to create two instances of a similar class implemented Runnable interface
        // they don't share the same variable stored on a heap
        ThreadedCountdown thrCnt1 = new ThreadedCountdown();
        ThreadedCountdown thrCnt2 = new ThreadedCountdown();
        Thread thread1 = new Thread(thrCnt1);  // creating of a new thread by providing class that implemented Runnable interface
        Thread thread2 = new Thread(thrCnt2);
        thread1.setName("Thread 1"); thread2.setName("Thread 2");
        thread1.start(); thread2.start();
        // for preventing of main thread going to perform other demos, use join() method to suspend main thread to wait completing of others
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {}

        // actual interference between threads demo
        System.out.println("***************another demo***************");
        ClassWithNotSyncMethod classWithNotSyncMethod = new ClassWithNotSyncMethod(7);
        ThreadedUsageOfClass thrUsage1 = new ThreadedUsageOfClass(classWithNotSyncMethod);
        ThreadedUsageOfClass thrUsage2 = new ThreadedUsageOfClass(classWithNotSyncMethod);
        thread1 = new Thread(thrUsage1); thread2 = new Thread(thrUsage2);
        thread1.setName("1st task"); thread2.setName("2nd task");
        thread1.start(); thread2.start();
    }
}
