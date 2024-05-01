package EdgeList;

public class testMain {
    public static void main(String[] args) throws Exception {
        try {
            EdgeList el = new EdgeList();
            String dir1 = "src\\EdgeList\\EL.txt";
            String dir2 = "src\\EdgeList\\EL2.txt";
            el.readFile(dir1);
            el.print();
            el.kruskal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
