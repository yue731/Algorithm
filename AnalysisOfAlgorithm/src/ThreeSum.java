import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    /*
    return how many triples sum to 0 by using brute force
    int[] arr has distinct elements
    time complexity: O(n^3)
     */
    public static int threeSumBF(int[] arr, List<List<Integer>> lists) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        count++;
                        lists.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
        return count;
    }

    /*
    return how many triples sum to 0 by using binary search
    int[] arr has distinct elements
    first sort the arr
    time complexity: O(n^2 * log(n))
     */
    public static int threeSumBinarySearch(int[] arr, List<List<Integer>> lists) {
        int count = 0;
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int lo = j + 1;
                int hi = n - 1;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (arr[i] + arr[j] + arr[mid] == 0) {
                        count++;
                        lists.add(Arrays.asList(arr[i], arr[j], arr[mid]));
                        break;
                    } else if (arr[i] + arr[j] + arr[mid] < 0) lo = mid + 1;
                    else hi = mid - 1;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {30, -40, -20, -10, 40, 0, 10, 5};
        List<List<Integer>> lists = new ArrayList<>();
        long start = System.nanoTime();
        int count = threeSumBF(arr, lists);
        long finish = System.nanoTime();
        long runningTime = finish - start;
        for (List<Integer> l : lists) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("There are total " + count + " such triples");
        System.out.println("Running time for brute force is " + runningTime + "ns");

        List<List<Integer>> lists1 = new ArrayList<>();
        long start1 = System.nanoTime();
        int count1 = threeSumBinarySearch(arr, lists1);
        long finish1 = System.nanoTime();
        long runningTime1 = finish1 - start1;
        for (List<Integer> l : lists1) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("There are total " + count1 + " such triples");
        System.out.println("Running time for binary search is " + runningTime1 + "ns");
    }
}
