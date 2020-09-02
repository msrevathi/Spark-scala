package collections;

import java.util.Comparator;

public class MyIntegerComparator implements Comparator {
    // Descending order
    public int compare(Object o1, Object o2) {
        int i1 = (Integer) o1;
        int i2 = (Integer) o2;
        if (i1 > i2)
            return -1;
        else if (i1 < i2)
            return 1;
        else return 0;
    }
// Other implementations of compare()

        //1.
        // return i1.compareTo(i2); // Default sorting order. i.e ascending : : [5, 10, 15, 20]
        //2.
        //return -i1.compareTo(i2); // Descending order: [20, 15, 10, 5]
        //3.
        //return i2.compareTo(i1);// Descending order: [20, 15, 10, 5]
        //4.
        //return -i2.compareTo(i1);// Default sorting order. i.e ascending : [5, 10, 15, 20]
        //5.
        //return 1;// insertion order : [10, 5, 15, 5, 20, 20]
        //6.
        //return -1;// reverse insertion order : [20, 20, 5, 15, 5, 10]
        //7.
        //return 0;//only first element :[10]
}

