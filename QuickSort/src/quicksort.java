import edu.princeton.cs.algs4.StdRandom;

public class quicksort {

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

    public static void quicksort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // exit
        if (lo >= hi) return;
        // curr level processing
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] a = {5, 4, 3, 8, 9, 2, 7, 1, 6};
        System.out.println(partition(a, 0, a.length - 1));
        for (Integer i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        Integer[] b = {5, 4, 3, 8, 9, 2, 7, 1, 6};
        quicksort(b);
        for (Integer i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
