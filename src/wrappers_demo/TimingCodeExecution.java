package wrappers_demo;

public class TimingCodeExecution {
    public static void main(String[] args) {
        // simple timing of the code execution
        long startTime, finishTime;
        startTime = System.currentTimeMillis(); // get the current time in ms since 1st Jan 1970
        // some computation
        int[] array = new int[5_000_000];
        for (int i = 0; i < 5_000_000; i++){
            array[i] = i*i - 1000*i;
        }
        // checking passed time
        finishTime = System.currentTimeMillis();
        System.out.println("Passed time [ms]: " + (finishTime - startTime));
    }
}
