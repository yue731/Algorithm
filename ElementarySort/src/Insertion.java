public class Insertion {

    public static void insertionSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
                printInsertion(a);
            }
        }
    }

    private static void printInsertion(Comparable[] a) {
        for (Comparable ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        insertionSort(a);
    }
}
