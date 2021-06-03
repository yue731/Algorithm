/*
Use increment sequence 3x + 1
 */
public class ShellSort {
    public static void shellSort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1; // starting from the largest h all the way back to h == 1

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h])) {
                        swap(a, j, j - h);
                    }
                }
            }
            h /= 3;
        }

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void print(Comparable[] a) {
        for (Comparable ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        shellSort(a);
        print(a);
    }
}
