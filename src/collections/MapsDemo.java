package collections;

import java.util.*;

public class MapsDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> elementsHM = new HashMap<>();
        TreeMap<String, Integer> elementsTM = new TreeMap<>();
        LinkedHashMap<String, Integer> elementsLHM = new LinkedHashMap<>();

        // ascending order (from periodic table) of adding
        elementsHM.put("Hydrogen", 1); elementsHM.put("Helium", 2); elementsHM.put("Lithium", 3); elementsHM.put("Boron", 5);
        elementsTM.put("Hydrogen", 1); elementsTM.put("Helium", 2); elementsTM.put("Lithium", 3); elementsTM.put("Boron", 5);
        elementsLHM.put("Hydrogen", 1); elementsLHM.put("Helium", 2); elementsLHM.put("Lithium", 3); elementsLHM.put("Boron", 5);

        // get Set of entries for both trees
        Set<Map.Entry<String, Integer>> setHM = elementsHM.entrySet();
        Set<Map.Entry<String, Integer>> setTM = elementsTM.entrySet();
        Set<Map.Entry<String, Integer>> setLHM = elementsLHM.entrySet();

        // difference in orders provided by HashMap, TreeMap and LinkedHashMap
        System.out.print("HashMap provides: ");
        for (Map.Entry<String, Integer> el: setHM){
            System.out.print(el.getKey() + ":" + el.getValue() + "  ");
        }
        System.out.println();
        System.out.print("**********************************************************");
        System.out.println();
        System.out.print("TreeMap provides: ");
        for (Map.Entry<String, Integer> el: setTM){
            System.out.print(el.getKey() + ":" + el.getValue() + "  ");
        }
        System.out.println();
        System.out.print("**********************************************************");
        System.out.println();
        System.out.print("LinkedHashMap provides: ");
        for (Map.Entry<String, Integer> el: setLHM){
            System.out.print(el.getKey() + ":" + el.getValue() + "  ");
        }
    }
}
