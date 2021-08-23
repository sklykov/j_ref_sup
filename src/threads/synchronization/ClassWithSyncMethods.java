package threads.synchronization;

public class ClassWithSyncMethods {
    private int counts;

    ClassWithSyncMethods(int count){this.counts = counts;}

    // the method is entirely synchronized that prevent to interference between threads using this method
    public synchronized void doCountdown(){
        if (this.counts < 1){ this.counts = 3;}

        for ( ; this.counts > 0; this.counts--){
            System.out.println("Thread '" + Thread.currentThread().getName() + "' counts i to: " + counts);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("*******1st task completed by " + Thread.currentThread().getName() + "*******");
    }
    // another approach to synchronization - use some object (class instance) and force to be synchronized, e.g. by using this
    public synchronized void doCountdown2(){
        if (this.counts < 1){ this.counts = 3;}
        synchronized (this){
            for ( ; this.counts > 0; this.counts--){
                System.out.println("Thread '" + Thread.currentThread().getName() + "' counts i to: " + counts);
            }
        }
        System.out.println("*******2nd task completed by " + Thread.currentThread().getName() + "*******");
    }
}
