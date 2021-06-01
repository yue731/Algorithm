public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        // return true if v is less than w
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        sort(a);
        for (Integer num : a) {
            System.out.print(num + " ");
        }
    }
}
