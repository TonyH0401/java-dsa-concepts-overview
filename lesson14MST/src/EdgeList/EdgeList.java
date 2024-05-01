package EdgeList;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class EdgeList {
    private int numOfVertex;
    private Vector<Edge> edges;

    public int getNumOfVertex() {
        return this.numOfVertex;
    }

    public void setNumOfVertex(int numOfVertex) {
        this.numOfVertex = numOfVertex;
    }

    public Vector<Edge> getEdges() {
        return this.edges;
    }

    public void setEdges(Vector<Edge> edges) {
        this.edges = edges;
    }

}
