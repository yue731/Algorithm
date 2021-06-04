public class Fibonacci {

    public static int fibRecursive(int n) {
        // base case
        if (n == 0) return 1;
        if (n == 1) return 1;
        return fibRecursive(n - 2) + fibRecursive(n - 1);
    }

    public static int fibIterative(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int prev = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = prev;
            prev = curr;
            curr = temp + prev;
        }
        return curr;

    }

    public static void main(String[] args) {
        System.out.println(fibRecursive(4));
        System.out.println(fibIterative(5));
    }
}
