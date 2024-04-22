package QueueGenerics;

import java.util.*;

public class Queue<E> implements QueueInterface<E> {
    private Node<E> head, tail;
    private int size;

    public Queue() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public Node<E> getHead() {
        return this.head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return this.tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
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

    /*
     * The equals method will be defined by the Object Class, each Object Class will
     * have a different way to compare, we just call the equals method.
     */
    @Override
    public boolean contains(E data) {
        if (head == null)
            return false;
        /*
         * Because our LinkedList uses int as the datatype, we will use "==" to compare
         * data, but if it's an Object Class, each Object Class will have a different
         * method for comparation and it will be defined in the Object Class not the
         * LinkedList itself.
         */
        Node<E> ptr = head;
        do {
            if (ptr.getData().equals(data))
                return true;
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
        return head.getData();
    }

    public E getLast() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        return tail.getData();
    }

    // ######################################################################## //

    // 1(head) -> 2 -> 3 -> 4(tail) ->
    @Override
    public void enQueue(E data) {
        Node<E> temp = new Node<E>(data);
        if (isEmpty()) {
            head = temp;
            tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }

    // ######################################################################## //

    /* You gonna do it in an order */
    @Override
    public void deQueue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
        head = head.getNext();
        size--;
        /*
         * if the head is the last element, after you dequeue only null is available you
         * can set the tail being null as well.
         */
        if (head == null) {
            tail = null;
            return;
        }
        return;
    }

    // ######################################################################## //
    /*
     * Start from the top, print from the top, W.A.P
     */
    public void print() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        Node<E> ptr = head;
        while (ptr != null) {
            System.out.print(ptr.getData() + " ");
            ptr = ptr.getNext();
        }
        System.out.println();
        return;
    }
}
