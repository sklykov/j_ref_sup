package threads.interrupt;

public class ThreadedTask implements Runnable {
    @Override
    public void run() {
        try{
            System.out.println("Threaded task in the thread '" + Thread.currentThread().getName()  + "' now stops for 3 sec");
            Thread.sleep(3000);
            System.out.println("Simulation of a task by sleeping performed");
        } catch (InterruptedException e) {
            System.out.println("I was interrupted!");
        } finally {
            // Even if the task is interrupted, here should be all closing associated actions performed
            System.out.println("");
        }
    }
}
