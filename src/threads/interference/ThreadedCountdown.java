package threads.interference;

public class ThreadedCountdown implements Runnable {
    private int i;  // even primitive variable put on class heap, upon creation and ALL class instances shares this variable

    @Override
    public void run() {
        // performing simple counting down operation upon declared class variable
        for(i = 3; i > 0; i--){
            System.out.println("Thread '" + Thread.currentThread().getName() + "' counts i to: " + i);
        }
    }
}
