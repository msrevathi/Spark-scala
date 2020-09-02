package collections;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class InternalImplementationObjectsOfCursors {
    public static void main(String[] args) {
        Vector v = new Vector();
        Enumeration e = v.elements();
        Iterator i=v.iterator();
        ListIterator l = v.listIterator();
        System.out.println(e.getClass().getName()); // java.util.Vector$1 , here 1 is the anonymus inner class implemented inside vector, that anonymus inner class object we are getting here
        System.out.println(i.getClass().getName()); //java.util.Vector$Itr, Iterator[I] implemented inner class is "Itr", which is present inside Vector, we are getting Itr object
        System.out.println(l.getClass().getName()); // java.util.Vector$ListItr, ListIterator[I] implemented inner class is "ListItr", which is present inside Vector, we are getting ListItr object

        /*
        NOTE:
         java.util.Vector$1  -> before $ , it is Outer class, after $ inner class

         */
    }
}
