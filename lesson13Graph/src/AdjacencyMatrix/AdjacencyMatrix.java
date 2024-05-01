package AdjacencyMatrix;

import java.io.*;
import GraphInterfaces.*;

public class AdjacencyMatrix implements GraphInterface {
    private int size;
    private int edges;
    private int[][] adj;

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

    public int[][] getAdj() {
        return this.adj;
    }

    public void setAdj(int[][] adj) {
        this.adj = adj;
    }

    // ######################################################################## //

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }

}
