package collections;

import java.util.Comparator;

public class Employee implements Comparable {
    String name;
    int eid;

    Employee(String name, int eid) {
        this.name = name;
        this.eid = eid;
    }

    @Override
    public String toString() {
        return name + "=====" + eid;
    }

    public int compareTo(Object o) {
        Employee e = (Employee) o;
        Integer id1 = this.eid;
        Integer id2 = e.eid;
        if (id1 > id2) return 1;
        else if (id1 < id2) return -1;
        else return 0;
    }
}

