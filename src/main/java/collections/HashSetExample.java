package collections;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet h = new HashSet();
//        System.out.println(h.add("A"));// true
//        System.out.println(h.add("A"));// false
        h.add("A");
        h.add("B");
        h.add("C");
        h.add("D");
        h.add(null);
        h.add("A");
        System.out.println(h);//[null, A, B, C, D] insertion order is not preserved
        System.out.println(h.add("A"));// false
    }
}

