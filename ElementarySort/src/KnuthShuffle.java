import edu.princeton.cs.algs4.StdRandom;

public class KnuthShuffle {

    public static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = StdRandom.uniform(i + 1); // generate a random int r from [0, i]
            swap(a, i, r);
        }
    }

    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffle(a);
        for (Integer ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
