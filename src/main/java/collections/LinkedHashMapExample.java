package collections;

import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap m = new LinkedHashMap();
        m.put(101, "Ram");
        m.put(103, "Raj");
        m.put(102, "Sita");
        System.out.println(m);// {101=Ram, 103=Raj, 102=Sita}insertion is preserved
    }
}

