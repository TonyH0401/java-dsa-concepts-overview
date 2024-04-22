package QueueStack;

import java.util.*;

public interface StackInterface<E> {
    // methods to check Stack Linked List
    public int size(); // get the size of the Stack Linked List

    public boolean isEmpty(); // check if the Stack Linked List is empty

    public boolean contains(E data) throws NoSuchElementException; // check if the Stack Linked List contains data

    // get data
    public E peek() throws NoSuchElementException;

    // add data
    public void push(E data);

    // remove data
    public E pop() throws NoSuchElementException;

}
