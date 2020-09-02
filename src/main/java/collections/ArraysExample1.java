package collections;


import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.binarySearch;

public class ArraysExample1 {
    public static void main(String[] args) {
        int[] a = new int[3];
        System.out.println(a.getClass().getName()); // [I
        int[][] b = new int[3][2];
        System.out.println(b.getClass().getName()); // [[I
        boolean[] c = new boolean[2];
        System.out.println(c.getClass().getName());
        byte[] d = new byte[2];
        System.out.println(d.getClass().getName());
        int[] x = new int[0]; //valid
        // int[] y = new int[-3]; //runtime exception : Exception in thread "main" java.lang.NegativeArraySizeException
        int[] e = new int['3']; //allowed , char is converted to int
        //int[] f = new int[2147483647]; // Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        // int[] f = new int[2147483648]; -> compile error -> integer too large

        //6.
        int[][] g = new int[2][];
        g[0] = new int[2];
        g[1] = new int[3];

        //7
        int[][][] h = new int[2][][];
        h[0] = new int[3][];
        h[0][0] = new int[1];
        h[0][1] = new int[2];
        h[0][2] = new int[3];

        h[1] = new int[2][2];

        //8 - which are valid

        // int[] i = new int[];//invalid , array size is missing
        int[] j = new int[2];
        //  int[] k = new int[][];// invalid ,array size is missing
        int[][] l = new int[3][];
        //int[][] m = new int[][4];// invalid, array size of first dimension is missing
        // int[][][] n = new int[][][];//invalid, array size is missing
        int[][][] o = new int[3][5][];//valid
        // int[][][] p = new int[3][][5];//invalid, array size of second dimension is missing
        // int[][][] q = new int[][5][3];//invalid, array size of first dimension is missing

        //9.
        System.out.println(j); // [I@b1a58a3 -> Array of integer with some hashcode
        System.out.println(j[0]); // 0

        int[][] k = new int[2][3];
        System.out.println(k); // [[I@6438a396
        System.out.println(k[0]); // [I@e2144e4
        System.out.println(k[0][0]);// 0


        int[][] m = new int[2][];
        System.out.println(m); // [[I@6438a396
        System.out.println(m[0]); // null // m[0] refers to an null object
        // System.out.println(m[0][0]);// NullPointerException -> any operation on null

        int[] n = new int[6];
        n[0] = 1;
        n[1] = 2;
        n[2] = 3;
        n[3] = 4;
        n[4] = 5;
        n[5] = 6;
        // n[6]= 7; // ArrayIndexOutOfBoundsException
        // n[-6] = 8;// ArrayIndexOutOfBoundsException
        // n[2.5]= 8;  compile exception -> required int, found double

        int[][] s = {{10, 20}, {30, 40, 50}};
        int[][][] t = {{{10, 20}, {30, 40, 50}}, {{40, 50}, {60, 70}}};

        //length vs length()
        int[] u = new int[3];
        // System.out.println(u.length());// cannot find symbol symbol: method length() location: class int[]
        System.out.println(u.length);
        // length varaible applicable for arrays

        String ss = "revathi";
        System.out.println(ss.length());//7
        // System.out.println(ss.length);// cannot find symbol , symbol: length varaible, location: class java.lang.String
        // length() is applicable or string objects, represents no of characters in string
        // length method is applicable for strings

        String[] sr = {"A", "AA", "AAA"};
        System.out.println(sr.length);//3
        // System.out.println(sr.length());//  cannot find symbol symbol: method length() location: class int[]
        // System.out.println(sr[0].length); // cannot find symbol , symbol: length varaible, location: class java.lang.String
        System.out.println(sr[0].length());

        int[][] v = new int[6][3];
        System.out.println(v.length); //6
        System.out.println(v[0].length); //3
        // in multi dimentional arrays length represents only base size, not total size
        // no direct way to find total length of multi dimentional array,but can find like belwo
        // v[0].length+v[1].length+v[2].length+.....

        // 11
        sum(new int[]{10, 20, 20}); // here new int[]{10,20,20} is called anonymus array
        // sum(new int[3]{10,20,30}); cannot specify size for arrays

//Arrays utility methods
        int[] a1 = {5, 10, 8, 4, 2};
        System.out.println("Arrays before sorting");
        for (int aa : a1) {
            System.out.println(aa);
        }
        System.out.println("Arrays after sorting");
        Arrays.sort(a1);
        for (int ax : a1) {
            System.out.println(ax);
        }

        String[] as = {"A", "X", "F", "O", "B"};
        System.out.println("String Objects before sorting");
        for (String aa : as) {
            System.out.println(aa);
        }
        System.out.println("String Objects after sorting");
        Arrays.sort(a1);
        for (String ax : as) {
            System.out.println(ax);
        }
        System.out.println("String Objects after sorting");
        Arrays.sort(as);
        for (String ax : as) {
            System.out.println(ax);
        }

        Arrays.sort(as, new MyStringComparator());
        System.out.println("String Objects after sorting with comparator");
        for (String ax : as) {
            System.out.println(ax);
        }

//Arrays utility methods
        System.out.println("Binary search for arrays");
        int[] ll = {5, 10, 8, 4, 2};
        Arrays.sort(ll); // [2,4,5,8,10]
//2. search
        System.out.println(Arrays.binarySearch(ll, 8));//3
        System.out.println(Arrays.binarySearch(ll, 100));//-6

        String[] dc = {"A", "X", "F", "O", "B"};
        Arrays.sort(dc, new MyStringComparator());
        System.out.println(dc);//[A,B,F,O,X]
        System.out.println(Arrays.binarySearch(dc, "A"));//1
        System.out.println(Arrays.binarySearch(dc, "k"));//-6

        System.out.println(Arrays.binarySearch(dc, "A", new MyStringComparator()));//5
        System.out.println(binarySearch(dc, "k", new MyStringComparator()));//-1
//        if the list is sorted according to  Comparator, the at the time of search operation also pass the same Comparator object, otherwise we get unpredictable results.
        System.out.println(binarySearch(dc, "A"));//unpredictable results -1
//Note: as  imported import static java.util.Arrays.binarySearch;  binarySearch method can be used directly


// Arrays conversion to list
        System.out.println("Arrays conversion to list");
        String[] dd = {"A", "X", "F", "O", "B"};
        List la = Arrays.asList(dd);
        la.set(1, "AAAA");
        System.out.println(la);
        // la.add("zzz");//RuntimeException : UnsupportedOperationException
        // la.remove("O");//RuntimeException : UnsupportedOperationException
        la.set(2,new Integer(3)); //RuntimeException ArrayStoreException


    }

    // calculate sum of array elements
    public static void sum(int[] x) {
        int total = 0;
        for (int x1 : x) {
            total = total + x1;
        }
        System.out.println("total " + total);
    }


}





