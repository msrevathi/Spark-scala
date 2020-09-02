package Exceptions;

public class ExcetionIntroExample {
    public static void main(String[] args) {
        doStuff();
        //  System.out.println(1 / 0);
        /*
        Hello
        Hi
        Exception in thread "main" java.lang.ArithmeticException: / by zero
	        at Exceptions.ExcetionIntroExample.main(ExcetionIntroExample.java:6)
         */
    }

    public static void doStuff() {
        doMoreStuff();
        System.out.println("Hi");
        //   System.out.println(1 / 0);
        /*
        Hello
    Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Exceptions.ExcetionIntroExample.doStuff(ExcetionIntroExample.java:10)
	at Exceptions.ExcetionIntroExample.main(ExcetionIntroExample.java:5)
         */
    }

    public static void doMoreStuff() {
        System.out.println("Hello");
//        System.out.println(1/0);
         /*
    Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Exceptions.ExcetionIntroExample.doMoreStuff(ExcetionIntroExample.java:14)
	at Exceptions.ExcetionIntroExample.doStuff(ExcetionIntroExample.java:9)
	at Exceptions.ExcetionIntroExample.main(ExcetionIntroExample.java:5)
     */
    }


}

