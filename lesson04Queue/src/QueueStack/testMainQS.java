package QueueStack;

public class testMainQS {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enQueue(10);
        queue.enQueue(-12);
        queue.enQueue(1);
        queue.enQueue(1000);
        queue.print();
        queue.deQueue();
        queue.print();
        System.out.println(queue.contains(1000));
        System.out.println(queue.contains(100));
    }
}
