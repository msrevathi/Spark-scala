package collections;

import java.util.TreeSet;

// To insert string objects to TreeSet, in reverse of alphabetical order
public class ComparatorExampleForStrings {
    public static void main(String[] args) {
        TreeSet t = new TreeSet();
        t.add("Roja");
        t.add("Shoba");
        t.add("Raja");
        t.add("Ganga");
        t.add("Ramu");
        // System.out.println(t);//[Ganga,Raja,Ramu,Roja,Shoba]

        TreeSet<String> s = new TreeSet<String>(new MyStringComparator());
        s.add("Roja");
        s.add("Shoba");
        s.add("Raja");
        s.add("Ganga");
        s.add("Ramu");
        System.out.println(s);//  [Shoba, Roja, Ramu, Raja, Ganga]
    }
}
