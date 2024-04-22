package QueueStack;

import java.util.*;

public interface QueueInterface<E> {
    // methods to check Stack Linked List
    public int size(); // get the size of the Stack Linked List

    public boolean isEmpty(); // check if the Stack Linked List is empty

    public boolean contains(E data) throws NoSuchElementException; // check if the Stack Linked List contains data

    // get data
    public E getFirst() throws NoSuchElementException;

    // add data
    public void enQueue(E data);

    // remove data
    public void deQueue() throws NoSuchElementException;

}
