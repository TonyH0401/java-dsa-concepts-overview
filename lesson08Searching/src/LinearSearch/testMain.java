package LinearSearch;

public class testMain {
    public static void main(String[] args) throws Exception {
        /* O Notiation of this is O(n) */
        int[] arr = { 10, 22, 31, 4, 15, 28, 17, 88, 59 };
        System.out.println("result: " + LinearSearch(arr, arr.length, 31));
        System.out.println("result: " + LinearSearch(arr, arr.length, -100));
    }

    public static boolean LinearSearch(int[] arr, int size, int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }
}
