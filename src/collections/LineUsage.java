package collections;

import java.util.TreeSet;

public class LineUsage {

    public static void main(String[] args) {
        // construction of TreeSet with custom comparator for Line class, there lines will be sorted on their length
        TreeSet<Line> lines = new TreeSet<>(new LineComparator());
        Line line1 = new Line(0, 0, 1, 1);
        Line line2 = new Line(0, 0, 2, 2);
        Line line3 = new Line(0, 0, 1, 3);
        lines.add(line1); lines.add(line2); lines.add(line3);
        System.out.println("Composed lines :" + lines);
    }
}
