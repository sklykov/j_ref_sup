package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ElementsSortingByLambda {

    // for printing names of elements stored in the array list
    static void printElements(ArrayList<Element> elements){
        for (Element element: elements){
            System.out.print(element.getShortName() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Element> elements = new ArrayList<>(5);
        Element H = new Element("H", 1, 1);
        Element D = new Element("D", 2, 1);
        Element T = new Element("T", 3, 1);
        Element He = new Element("He", 4, 2);
        Element Li = new Element("Li", 7, 3);
        elements.add(T); elements.add(Li); elements.add(H); elements.add(He); elements.add(D);
        System.out.print("Initial order: "); printElements(elements);

        // comparing explicitly by overriding Comparator functional interface
        Collections.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element element1, Element element2) {
                if (element1.getChargeNumber() > element2.getChargeNumber()) return 1;
                else if (element1.getChargeNumber() < element2.getChargeNumber()) return -1;
                else if (element1.getAtomicWeight() > element2.getAtomicWeight()) return 1;
                else return -1;
            }
        });
        System.out.print("Sorted by explicit Comparator: "); printElements(elements);

        // Same task but accomplished by using lambda function for more concise syntax and call
        elements.clear();
        elements.add(T); elements.add(Li); elements.add(H); elements.add(He); elements.add(D);
        // So, lambda function implicitly implements Comparator function interface by code below
        // The type of element1 and element2 automatically inferred from elements ArrayList
        // This example is inspired by Java Masters Udemy course
        Collections.sort(elements, (element1, element2) -> {
            if (element1.getChargeNumber() > element2.getChargeNumber()) return 1;
            else if (element1.getChargeNumber() < element2.getChargeNumber()) return -1;
            else if (element1.getAtomicWeight() > element2.getAtomicWeight()) return 1;
            else return -1;
        });
        System.out.print("Sorted by implicit lambda: "); printElements(elements);
    }
}
