package GraphInterface;

public interface GraphInterface {
    public void readFile(String dir);

    public int numOfVertex();

    public int numOfEdge();

    public void enumerate(int u);

    public boolean hasEdge(int u, int v);

    public void print();
}
