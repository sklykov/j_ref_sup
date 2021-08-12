package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionArraysMethods {
    // demo of various useful manipulation methods
    public static void main(String[] args) {
        int[] intAr = {1, -1, -2, 0, 0, 13, 5, -8, -10, 3};
        int[] sortedIntAr = new int[intAr.length];
        sortedIntAr = Arrays.copyOf(intAr, intAr.length); // copying of array content
        Arrays.sort(sortedIntAr); // sorting
        String intArStr = Arrays.toString(intAr); // normal representation to String
        String sortedIntArStr = Arrays.toString(sortedIntAr);
        System.out.println(intArStr + " sorted => " + sortedIntArStr);

        // same for ArrayList
        // simple conversion from int[] to ArrayList<Integer> doesn't work, as one liner use streams. Below - workaround
        ArrayList<Integer> intArList = new ArrayList<>(intAr.length);
        for (int a: intAr) intArList.add((Integer) a);  // conversion from array to ArrayList
        // System.out.println(intArList);
        ArrayList<Integer> sortedIntArList = new ArrayList<>(intArList); // way to copy values from one to another during initialization
        // System.out.println(sortedIntArList);
        // Collections.copy(sortedIntArList, intArList); // doesn't work if destination ArL only initialized
        Collections.sort(sortedIntArList);
        System.out.println(intArList + " sorted => " + sortedIntArList);

    }
}
