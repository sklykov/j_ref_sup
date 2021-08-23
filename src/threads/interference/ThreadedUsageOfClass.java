package threads.interference;

public class ThreadedUsageOfClass implements Runnable{
    private ClassWithNotSyncMethod classWithNotSyncMethod;
    // attach to this class the instance of ClassWithNotSyncMethod for performing of its task
    ThreadedUsageOfClass(ClassWithNotSyncMethod classWithNotSyncMethod){
        this.classWithNotSyncMethod = classWithNotSyncMethod;
    }
    @Override
    public void run() {
        classWithNotSyncMethod.doCountdown();
    }
}
