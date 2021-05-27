public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N;

    public FixedCapacityStackOfStrings(int capacity) {
        this.s = new String[capacity];
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        return s[--N];
    }

    public int size() {
        return N;
    }
}
