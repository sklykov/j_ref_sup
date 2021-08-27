package lambdas;

import java.util.ArrayList;

public class TestRun {

    public static void main(String[] args) {
        int numbers[] = {-1, 2, -4, 7, 1, -3, 2, 0, 1};
        // using anonymous class to create independent thread for sum calculation
        new Thread(new ThreadedSummator(numbers)).start();

        // using simple lambda function passing the same task to functional interface - Runnable
        new Thread(() -> { int sum = 0;
            for (int number:numbers){ sum+= number; }
            System.out.println("Sum from lambda: " + sum);  // impossible to return the number
        }).start();

        // using lambda for checking that number is even using own functional interface
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        // NOTE: below, number and divisor hasn't been declared as any type variables, their type inferred from the functional
        // interface declaration (see interface CheckNumber). So, it only defines the operation applied as the lambda function
        CheckNumber even = ((number, divisor) -> (number % divisor) == 0);
        System.out.print("Initial array: ");
        for (int number:numbers){
            System.out.print(number + " ");
            if (even.check(number, 2)) evenNumbers.add(new Integer(number));
        }
        System.out.println();
        System.out.println("Collected even numbers: " + evenNumbers);
    }
}
