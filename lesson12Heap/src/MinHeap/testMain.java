package MinHeap;

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
    }
}
