package EdgeList;

import GraphInterfaces.GraphInterface;

public class testMain {
    public static void main(String[] args) throws Exception {
        try {
            GraphInterface edgeList = new EdgeList();
            String dir = "src\\EdgeList\\EL.txt";
            edgeList.readFile(dir);
            edgeList.print();
            System.out.println("Vertices: " + edgeList.numOfVertex());
            System.out.println("Edges: " + edgeList.numOfEdge());
            edgeList.enumerateNeighbor(2);
            System.err.println("Has Edge between 4 and n? ");
            for (int i = 0; i < edgeList.numOfVertex(); i++) {
                System.out.println("4 and " + i + ": " + edgeList.hasEdge(4, i));
            }
        } catch (Exception e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
