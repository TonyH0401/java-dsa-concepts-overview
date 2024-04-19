package NoGenerics;

import java.util.*;

public class SingleLinkedList implements ListInterface {
    private Node head;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int data) {
        /*
         * The equals method will be defined by the Object Class, each Object Class will
         * have a different way to compare.
         */
        if (head == null)
            return false;
        Node ptr = head;
        /*
         * Because our LinkedList uses int as the datatype, we will use "==" to compare
         * data, but if it's an Object Class, each Object Class will have a different
         * method for comparation and it will be defined in the Object Class not the
         * LinkedList itself.
         */
        while (ptr != null) {
            if (ptr.getData() == data)
                return true;
            ptr = ptr.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Node getHead() {
        if (head == null)
            throw new NoSuchElementException("List is Empty!");
        return head;
    }

    @Override
    public Node getTail() {
        if (head == null)
            throw new NoSuchElementException("List is Empty!");
        Node ptr = head;
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
        }
        return ptr;
    }

    @Override
    public int getFirst() {
        return getHead().getData();
    }

    @Override
    public int getLast() {
        return getTail().getData();
    }

    // @Override
    // public int get(int index) {
        
    // }

    @Override
    public void push(int data) {
        Node temp = new Node(data);
        if (isEmpty()) {
            head = temp;
        } else {
            // set the next being the old head
            temp.setNext(head);
            // the new head is the temp
            head = temp;
        }
        // increase the size
        size++;
    }

    @Override
    public void append(int data) {
        Node temp = new Node(data);
        if (isEmpty()) {
            head = temp;
        } else {
            getTail().setNext(temp);
        }
        size++;
    }

    @Override
    public void deleteFront() throws NoSuchElementException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFront'");
    }

    @Override
    public void deleteLast() throws NoSuchElementException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteLast'");
    }

    @Override
    public int removeFront() throws NoSuchElementException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFront'");
    }

    @Override
    public int removeLast() throws NoSuchElementException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

}
