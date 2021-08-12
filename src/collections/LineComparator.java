package collections;

import java.util.Comparator;

public class LineComparator implements Comparator<Line> {

    @Override
    public int compare(Line o1, Line o2) {
        double length1 = o1.getLength();
        double length2 = o2.getLength();
        if (length1 > length2) return 1;
        else if (length1 == length2 || Math.abs((length1 - length2)) < 0.0001) return 0;
        else return -1;
    }
}
