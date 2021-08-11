package collections;

import java.util.ArrayList;

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
        int intArray[] = new int[integerArrayList.size()];
        integerArray = integerArrayList.toArray(integerArray);  // right syntax to get an array of Integers
        // sum using autocasting from Integer to int
        int sum = 0;
        for (int a: integerArray){
            sum += a;
        }
        System.out.println("Sum of elements: " + sum);
    }
}
