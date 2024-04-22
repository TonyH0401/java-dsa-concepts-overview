package MergeSort;

public class mergeMain {
    public static void main(String[] args) throws Exception {
        int[] arr1 = { 1, 3, 5, 8 };
        int[] arr2 = { 2, 4, 6, 7 };
        int[] arr3 = new int[arr1.length + arr2.length];
        mergeMethod(arr1, arr2, arr3);
        print(arr3);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeMethod(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                i++;
                k++;
            } else {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        // adding any remaining from arr1
        while (i < arr1.length) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        // adding any remaining from arr2
        while (j < arr2.length) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }
    }
}
