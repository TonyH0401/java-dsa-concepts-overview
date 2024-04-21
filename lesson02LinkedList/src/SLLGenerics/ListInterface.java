package SLLGenerics;

import java.util.*;

public interface ListInterface<E> {
    // methods to check LinkedList
    public int size(); // get the size of the LinkedList

    public boolean isEmpty(); // check if the LinkedList is empty

    public boolean contains(E data); // check if the LinkedList contains data

    // get data
    public Node<E> getHead(); // get the head node of the LinkedList

    public Node<E> getTail(); // get the tail node of the LinkedList

    public E getFirst(); // get the first data of the LinkedList

    public E getLast(); // get the last data of the LinkedList

    public E get(int index) throws IndexOutOfBoundsException; // get the data by index of the list

    // add data
    public void push(E data); // add new data at the begining

    public void append(E data); // add new data at the end

    public void addAt(int index, E data) throws NoSuchElementException; // add new data based on index

    // delete data
    public void deleteFront() throws NoSuchElementException; // delete the head without returning value

    public void deleteLast() throws NoSuchElementException; // delete the tail without returning value

    public void deleteAt(int index) throws NoSuchElementException; // delete data at index

    public void deleteValue(E data) throws NoSuchElementException; // delete based on value

    // remove data
    public E removeFront() throws NoSuchElementException; // remove the head and return value

    public E removeLast() throws NoSuchElementException; // remove the tail and return value

    public E removeAt(int index) throws NoSuchElementException; // remove the data based on index and return value

    public E removeValue(E data) throws NoSuchElementException;

    /*
     * I believe that these functions below are stupid and unneeded, it's the same
     * reason people trying to reinvent "the wheel" and then going back to using the
     * wheel again and then saying the wheel is good and denied ever doing anything
     * else.
     * 
     * These functions will add and delete data in a linked list based on the given
     * node.
     */
    // public void addAt(Node<E> current, E data);

    // public void addAfter(Node<E> current, E data) throws NoSuchElementException;

    // public void deleteAt(Node<E> current) throws NoSuchElementException;

    // public void deleteAfter(Node<E> current) throws NoSuchElementException;

    // public E removeAt(Node<E> current) throws NoSuchElementException;

    // public E removeAfter(Node<E> current) throws NoSuchElementException;

}
