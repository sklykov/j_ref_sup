package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>(10);
        integerArrayList.ensureCapacity(21);  // increasing minimal capacity

        // filling created ArrayList
        int maxSize = 11;
        for (int i=0; i < maxSize; i++){
            integerArrayList.add(i-5); // [-5, -4 ... 5] to be stored in the ArrayList, actual initialization
        }
        integerArrayList.trimToSize(); // trim to the actual size
        System.out.println("Using ArrayList toString() method for printing: " + integerArrayList);
        System.out.println("Size of created ArrayList: " + integerArrayList.size());

        // ArrayList to array conversion
        Integer integerArray[] = new Integer[integerArrayList.size()];
        integerArray = integerArrayList.toArray(integerArray);  // right syntax to get an array of Integers
        // sum using auto-casting from Integer to int
        int sum = 0;
        for (int a: integerArray){
            sum += a;
        }
        System.out.println("Sum of elements: " + sum);

        // array to ArrayList conversions
        Integer[] testArray = {1, 2, 3, 4, 5};  // !!!: Important to specify type of array as Integer[]
        // 1st suggested method (found)
        ArrayList<Integer> testArrList = new ArrayList<>(Arrays.asList(testArray));
        System.out.println("1st method: " + testArrList);
        // 2nd suggested method (found)
        ArrayList<Integer> testArrList2 = new ArrayList<>(testArray.length);
        Collections.addAll(testArrList2, testArray);
        System.out.println("2nd method: " + testArrList2);
        // 3rd method - obvious, just iterating through array and add all values
    }
}
