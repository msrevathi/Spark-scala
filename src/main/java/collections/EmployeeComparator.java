package collections;

import sun.reflect.generics.tree.Tree;

import java.util.TreeSet;

public class EmployeeComparator {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ram", 10);
        Employee e2 = new Employee("Shyam", 20);
        Employee e3 = new Employee("Sita", 40);
        Employee e4 = new Employee("Roh", 30);
        Employee e5 = new Employee("git", 50);

        TreeSet<Employee> t1 = new TreeSet<Employee>();
        t1.add(e1);t1.add(e2);t1.add(e3);t1.add(e4);t1.add(e5);
        // Default Sorting of Employee class. i.e sorting based on id
        System.out.println(t1); //[Ram=====10, Shyam=====20, Roh=====30, Sita=====40, git=====50]

        TreeSet<Employee> t2 = new TreeSet<Employee>(new EmployeeCustomComparator());
        t2.add(e1);t2.add(e2);t2.add(e3);t2.add(e4);t2.add(e5);
        // When don't want Default Sorting of Employee class, we can have custom comparator with reuired sorting, here we did sorting based on alphabetical order of name
        System.out.println(t2);//[Ram=====10, Roh=====30, Shyam=====20, Sita=====40, git=====50]

    }
}
