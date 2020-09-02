package collections;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer>  v= new Vector<Integer> (10,5);
        System.out.println(v.capacity());
        for (int i=1;i<=10;i++){
            v.addElement(i);
        }
        System.out.println(v.capacity());
        v.addElement(11);
        System.out.println(v.capacity());
        System.out.println(v);
    }
/*
1.without vector size(default is 10)
 Vector<Integer>  v= new Vector<Integer> ();
10
10
20
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

2.with vector size 25
Vector<Integer>  v= new Vector<Integer> (25);
25
25
25
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

3.with vector size 10 and increment capacity to 5
Vector<Integer>  v= new Vector<Integer> (10,5);
10
10
15
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 */
}
