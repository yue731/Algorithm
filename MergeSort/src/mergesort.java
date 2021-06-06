public class mergesort {

    /*
    merge two sorted subarrays
    one is aux[lo] to aux[mid]
    the other is aux[mid + 1] to aux[hi]
    store the result in a
     */
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // copy a to aux
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // exit when lo >= hi
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        if (!less(a[mid + 1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        Integer[] aux = new Integer[a.length];
        merge(a, aux, 0, 3, 7);
        for (Integer ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();

        Integer[] aa = {9, 8, 7, 6, 5};
        sort(aa);
        for (Integer ele : aa) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
