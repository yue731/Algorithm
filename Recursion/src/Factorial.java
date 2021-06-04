public class Factorial {

    /*
    return n!
    implement it recursively
     */
    public static int fact(int n) {
        // base case
        if (n == 0) return 1;

        return fact(n - 1) * n;

    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
