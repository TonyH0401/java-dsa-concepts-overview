package BinarySearch;

public class testMain {
    public static void main(String[] args) throws Exception {
        /*
         * For binary search to work, we need to sort the list first. The complexity for
         * binary search is O(logn).
         * 
         * For simplicity, I will use selection sort (I know the O notation is worst).
         * You can use any sorting algorithms that is superior but as long as it's not
         * more complex than the binary search's O notation you will be fine. If the
         * sorting algo's O notation is more complex (larger O notation) then the binary
         * search, the whole algo will take on the sorting complexity, which IS NOT WHAT
         * WE WANT, MAKING THE BINARY SEARCH WORST.
         */
        int[] arr = { 10, 22, 31, 4, 15, 28, 17, 88, 59 };
        printArray(selectionSort(arr), arr.length);
        System.out.println(binarySearch(selectionSort(arr), 0, arr.length - 1, 31));
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] selectionSort(int[] arr) {
        int[] clone = arr.clone();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (clone[i] < clone[j]) {
                    int temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;
                }
            }
        }
        return clone;
    }

    public static int binarySearch(int[] arr, int left, int right, int key) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (key < arr[mid]) {
                return binarySearch(arr, left, mid - 1, key);
            }
            return binarySearch(arr, mid + 1, right, key);
        }
        return -1;
    }
}
