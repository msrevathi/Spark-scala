package collections;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet h = new LinkedHashSet();
        h.add("A");
        h.add("B");
        h.add("C");
        h.add("D");
        h.add(null);
        h.add("A");
        System.out.println(h);// [A, B, C, D, null] insertion order is preserved
    }
}
