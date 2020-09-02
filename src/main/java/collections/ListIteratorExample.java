package collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        LinkedList v = new LinkedList();
        v.add("bala");
        v.add("venky");
        v.add("chiru");
        v.add("nag");
        System.out.println(v); //[bala, venky, chiru, nag]
        ListIterator e = v.listIterator();
        while (e.hasNext()) {
            String i = (String) e.next();
            if (i == "venky") {
                e.remove();// [bala,  chiru, nag]
            } else if (i == "nag")
                e.add("chaitu"); // [bala,  chiru, nag, chaitu]
            else if (i == "chiru")
                e.set("charan"); // [bala,  charan, nag, chaitu]

        }
        System.out.println(v);//[bala, charan, nag, chaitu]]
    }
}
