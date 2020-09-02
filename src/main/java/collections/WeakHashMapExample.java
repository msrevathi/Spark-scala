package collections;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        HashMap j = new HashMap();
       // WeakHashMap j = new WeakHashMap();
        Temp t = new Temp();
        j.put(t, "rev");
        System.out.println(j);
        try {
            t = null;
            System.gc();
            Thread.sleep(5000);
            System.out.println(j);
        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        }
    }

/*
NOTE:
1.if out collection is HashMap, temp object is not eligible for garbage collection as it is associated with HashMap
output:
{Temp=rev}
{Temp=rev}

2.if out collection is WeakHashMap, temp object is  eligible for garbage collection as it is associated with WeakHashMap
output:
{Temp=rev}
finalize method called
{}
 */
}
