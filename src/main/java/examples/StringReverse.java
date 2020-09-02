package examples;

public class StringReverse {
    public static void main(String[] args) {
        stringrev("Hello");
        stringrev2("Dell");
    }

    private static void stringrev(String s) {
        char[] ch = s.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        System.out.println(rev);
    }

    private static void stringrev2(String s) {
        StringBuilder sb  = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
           sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}
