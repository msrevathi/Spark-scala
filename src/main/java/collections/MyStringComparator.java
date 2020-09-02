package collections;

import java.util.Comparator;

public class MyStringComparator implements Comparator {
    // Descending order
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = o2.toString();
        // return -s1.compareTo(s2); //or
        return s2.compareTo(s1);
    }
}

