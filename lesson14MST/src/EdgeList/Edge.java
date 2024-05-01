package EdgeList;

public class Edge {
    public int weight;
    public int source;
    public int dest;

    public Edge(int weight, int source, int dest) {
        this.weight = weight;
        this.source = source;
        this.dest = dest;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSource() {
        return this.source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDest() {
        return this.dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public String toString() {
        return "(" + source + "->" + dest + ": " + weight + ")";
    }

}
