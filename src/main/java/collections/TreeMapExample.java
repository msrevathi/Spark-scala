package collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // default sorting of keys
        TreeMap h = new TreeMap();
        h.put(100, "A");
        h.put(101, "B");
        h.put(102, "C");
        h.put(103, "D");
        h.put(104, null);
        h.put(105, 11111); //Heterogeneous values allowed
        System.out.println(h);//{100=A, 101=B, 102=C, 103=D, 104=null, 105=11111}
        // h.put("xx",11);// Heterogeneous keys allowed: ClassCastException
        // h.put(null,100);// null keys not allowed: NullPointerException
        h.put(106, null);
        h.put(107, null);
        System.out.println(h);
// customised sorting of String keys - Descending order of strings

        TreeMap c = new TreeMap(new MyStringComparator());
        c.put("AAA", 101);
        c.put("BBB", 012);
        c.put("CCC", 106);
        System.out.println(c);
    }
}
