public class heapsort {


    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    private static void sink(Comparable[] pq, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(pq[j], pq[j + 1])) j += 1;
            if (!less(pq[k], pq[j])) break;
            swap(pq, k, j);
            k = j;
        }
    }

    public static void heapSort(Comparable[] pq, int N) {
        // 1. heap construction (bottom up)

        for (int k = N / 2; k >= 1; k--) {
            sink(pq, k, N);
        }

        // sort down
        while (N > 1) {
            swap(pq, 1, N--);
            sink(pq, 1, N);
        }

    }

    public static void main(String[] args) {
        Integer[] pq = {null, 4, 7, 1, 3, 9, 8, 2};
        heapSort(pq, 7);
        for (Integer i : pq) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
