package collections;


import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add("A");
        l.add(10);
        l.add("A");
        l.add(null);
        System.out.println(l);//[A, 10, A, null]
        l.remove(2);
        System.out.println(l);//[A, 10, null]
        l.add(2, "M");
        l.add("N");
        System.out.println(l);//[A, 10, M, null, N]

        List l1 = Collections.synchronizedList(l);
//
//        Set s1 = Collections.synchronizedSet(l);

        //Collections.sort(l);//ClassCastException: java.lang.String cannot be cast to java.lang.Integer
//        System.out.println(l);

//Collections utility methods
//1.sort
        ArrayList ll = new ArrayList();
        ll.add("Z");
        ll.add("A");
        ll.add("K");
        System.out.println(ll);//[Z, A, K]
        Collections.sort(ll);
        System.out.println(ll);//[A, K, Z]
//2. search
        System.out.println(Collections.binarySearch(ll, "A"));//0
        System.out.println(Collections.binarySearch(ll, "h"));//-4
        Collections.sort(ll, new MyStringComparator());
        System.out.println(ll);//[Z, K, A]
        System.out.println(Collections.binarySearch(ll, "A", new MyStringComparator()));//2
        System.out.println(Collections.binarySearch(ll, "F", new MyStringComparator()));//-3
//        if the list is sorted according to  Comparator, the at the time of search operation also pass the same Comparator object, otherwise we get unpredictable results.
        System.out.println(Collections.binarySearch(ll, "A"));//unpredictable results -1
//3.reverse

        ArrayList lk = new ArrayList();
        lk.add("123");
        lk.add("345");
        lk.add("23");
        System.out.println(lk);//[123, 345, 23]
//        Collections.reverse(lk);
//        System.out.println(lk);//[23, 345, 123]
        Collections.reverseOrder(new MyIntegerComparator());
    }


    /*
[A, 10, A, null] -> insertion order is preserved,null are allowed,duplicates are allowed
[A, 10, null]
[A, 10, M, null, N] -
     */
}

