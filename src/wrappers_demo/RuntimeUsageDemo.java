package wrappers_demo;

import java.util.ArrayList;

public class RuntimeUsageDemo {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime(); // no new constructors available
        // get total and free memories
        long totalMemory = r.totalMemory();
        totalMemory /= (1024*1024);
        System.out.println("Total memory available [Mb]: " + totalMemory);
        long freeMemory = r.freeMemory();
        freeMemory /= (1024*1024);
        System.out.println("Free memory available before 2D matrix creation [Mb]: " + freeMemory);

        // a bit heavy array using - initializing kind of 2D imaged or 2D matrix
        ArrayList<ArrayList<Integer>> likeImage = new ArrayList<>();
        for (int i = 0; i < 1000; i++){
            ArrayList<Integer> rows = new ArrayList(1000);
            for (int j = 0; j < 1000; j++){
                rows.add(j, j-i);
            }
            likeImage.add(i, rows);
        }
        freeMemory = r.freeMemory(); // checking how much free memory left
        freeMemory /= (1024*1024);
        System.out.println("Free memory after 2D matrix creation [Mb]: " + freeMemory);

        // invoking garbage collection and checking state after
        r.gc();
        long maxMemory = r.maxMemory();
        maxMemory /= (1024*1024);
        freeMemory = r.freeMemory();
        freeMemory /= (1024*1024);
        System.out.println("Free memory after invoking garbage collection [Mb]: " + freeMemory);
        System.out.println("Max available memory [Mb]: " + maxMemory);

    }
}
