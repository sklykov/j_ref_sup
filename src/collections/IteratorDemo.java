package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {

    public static void main(String[] args) {
        // demo of obtaining Iterator and ListIterator
        ArrayList<Integer> integerArL = new ArrayList<>();
        int size = 5;
        for (int i = 1; i <= size; i++){
            integerArL.add(i);
        }
        Iterator iterator = integerArL.iterator();
        ListIterator listIterator = integerArL.listIterator(integerArL.size()); // initialized to point to the end of the ArrayList
        System.out.print("Using Iterator to access elements in direct order: ");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.print("Using ListIterator to access elements in reverse order: ");
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + " ");
        }
    }
}
