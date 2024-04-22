package QueueGenerics;

public class testMainQueue {
    public static void main(String[] args) throws Exception {
        try {
            Queue<Integer> queue = new Queue<Integer>();
            queue.enQueue(1);
            queue.enQueue(-1);
            queue.enQueue(100);
            queue.enQueue(-1000);
            queue.print();
            queue.deQueue();
            queue.print();
            queue.deQueue();
            queue.print();
            queue.enQueue(20);
            queue.print();
        } catch (Exception e) {
            System.err.println("> Got an error: " + e.getMessage());
        }
    }
}
