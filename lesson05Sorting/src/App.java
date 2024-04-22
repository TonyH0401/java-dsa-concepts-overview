public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Because Array has a pointer properties - if you change the Array inside a
         * method it will change the original Array although this is Java. Use a clone
         * of the Array, a full clone not a shallow clone, a shallow clone will still
         * have that pointer effect.
         * 
         * I will do increase-order, if you want the decrease-order just reverse the
         * compare symbol.
         */
        int[] arr = { 5, 2, 7, 6, 9, -1, -100, -20, 8, 4, 3 };
        System.out.println("> Original Array: ");
        print(arr);
        System.out.println("> Selection Sorted Array: ");
        print(selectionSort(arr));
        System.out.println("> Bubble Sorted Array: ");
        print(bubbleSort(arr));
        System.out.println("> Insertion Sorted Array: ");
        print(insertionSort(arr));
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
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

    /* You can either do bubble up or bubble down, I choose bubble up */
    public static int[] bubbleSort(int[] arr) {
        int[] clone = arr.clone();
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (clone[j] > clone[j + 1]) {
                    int temp = clone[j];
                    clone[j] = clone[j + 1];
                    clone[j + 1] = temp;
                }
            }
        }
        return clone;
    }

    public static int[] insertionSort(int[] arr) {
        int[] clone = arr.clone();
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int key = clone[i];
            int j = i - 1;
            while (j >= 0 && clone[j] > key) {
                clone[j + 1] = clone[j];
                j = j - 1;
            }
            clone[j + 1] = key;
        }
        return clone;
    }

}
