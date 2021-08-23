package threads.synchronization;

import threads.interference.ClassWithNotSyncMethod;

public class ThreadedUsageOfClass implements Runnable{
    private ClassWithSyncMethods classWithSyncMethods;
    // attach to this class the instance of ClassWithNotSyncMethod for performing of its task
    ThreadedUsageOfClass(ClassWithSyncMethods classWithSyncMethods){
        this.classWithSyncMethods = classWithSyncMethods;
    }
    @Override
    public void run() {
        classWithSyncMethods.doCountdown();
        classWithSyncMethods.doCountdown2();
    }
}
