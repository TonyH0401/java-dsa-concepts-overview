package MergeSort;

public class mergeSort {
    public static void main(String[] args) throws Exception {
        int[] arr = { 5, 2, 7, 6, 9, -1, -100, -20, 8, 4, 3 };
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int[] arr, int l, int r) {
        // This will divive until there's only 1 left for each 1st half and 2nd half
        // after that they will merge them together.
        if (l < r) {
            // Find the middle
            int m = l + (r - l) / 2;
            // First half
            sort(arr, l, m);
            // Second half
            sort(arr, m + 1, r);
            // Merge the 2 half together
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged.
        // Create and copy the values to 2 temp array.
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the 2 temp array.
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
