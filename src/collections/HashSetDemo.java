package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetDemo {

    public static void main(String[] args) {
        // just simple creation / exploring
        // Note that HashSet has the advantage in performing access to its elements operations (add, remove, size ...)
        HashSet<String> stringHashSet = new HashSet<>(5);
        stringHashSet.add("A"); stringHashSet.add("B"); stringHashSet.add("F"); stringHashSet.add("D"); stringHashSet.add("C");
        System.out.println("Order of the added to HashSet elements: A, B, F, D, C");
        System.out.println("Represented by toString() order in HashSet: " + stringHashSet);
        stringHashSet.remove("A");
        System.out.println("HashSet size after removing 1 element: " + stringHashSet.size());

        // comparing with LinkedHashSet
        LinkedHashSet<String> stringLinkedHashSet = new LinkedHashSet<>(5);
        stringLinkedHashSet.add("A"); stringLinkedHashSet.add("B"); stringLinkedHashSet.add("F"); stringLinkedHashSet.add("D");
        stringLinkedHashSet.add("C");
        System.out.println("Order of the added to LinkedHashSet elements: A, B, F, D, C");
        System.out.println("Represented by toString() order in LinkedHashSet: " + stringLinkedHashSet);

        // get rid of repeating values by implementing coversion from ArrayList to LinkedHashSet
        int arrayInt[] = {1, 1, 2, 2, 2, 3, 4, 5, 5, 5};
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int element: arrayInt) integerArrayList.add(element); // re-assignment elements
        LinkedHashSet<Integer> intLHS = new LinkedHashSet<>(integerArrayList); // conversion of both types
        System.out.println("ArrayList " + integerArrayList + " to LinkedHashSet " + intLHS);

    }
}
