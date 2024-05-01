package AdjacencyMatrix;

public class testMain {
    public static void main(String[] args) throws Exception {
        try {
            AdjacencyMatrix am = new AdjacencyMatrix();
            String dir1 = "src\\AdjacencyMatrix\\AM.txt";
            String dir2 = "src\\AdjacencyMatrix\\AM2.txt";
            am.readFile(dir1);
            am.print();
            System.out.println("===================");
            am.prim(0);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
