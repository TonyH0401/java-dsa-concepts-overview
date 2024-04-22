package QueueStack;

import java.util.*;

public class Queue<E> implements QueueInterface<E> {
    private Stack<E> s1 = new Stack<E>(); // main
    private Stack<E> s2 = new Stack<E>(); // assist
    private int size;

    public Queue() {
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // ######################################################################## //

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E data) {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        Node<E> ptr = s1.getTop();
        do {
            if (ptr.getData().equals(data))
                return true;
            /*
             * Why can we use getNext()? Because Stack is an implementation of Linked List.
             */
            ptr = ptr.getNext();
        } while (ptr != null);
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // ######################################################################## //

    @Override
    public E getFirst() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        return s1.peek();
    }

    // ######################################################################## //

    // 1(head) -> 2 -> 3 -> 4(tail) ->
    @Override
    public void enQueue(E data) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(data);
        while (!s2.isEmpty())
            s1.push(s2.pop());
        size++;
        return;
    }

    // ######################################################################## //

    @Override
    public void deQueue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
        s1.pop();
        size--;
        return;
    }

    // ######################################################################## //
    /*
     * Start from the top, print from the top, W.A.P
     */
    public void print() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        Node<E> ptr = s1.getTop();
        while (ptr != null) {
            System.out.print(ptr.getData() + " ");
            ptr = ptr.getNext();
        }
        System.out.println();
        return;
    }
}
