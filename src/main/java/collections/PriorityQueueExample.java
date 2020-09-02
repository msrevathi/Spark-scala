package collections;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue p = new PriorityQueue();
        System.out.println(p.peek());// null
//        System.out.println(p.element());// NoSuchElementException
        for (int i = 0; i <= 10; i++) {
            p.offer(i);
        }
        System.out.println(p.peek());//0
        System.out.println(p.element());//0
        System.out.println(p.poll());//0
        System.out.println(p);//[1, 3, 2, 7, 4, 5, 6, 10, 8, 9]

        PriorityQueue pq = new PriorityQueue(15, new MyStringComparator());
        pq.offer("A");
        pq.offer("Z");
        pq.offer("D");
        pq.offer("Y");
        System.out.println(pq);//[Z, Y, D, A]
    }
}


//Note: some plotform will not provide support for thread priority and priority queues