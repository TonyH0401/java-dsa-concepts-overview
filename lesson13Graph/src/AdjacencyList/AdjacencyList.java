package AdjacencyList;

import java.util.*;
import java.io.*;
import GraphInterfaces.*;

public class AdjacencyList implements GraphInterface {
    private int size;
    private int edges;
    private LinkedList<Integer>[] adj; // I think this is an array of linked list

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEdges() {
        return this.edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public LinkedList<Integer>[] getAdj() {
        return this.adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }

    @Override
    public void readFile(String dir) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFile'");
    }

    @Override
    public int numOfVertex() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numOfVertex'");
    }

    @Override
    public int numOfEdge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numOfEdge'");
    }

    @Override
    public void enumerateNeighbor(int u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enumerateNeighbor'");
    }

    @Override
    public boolean hasEdge(int u, int v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasEdge'");
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> linkedList = adj[i];
            System.out.print(i + ": ");
            for (int j = 1; j < linkedList.size(); j++) {
                System.out.print(linkedList.get(j) + " ");
            }
            System.out.println();
        }
    }

}
