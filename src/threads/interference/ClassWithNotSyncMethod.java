package threads.interference;

public class ClassWithNotSyncMethod {
    private int iterations;

    ClassWithNotSyncMethod(int iterations){this.iterations = iterations;}

    public void doCountdown(){
        if (this.iterations < 1){ this.iterations = 3;}

        for ( ; this.iterations > 0; this.iterations--){
            System.out.println("Thread '" + Thread.currentThread().getName() + "' counts i to: " + iterations);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }
}
