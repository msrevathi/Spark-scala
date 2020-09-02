package collections;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("A");
        s.push("B");
        s.push("C");
        s.push(null);
        System.out.println(s); // []A,B,C]
        System.out.println(s.search("A"));//3
        System.out.println(s.search("C"));//1
        System.out.println(s.search("x"));//-1
        System.out.println(s.pop());//null
        System.out.println(s);//[A, B, C]
        System.out.println(s.capacity());//10 , cos its properties are inherited from vector(default size o vector is 10)

    }

    /**
     * NOTE: insertion order is maintained
     * offset stack_elements index
     *    1        C          2
     *    2        B          1
     *    3        A          0
     */

}
