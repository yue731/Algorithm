import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;


public class RandomWord {
    public static void main(String[] args) {

        int i = 0;
        String ans = "";


        while (!StdIn.isEmpty()) {
            i++;
            String curr = StdIn.readString();
            if (curr.isEmpty()) break;
//            System.out.println(curr);
            if (StdRandom.bernoulli((float)1 / i)) {
                ans = curr;
            }
//            System.out.println(i);
        }
        System.out.println(ans);
    }
}
