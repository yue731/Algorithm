public class threewayquicksort {

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];
        int i = lo;

        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt, i);
                lt++;
                i++;
            } else if (cmp > 0) {
                swap(a, gt, i);
                gt--;
            } else {
                i++;
            }
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 1, 4, 5, 5, 8, 1};
        sort(a, 0, a.length - 1);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
