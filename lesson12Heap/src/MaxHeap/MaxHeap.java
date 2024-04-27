package MaxHeap;

public class MaxHeap {
    private int[] heap;
    private int maxSize;
    private int heapSize;

    public MaxHeap(int capacity) {
        this.maxSize = capacity;
        this.heapSize = 0;
        this.heap = new int[maxSize];
        this.heap[0] = -1;
    }

    public int[] getHeap() {
        return this.heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    // ########################################################

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return (2 * i) + 1;
    }

    // ########################################################

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // ########################################################

    /* This is the same as MinHeap but you need to change from ">" to "<". */
    private void shiftUp(int i) {
        while ((i > 1) && (heap[parent(i)] < heap[i])) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    /* This is the same as MinHeap but you need to change from ">" to "<". */
    private void shiftDown(int i) {
        while (i <= heapSize) {
            int max = heap[i];
            int maxId = i;
            if ((left(i) <= heapSize) && (max < heap[left(i)])) {
                max = heap[left(i)];
                maxId = left(i);
            }
            if ((right(i) <= heapSize) && (max < heap[right(i)])) {
                max = heap[right(i)];
                maxId = right(i);
            }
            if (maxId != i) {
                swap(maxId, i);
                i = maxId;
            } else {
                break;
            }
        }
    }

    // ########################################################

    public void insert(int data) {
        if (heapSize == maxSize) {
            throw new RuntimeException("Maximum Capacity!");
        }
        heapSize += 1;
        heap[heapSize] = data;
        shiftUp(heapSize);
    }

    public int extractMax() {
        if (heapSize == 0) {
            throw new RuntimeException("Empty Heap");
        }
        int max = heap[1];
        heap[1] = heap[heapSize];
        heapSize = heapSize - 1;
        shiftDown(1);
        return max;
    }

    // ########################################################

    public void print() {
        for (int i = 1; i <= heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
