package collections;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        Integer i1 = (Integer)10;
        Integer i2 = (Integer)10;

        m.put(i1, "Ram");
        m.put(i2, "Raj");
       // System.out.println(m);
// i1 and i2 are duplicate keys coz, i1.equals(i2) -> true
// replace HashMap with IdentityHashMap then i1 and i2 are not duplicate keys , coz i1 == i2 -> false
        IdentityHashMap x = new IdentityHashMap();
        x.put(10, "Ram");
        x.put((10), "Raj");
        System.out.println(x.size());

        // Creating HashMap and IdentityHashMap objects
        Map hm = new HashMap();
        Map ihm = new IdentityHashMap();

        // Putting key and value in HashMap and IdentityHashMap Object
        hm.put("hmkey","hmvalue");
        hm.put(new String("hmkey"),"hmvalue1");
        ihm.put("ihmkey","ihmvalue");
        ihm.put(new String("ihmkey"),"ihmvalue1");

        System.out.println("Size of HashMap--"+hm.size());

        //ihm.size() will print 2 since it compares the objects by reference
        System.out.println("Size of IdentityHashMap--"+ihm);

    }
}
