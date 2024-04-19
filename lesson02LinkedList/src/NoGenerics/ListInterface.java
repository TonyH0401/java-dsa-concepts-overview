package NoGenerics;

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

    // delete data
    public void deleteFront() throws NoSuchElementException; // delete the head without returning value

    public void deleteLast() throws NoSuchElementException; // delete the tail without returning value

    // remove data
    public int removeFront() throws NoSuchElementException; // remove the head and return value

    public int removeLast() throws NoSuchElementException; // remove the tail and return value

}
