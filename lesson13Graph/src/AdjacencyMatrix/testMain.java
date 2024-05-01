package AdjacencyMatrix;

import GraphInterfaces.*;

public class testMain {
    public static void main(String[] args) throws Exception {
        GraphInterface adjMatrix = new AdjacencyMatrix();
        String dir = "src\\AdjacencyMatrix\\AM.txt";
        adjMatrix.readFile(dir);
        adjMatrix.print();
        System.out.println("Vertices: " + adjMatrix.numOfVertex());
        System.out.println("Edges: " + adjMatrix.numOfEdge());
        adjMatrix.enumerateNeighbor(2);
        // ######################################################################## //
    }
}
