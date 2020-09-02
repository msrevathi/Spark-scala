package collections;

import java.util.TreeMap;
import java.util.TreeSet;

public class NavigableMapExample {
    public static void main(String[] args) {
        TreeMap<String, String> t = new TreeMap<String, String>();
        t.put("A", "apple");
        t.put("B", "Mango");
        t.put("C", "Banana");
        t.put("D", "grape");
        t.put("E", "pine");
        t.put("F", "guava");
//        System.out.println(t.ceilingKey("A"));//A
//        System.out.println(t.floorKey("E"));//E
//        System.out.println(t.higherKey("F"));//null
//        System.out.println(t.lowerKey("F"));//E
//        System.out.println(t.pollFirstEntry());//A=apple
//        System.out.println(t.pollLastEntry());//E=guava
//        System.out.println(t.descendingMap());//{E=pine, D=grape, C=Banana, B=Mango}
    }
}

