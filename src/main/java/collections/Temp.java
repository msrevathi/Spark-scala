package collections;

public class Temp {

    @Override
    public String toString() {
        return "Temp";
    }

    public void finalize() {
        System.out.println("finalize method called");
    }
}
