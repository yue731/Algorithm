public class BinaryHeap<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N; // number of nodes in pq

    public BinaryHeap(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /*
    promote node at idx k to restore heap order
    compare node at k and its parent at k / 2
     */
    private void swim(int k) {
        while (k > 1 && less(pq[k / 2], pq[k])) {
            swap(pq, k / 2, k);
            k = k / 2;
        }
    }

    private void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            // find the larger child between 2 * k and 2 * k + 1
            if (j < N && less(pq[j], pq[j + 1])) j += 1;
            if (!less(pq[k], pq[j])) break;
            swap(pq, k, j);
            k = j;
        }
    }

    private Key delMax() {
        Key max = pq[1];
        swap(pq, 1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }
}
