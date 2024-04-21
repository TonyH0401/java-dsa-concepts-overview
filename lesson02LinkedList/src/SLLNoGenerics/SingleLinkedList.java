package SLLNoGenerics;

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

    // ######################################################################## //

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int data) {
        /*
         * The equals method will be defined by the Object Class, each Object Class will
         * have a different way to compare, we just call the equals method.
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

    // ######################################################################## //

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

    /*
     * It returns based on the datatype, so in this case it's int, but in the future
     * we may use generics.
     */
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0)
            throw new IndexOutOfBoundsException("Out of bound! Negative!");
        if (index >= size)
            throw new IndexOutOfBoundsException("Out of bound!");
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty!");
        Node current = head;
        int currentIndex = 0;
        while (current != null) {
            // if the current index = index -> returns the data
            if (currentIndex == index)
                return current.getData();
            // move to the next node and update the current index
            current = current.getNext();
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Out of bound!");
    }

    // ######################################################################## //

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
    public void addAt(int index, int data) throws NoSuchElementException {
        // check if the input index is invalid
        if (index < 0 || index >= size)
            throw new NoSuchElementException("Out of bound!");
        if (index == 0) {
            push(data);
            return;
        }
        // create a "node" for the input data and create a "ptr node" for the head
        Node temp = new Node(data);
        Node ptr = head;
        /*
         * we need to have (index - 1) because of how for loop works, it will perform
         * the function as long as the condition is met, so it may perform the function
         * before checking the condition.
         */
        for (int i = 0; i < (index - 1); i++) {
            ptr = ptr.getNext();
        }
        temp.setNext(ptr.getNext());
        ptr.setNext(temp);
        size++;
    }

    // ######################################################################## //

    @Override
    public void deleteFront() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        else
            head = head.getNext();
        size--;
    }

    @Override
    public void deleteLast() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException("List is empty!");
        Node ptr = head;
        while (ptr.getNext().getNext() != null)
            ptr = ptr.getNext();
        ptr.setNext(null);
        size--;
    }

    @Override
    public void deleteAt(int index) throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (index < 0 || index >= size)
            throw new NoSuchElementException("Out of bound!");
        if (index == 0) {
            deleteFront();
            return;
        }
        if (index == (size - 1)) {
            deleteLast();
            return;
        }
        Node ptr = head;
        for (int i = 0; i < (index - 1); i++) {
            ptr = ptr.getNext();
        }
        ptr.setNext(ptr.getNext().getNext());
        size--;
        return;
    }

    @Override
    public void deleteValue(int data) throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (!contains(data))
            throw new NoSuchElementException("No data contain this!");
        if (head.getData() == data) {
            deleteFront();
            return;
        }
        Node ptr = head;
        while (ptr.getNext().getData() != data)
            ptr = ptr.getNext();
        ptr.setNext(ptr.getNext().getNext());
        size--;
        return;
    }

    // ######################################################################## //

    @Override
    public int removeFront() throws NoSuchElementException {
        Node ptr = head;
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        } else {
            head = head.getNext();
        }
        size--;
        return ptr.getData();
    }

    @Override
    public int removeLast() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException("List is empty!");
        Node ptr = head;
        while (ptr.getNext().getNext() != null)
            ptr = ptr.getNext();
        Node temp = ptr.getNext();
        ptr.setNext(null);
        size--;
        return temp.getData();
    }

    @Override
    public int removeAt(int index) throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (index < 0 || index >= size)
            throw new NoSuchElementException("Out of bound!");
        if (index == 0) {
            return removeFront();
        }
        if (index == (size - 1)) {
            return removeLast();
        }
        Node ptr = head;
        for (int i = 0; i < (index - 1); i++) {
            ptr = ptr.getNext();
        }
        Node temp = ptr.getNext();
        ptr.setNext(ptr.getNext().getNext());
        size--;
        return temp.getData();
    }

    
    @Override
    public int removeValue(int data) throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (!contains(data))
            throw new NoSuchElementException("No data contain this!");
        if (head.getData() == data) {
            return removeFront();
        }
        Node ptr = head;
        while (ptr.getNext().getData() != data)
            ptr = ptr.getNext();
        Node temp = ptr.getNext();
        ptr.setNext(ptr.getNext().getNext());
        size--;
        return temp.getData();
    }

    // ######################################################################## //

    @Override
    public void addAt(Node current, int data) {
        if (isEmpty()) {
            push(data);
            return;
        }
        if (current == head) {
            push(data);
            return;
        }
        Node temp = new Node(data);
        Node ptr = head;
        while (ptr.getNext() != current)
            ptr = ptr.getNext();
        temp.setNext(ptr.getNext());
        ptr.setNext(temp);
        size++;
        return;
    }

    @Override
    public void addAfter(Node current, int data) throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (current.getNext() == null) {
            append(data);
            return;
        }
        Node temp = new Node(data);
        Node ptr = head;
        while (ptr != current) {
            ptr = ptr.getNext();
        }
        temp.setNext(ptr.getNext());
        ptr.setNext(temp);
        size++;
        return;
    }

    @Override
    public void deleteAt(Node current) throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (current == head) {
            deleteFront();
            return;
        }
        if (current.getNext() == null) {
            deleteLast();
            return;
        }
        Node ptr = head;
        while (ptr.getNext() != current)
            ptr = ptr.getNext();
        ptr.setNext(ptr.getNext().getNext());
        size--;
        return;
    }

    @Override
    public void deleteAfter(Node current) throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (current.getNext() == null)
            throw new NoSuchElementException("This is the last Node!");
        Node ptr = head;
        while (ptr != current)
            ptr = ptr.getNext();
        ptr.setNext(ptr.getNext().getNext());
        size--;
        return;
    }

    @Override
    public int removeAt(Node current) {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (current == head) {
            return removeFront();
        }
        if (current.getNext() == null) {
            return removeLast();
        }
        Node ptr = head;
        while (ptr.getNext() != current)
            ptr = ptr.getNext();
        Node temp = ptr.getNext();
        ptr.setNext(ptr.getNext().getNext());
        size--;
        return temp.getData();
    }

    @Override
    public int removeAfter(Node current) {
        if (isEmpty())
            throw new NoSuchElementException("List is empty!");
        if (current.getNext() == null)
            throw new NoSuchElementException("This is the last Node!");
        Node ptr = head;
        while (ptr != current)
            ptr = ptr.getNext();
        Node temp = ptr.getNext();
        ptr.setNext(ptr.getNext().getNext());
        size--;
        return temp.getData();
    }

}
