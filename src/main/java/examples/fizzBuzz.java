package examples;

public class fizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if ((i % 5 == 0) && (i % 3 == 0)) {
                System.out.println("fizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}