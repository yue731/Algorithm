import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public ST(int sz) {
        this.keys = (Key[]) new Object[sz];
        this.vals = (Value[]) new Object[sz];
        this.N = 0;
    }

    public void put(Key key, Value value) {

    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i == -1) return null;
        return vals[i];
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public void delete(Key key) {
        put(key, null);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {

    }

    /*
    ST test client
     */
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>(10);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }


}
