import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {

    /*
    frequency counter to find the most frequently occurred string
     */
    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<>(10);
        String max = "";
        int maxCount = 0;
        st.put(max, 0);
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minLen) continue;
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
            maxCount = Math.max(maxCount, st.get(word));
            if (maxCount == st.get(word)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}
