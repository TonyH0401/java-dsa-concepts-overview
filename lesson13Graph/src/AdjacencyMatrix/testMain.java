package AdjacencyMatrix;



public class testMain {
    public static void main(String[] args) throws Exception {
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix();
        String dir = "src\\AdjacencyMatrix\\AM.txt";
        adjMatrix.readFile(dir);
        adjMatrix.print();
        System.out.println("Vertices: " + adjMatrix.numOfVertex());
        System.out.println("Edges: " + adjMatrix.numOfEdge());
        adjMatrix.enumerateNeighbor(2);
        // ######################################################################## //
        System.out.println("######################################################");
        adjMatrix.BFS(3);
        System.out.println("######################################################");
        adjMatrix.DFS(5);
        // ######################################################################## //
        System.out.println("######################################################");
        adjMatrix.convertToAL().print();
    }
}
