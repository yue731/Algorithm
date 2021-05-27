public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N;

    public ResizingArrayStackOfStrings() {
        this.s = new String[1];
        this.N = N;
    }

    public void push(String item) {
        if (N == s.length) resize(s.length * 2);
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) resize(s.length / 2);
        return item;
    }

    /*
    resize s with the new capacity
    copy over the items from original s
     */
    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }
}
