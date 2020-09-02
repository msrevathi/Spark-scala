package collections;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet t = new TreeSet();
        t.add("A");
        t.add("a");
        t.add("B");
        t.add("Z");
        t.add("L");
        // t.add(10);// adding heterogeneous elements gives runtime exception: java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        // t.add(null); // NullPointerException
       // System.out.println(t);// [A,B,L,Z,a]
// Null acceptance
//        TreeSet tt = new TreeSet();
//        tt.add(null); // not allowed even as first element from java 1.7
//
// Adding non comparable elements to TreeSet gives Runtime  ClassCastException
// Here StringBuffer is not Comparable_and_Comparator, coz it did not implement Comparable_and_Comparator[I],but string is comparable, it implements Comparable_and_Comparator[I]
        TreeSet td = new TreeSet();
//        td.add(new StringBuffer("A"));
//        td.add(new StringBuffer("B"));
//        td.add(new StringBuffer("C"));
//        System.out.println(td);

        TreeSet ts = new TreeSet();
        ts.add("K");
        ts.add("z");
        ts.add("A");
        ts.add("A");
      //  System.out.println(ts); // [A, K, z]

        // NOTE: but we can add our own comparator and add the StringBuffer objects to TreeSet and also sort them

        TreeSet tk = new TreeSet(new MyStringComparator());
        tk.add("K");
        tk.add("z");
        tk.add("A");
        tk.add("A");
       // System.out.println(tk);// [z, K, A]

// if we depend on default sorting order, objects should be comparable and homogeneous, otherwise we get ClassCastException
// if we define our own  sorting order, objects need not to be  comparable and homogeneous
/* to Insert String ans StringBuffer objects into TreeSet, where sorting order is increasing
length order, if 2 objects have same length, then consider their alphabetical order     */
        TreeSet tt = new TreeSet(new MyStringComparatorForHeterogeneousObjects());
        tt.add("K");
        tt.add(new StringBuffer("ABC"));
        tt.add(new StringBuffer("AA"));
        tt.add("xx");
        tt.add("ABCD");
        tt.add("A");
        System.out.println(tt);// [A, K, AA, xx, ABC, ABCD]
    }
}
