package lambdas_util_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class TestingSimpleLambdas {

    public static void main(String[] args) {
        int[] numbersArray = {1, -1, 2, 3, 4, 9, 10, -5, -99, -1, 10};
        ArrayList<Integer> initialArray = new ArrayList<>(numbersArray.length);
        ArrayList<Integer> filteredArray = new ArrayList<>(numbersArray.length);
        for (int a: numbersArray) initialArray.add(a);

        // Using Predicate as the applied single line method
        // defining the lambda function:
        IntPredicate greaterZero = i -> i > 0;
        // applying it to all elements:
        for(Integer a: initialArray){
            // checking the input parameters and filter out not consistent
            if (greaterZero.test(a)){
                filteredArray.add(a);
            }
        }
        System.out.println("Filter applied: " + filteredArray);

        // using Consumer interface for ArrayList -> applied as lambda function for each element
        System.out.print("Initial array: ");
        initialArray.forEach((Integer a) -> System.out.print(a + " "));

        // using Function for performing some tasks
        System.out.println();
        Function<String, String> stringHandling = s -> {;
           return s.toUpperCase();
        };
        System.out.println("abba => " + stringHandling.apply("abba"));

        // another way of applying of methods:
        filteredArray.clear();
        initialArray.forEach((Integer i) -> {
            if (i < 0){
                filteredArray.add(i);
            }
        });
        System.out.print("Only negative numbers: ");
        filteredArray.forEach(System.out::print); // only some operation that can be applied to all values => no spaces added between
    }
}
