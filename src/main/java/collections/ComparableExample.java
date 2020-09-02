package collections;

public class ComparableExample {
    public static void main(String[] args) {
        System.out.println("A".compareTo("Z"));// -ve
        System.out.println("Z".compareTo("k"));//+ve
        System.out.println("A".compareTo("A"));//0
       //  System.out.println("A".compareTo(null));//Runtime exception- ClassCastException
    }
}
