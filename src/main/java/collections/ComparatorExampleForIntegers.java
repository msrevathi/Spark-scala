package collections;

import java.util.TreeSet;

// To insert integer objects to TreeSet, in descending order
//https://www.youtube.com/watch?v=uu9DHLJVRIs&list=PLd3UqWTnYXOmMaHmzE1eWuynOgvrWUO5E&index=9
public class ComparatorExampleForIntegers {
    public static void main(String[] args) {
        TreeSet t = new TreeSet(new MyIntegerComparator());
        t.add(10);
        t.add(5);
        t.add(15);
        t.add(5);
        t.add(20);
        t.add(20);
        System.out.println(t);//[20, 15, 10, 5]
    }
    // If we are not passing Comparator object, then internally jvm will call compareTo(), which is default sorting order(ascending)
// If we are passing  Comparator object, then  jvm will call compare(), which is  customised sorting order(descending)


}


