package AdjacencyList;

import GraphInterfaces.GraphInterface;

public class testMain {
    public static void main(String[] args) throws Exception {
        GraphInterface adjacencyList = new AdjacencyList();
        String dir = "src\\AdjacencyList\\AL.txt";
        adjacencyList.readFile(dir);
        adjacencyList.print();
        System.out.println("Vertices: " + adjacencyList.numOfVertex());
        System.out.println("Edges: " + adjacencyList.numOfEdge());
        adjacencyList.enumerateNeighbor(4);
    }
}
