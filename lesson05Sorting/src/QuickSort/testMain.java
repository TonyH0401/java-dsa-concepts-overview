package QuickSort;

public class testMain {
    public static void main(String[] args) throws Exception {
        int[] arr = { 5, 2, 7, 6, 9, -1, -100, -20, 8, 4, 3 };
        System.out.println("> Original Array: ");
        print(arr);
        /*
         * Quick Sort uses a pivot where there is a pivot and the data is compared
         * between this pivot.
         * 
         * Quick Sort is divided into 3 sections, swap() is the swapping, partition() is
         * to create the pivot and swapping, quicksort is where partition is called
         * (recursively).
         */
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}
