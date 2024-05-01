package GraphInterfaces;

public interface GraphInterface {
    public void readFile(String dir);

    public int numOfVertex();

    public int numOfEdge();

    public void enumerateNeighbor(int u);

    public boolean hasEdge(int u, int v);

    public void print();

}
