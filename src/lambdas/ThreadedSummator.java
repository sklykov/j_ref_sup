package lambdas;

public class ThreadedSummator implements Runnable {
    private int sum = 0;
    private int[] numbers;

    ThreadedSummator(int[] numbers){
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int number: numbers){
            this.sum += number;
        }
        System.out.println("Sum from independent class: " + sum);
    }

    public int getSum() {
        return sum;
    }
}
