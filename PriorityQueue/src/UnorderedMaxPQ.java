public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N; // N is the number of elements in pq

    public UnorderedMaxPQ(int capacity) {
        this.pq = (Key[]) new Comparable[capacity];
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            if (less(pq[maxIdx], pq[i])) maxIdx = i;
        }
        swap(pq, maxIdx, N - 1);
        return pq[--N];
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
