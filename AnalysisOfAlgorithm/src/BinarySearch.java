public class BinarySearch {
    /*
    binary search of key in arr and return idx
    if not found, return -1
     */
    public static int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key == arr[mid]) return mid;
            else if (key < arr[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97};
        System.out.println(binarySearch(arr, 33));
        System.out.println(binarySearch(arr, 34));
    }
}
