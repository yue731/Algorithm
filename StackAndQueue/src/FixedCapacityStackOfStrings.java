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
        String item = s[--N];
        s[N] = null;
        return item;
    }

    public int size() {
        return N;
    }
}
