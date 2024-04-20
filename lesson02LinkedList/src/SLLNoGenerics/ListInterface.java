package SLLNoGenerics;

import java.util.*;

public interface ListInterface {
    // methods to check LinkedList
    public int size(); // get the size of the LinkedList

    public boolean isEmpty(); // check if the LinkedList is empty

    public boolean contains(int data); // check if the LinkedList contains data

    // get data
    public Node getHead(); // get the head node of the LinkedList

    public Node getTail(); // get the tail node of the LinkedList

    public int getFirst(); // get the first data of the LinkedList

    public int getLast(); // get the last data of the LinkedList

    public int get(int index) throws IndexOutOfBoundsException; // get the data by index of the list

    // add data
    public void push(int data); // add new data at the begining

    public void append(int data); // add new data at the end

    public void addAt(int index, int data) throws NoSuchElementException; // add new data based on index

    // delete data
    public void deleteFront() throws NoSuchElementException; // delete the head without returning value

    public void deleteLast() throws NoSuchElementException; // delete the tail without returning value

    public void deleteAt(int index) throws NoSuchElementException; // delete data at index

    // remove data
    public int removeFront() throws NoSuchElementException; // remove the head and return value

    public int removeLast() throws NoSuchElementException; // remove the tail and return value

    public int removeAt(int index) throws NoSuchElementException; // remove the data based on index and return value

    // remember to add delete value and remove value

    /*
     * I believe that these functions below are stupid and unneeded, it's the same
     * reason people trying to reinvent "the wheel" and then going back to using the
     * wheel again and then saying the wheel is good.
     * 
     * These functions will add and delete data in a linked list based on the given
     * node.
     */
    public void addAt(Node current, int data);

    public void addAfter(Node current, int data);

    // public void addAfter()
    public void deleteAt(Node current) throws NoSuchElementException;

    public void deleteAfter(Node current) throws NoSuchElementException;

    public int removeAt(Node current) throws NoSuchElementException;

    public int removeAfter(Node current) throws NoSuchElementException;

}
