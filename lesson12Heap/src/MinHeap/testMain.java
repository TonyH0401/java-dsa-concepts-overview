package MinHeap;

import java.util.Arrays;

public class testMain {
    public static void main(String[] args) throws Exception {
        MinHeap heap = new MinHeap(9);
        heap.insert(8);
        heap.insert(2);
        heap.insert(19);
        heap.insert(6);
        heap.insert(7);
        heap.insert(11);
        heap.insert(2);
        heap.insert(5);
        heap.print();
        // =======================================
        int[] a = { 15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39 };
        System.out.println("> Before using heap sort: " + Arrays.toString(a));
        heapSortAsc(a);
        System.out.println("> After using heap sort: " + Arrays.toString(a));
    }

    public static void heapSortAsc(int arr[]) {
        MinHeap heap = new MinHeap(arr.length + 1);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.extractMin();
        }
    }
}
