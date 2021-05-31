import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {

        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String curr = StdIn.readString();
            rq.enqueue(curr);
        }
        int k = Integer.parseInt(args[0]);
        while (k > 0) {
            System.out.println(rq.dequeue());
            k--;
        }
    }
}
