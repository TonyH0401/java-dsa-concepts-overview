package StackSLLGenerics;

import java.util.*;

public class StackSLL<E> implements StackListInterface<E> {
    private Node<E> top;
    private int size;

    public StackSLL() {
        this.top = null;
        this.size = 0;
    }

    public Node<E> getTop() {
        return this.top;
    }

    public void setTop(Node<E> top) {
        this.top = top;
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
        if (top == null)
            return false;
        Node<E> ptr = top;
        /*
         * Because our LinkedList uses int as the datatype, we will use "==" to compare
         * data, but if it's an Object Class, each Object Class will have a different
         * method for comparation and it will be defined in the Object Class not the
         * LinkedList itself.
         */
        while (ptr != null) {
            if (ptr.getData().equals(data))
                return true;
            ptr = ptr.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // ######################################################################## //

    @Override
    public E peek() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        return getTop().getData();
    }

    // ######################################################################## //

    @Override
    public void push(E data) {
        Node<E> temp = new Node<E>(data);
        if (isEmpty()) {
            top = temp;
        } else {
            temp.setNext(top);
            top = temp;
        }
        size++;
    }

    // ######################################################################## //

    @Override
    public E pop() throws NoSuchElementException {
        Node<E> ptr = top;
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        } else {
            top = top.getNext();
        }
        size--;
        return ptr.getData();
    }

    // ######################################################################## //
    /*
     * Start from the top, print from the top, W.A.P
     */
    public void print() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        Node<E> ptr = top;
        while (ptr != null) {
            System.out.println(ptr.getData() + " ");
            ptr = ptr.getNext();
        }
        return;
    }
}
