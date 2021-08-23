package threads.synchronization;

public class RunTest {
    public static void main(String[] args) {
        ClassWithSyncMethods classWithSyncMethods = new ClassWithSyncMethods(3);
        ThreadedUsageOfClass thrUsg1 = new ThreadedUsageOfClass(classWithSyncMethods);
        ThreadedUsageOfClass thrUsg2 = new ThreadedUsageOfClass(classWithSyncMethods);
        Thread thread1 = new Thread(thrUsg1); Thread thread2 = new Thread(thrUsg2);
        thread1.setName("1st thread"); thread2.setName("2nd thread");
        thread1.start(); thread2.start();
    }
}
