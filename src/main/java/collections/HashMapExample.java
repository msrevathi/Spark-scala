package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        m.put(101, "Ram");
        m.put(102, "Raj");
        m.put(103, "Sita");
        System.out.println(m);
        m.put(101, "Rupa");//{101=Ram, 102=Raj, 103=Sita}  --Map {}
        System.out.println(m);//{101=Sita, 102=Raj, 103=Sita}  --Map {}
        System.out.println(m.keySet());//[101, 102, 103]
        System.out.println(m.values());//[Sita, Raj, Sita] ---collection[]
        System.out.println(m.entrySet());//[101=Sita, 102=Raj, 103=Sita]  ---collection[]
        Set s1 = m.entrySet();
        Iterator itr = s1.iterator();
        while (itr.hasNext()){
            Map.Entry e = (Map.Entry) itr.next();
            System.out.println(e.getKey() +"----" +e.getValue());
            if (e.getValue().equals("Sita")) e.setValue("Sita_Ram");

        }
        System.out.println(m);
    }
}

