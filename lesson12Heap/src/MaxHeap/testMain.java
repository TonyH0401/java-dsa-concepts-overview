package MaxHeap;

import java.util.Arrays;

public class testMain {
    public static void main(String[] args) throws Exception {
        MaxHeap heap = new MaxHeap(9);
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
        heapSortDesc(a);
        System.out.println("> After using heap sort: " + Arrays.toString(a));
    }

    public static void heapSortDesc(int arr[]) {
        MaxHeap heap = new MaxHeap(arr.length + 1);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.extractMax();
        }
    }
}
