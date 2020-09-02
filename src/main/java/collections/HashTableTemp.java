package collections;

public class HashTableTemp {
    int i;

    HashTableTemp(int i) {
        this.i = i;
    }

    public int hashCode() {
         return i;
//        return i%9;

    }

    public String toSting() {
        return i+"";
    }
}
