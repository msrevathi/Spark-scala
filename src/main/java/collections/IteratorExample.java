package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList v = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            v.add(i);
        }
        System.out.println(v); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        Iterator e = v.iterator();
        while (e.hasNext()) {
            Integer i = (Integer) e.next();
            if (i % 2 == 0)
                System.out.println(i); // 2,4,6,8,10
            else
                e.remove();
        }
        System.out.println(v);//[2, 4, 6, 8, 10]
    }
}
