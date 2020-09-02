package collections;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add("A");
        l.add(10);
        l.add("A");
        l.add(null);
        System.out.println(l);//[A, 10, A, null]
        l.set(0,"Rev");
        System.out.println(l);//[Rev, 10, A, null]
        l.add(0,"Sid");
        System.out.println(l);////[Sid, Rev,10, A, null]
        l.removeLast();
        System.out.println(l);//[Sid,Rev, 10, A]
        l.addFirst("chuba");
        System.out.println(l);//[chuba,Sid,Rev, 10, A]
    }

}
