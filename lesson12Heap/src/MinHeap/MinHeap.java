package MinHeap;

public class MinHeap {
    private int[] heap;
    private int maxSize;
    private int heapSize;

    public MinHeap(int capacity) {
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

    private void shiftUp(int i) {
        while ((i > 1) && (heap[parent(i)] > heap[i])) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    private void shiftDown(int i) {
        while (i <= heapSize) {
            int min = heap[i];
            int minId = i;
            if ((left(i) <= heapSize) && (min > heap[left(i)])) {
                min = heap[left(i)];
                minId = left(i);
            }
            if ((right(i) <= heapSize) && (min > heap[right(i)])) {
                min = heap[right(i)];
                minId = right(i);
            }
            if (minId != i) {
                swap(minId, i);
                i = minId;
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

    public int extractMin() {
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
