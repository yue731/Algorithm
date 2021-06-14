import edu.princeton.cs.algs4.StdRandom;

public class quickselect {

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        System.out.println("i: " + i);
        System.out.println("j: " + j);

        while (true) {
            while (less(a[i], a[lo])) {
                i++;
                if (i == hi) break;
            }
            while (less(a[lo], a[j])) {
                j--;
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);


        }
        swap(a, lo, j);

        return j; // index of the item in place
    }

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int j = partition(a, lo, hi);
            if (k == j) {
                return a[k];
            } else if (k < j) {
                hi = j - 1;
            } else {
                lo = j + 1;
            }
        }
        return a[k];
    }

    public static void main(String[] args) {
        Integer[] a = {2, 4, 3, 6, 5, 10};
        System.out.println(select(a, 2));
    }
}
