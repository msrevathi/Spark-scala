package collections;


import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable m = new Hashtable();
        m.put(new HashTableTemp(5), "A");
        m.put(new HashTableTemp(2), "B");
        m.put(new HashTableTemp(6), "C");
        m.put(new HashTableTemp(15), "D");
        m.put(new HashTableTemp(23), "E");
        m.put(new HashTableTemp(16), "F");
        System.out.println(m); // {6=C, 16=F, 5=A, 15=D, 2=B, 23=E}

        // when size of HashTable is 25
        Hashtable g = new Hashtable(25);
        g.put(new HashTableTemp(5), "A");
        g.put(new HashTableTemp(2), "B");
        g.put(new HashTableTemp(6), "C");
        g.put(new HashTableTemp(15), "D");
        g.put(new HashTableTemp(23), "E");
        g.put(new HashTableTemp(16), "F");
        System.out.println(g);// {23=E, 16=F,  15=D, 6=C,5=A, 2=B}
    }

}

/*
NOTE:1
default size of HashTable is 11
HashTable representation(index , value in HashTable)

10 --------------
9 --------------
8 --------------
7 --------------
     6=C
6 --------------
    5=A,16=F
5 --------------
    15=D
4 --------------
3 -------------
     2=B
2 --------------
     23=E
1 ---------------
0 --------------

 calculation:

m.put(new HashTableTemp(5), "A"); ---> bucket 5
m.put(new HashTableTemp(2), "B"); ---> bucket 2
m.put(new HashTableTemp(6), "C"); ---> bucket 6
m.put(new HashTableTemp(15), "D"); ---> 15%11 = 4 hence bucket 4 (Note 11 is default size of HashTable)
m.put(new HashTableTemp(23), "E");---> 23%11 = 1 hence bucket 1 (Note 11 is default size of HashTable)
m.put(new HashTableTemp(16), "F");---> 16%11 = 5 hence bucket 5 (Note 11 is default size of HashTable)

Note: Output is printed as:
Top to bottom Inside HashTable and right to left with in bucket(hence 16=F, 5=A)


NOTE:2
if we change hashcode() of HashTableTemp class like below

  public int hashCode() {
        return i%9;
    }
Output : {16=F, 15=D, 6=C, 23=E, 5=A, 2=B}

HashTable representation(index , value in HashTable)

10 --------------
9 --------------
8 --------------
   16=F
7 --------------
     6=C,  15=D
6 --------------
    5=A,23=E
5 --------------
4 --------------
3 -------------
     2=B
2 --------------
1 ---------------
0 --------------


m.put(new HashTableTemp(5), "A"); ---> bucket 5
m.put(new HashTableTemp(2), "B"); ---> bucket 2
m.put(new HashTableTemp(6), "C"); ---> bucket 6
m.put(new HashTableTemp(15), "D"); ---> 15%9 = 6 hence bucket 6 (Note 11 is default size of HashTable)
m.put(new HashTableTemp(23), "E");---> 23%9 = 5 hence bucket 5 (Note 11 is default size of HashTable)
m.put(new HashTableTemp(16), "F");---> 16%9 = 7 hence bucket 7 (Note 11 is default size of HashTable)

3.
 when size of HashTable is 25
Output : {23=E, 16=F,  15=D, 6=C,5=A, 2=B}

m.put(new HashTableTemp(5), "A"); ---> bucket 5
m.put(new HashTableTemp(2), "B"); ---> bucket 2
m.put(new HashTableTemp(6), "C"); ---> bucket 6
m.put(new HashTableTemp(15), "D"); --->bucket 15
m.put(new HashTableTemp(23), "E");---> bucket 23
m.put(new HashTableTemp(16), "F");---> bucket 16

 */