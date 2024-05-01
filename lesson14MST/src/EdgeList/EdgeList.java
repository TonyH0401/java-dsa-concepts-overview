package EdgeList;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

import GraphInterface.*;
import UnionFind.UnionFind;

public class EdgeList implements GraphInterface {
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

    @Override
    public void readFile(String dir) {
        edges = new Vector<Edge>(10);
        numOfVertex = 0;
        try {
            Scanner scanner = new Scanner(new File(dir));
            Set<Integer> vertices = new HashSet<>();
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(" ");
                int w = Integer.parseInt(items[0]);
                int s = Integer.parseInt(items[1]);
                int d = Integer.parseInt(items[2]);

                Edge edge = new Edge(w, s, d);
                edges.add(edge);
                numOfVertex++;

                vertices.add(s);
                vertices.add(d);
            }
            this.numOfVertex = vertices.size();
            // System.out.println("list: " +edges.toString());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int numOfVertex() {
        return numOfVertex;
    }

    @Override
    public int numOfEdge() {
        return edges.size();
    }

    @Override
    public void enumerate(int u) {
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (edge.source == u) {
                System.out.print(edge.dest + " ");
            } else if (edge.dest == u) {
                System.out.print(edge.source + " ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean hasEdge(int u, int v) {
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if ((edge.source == u && edge.dest == v) ||
                    (edge.source == v && edge.dest == u)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void print() {
        for (int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i));
        }
    }

    // ######################################################################## //

    public void kruskal() {
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        UnionFind unionFind = new UnionFind(numOfVertex);
        int totalWeight = 0;
        int edgeCount = 0;

        for (int i = 0; i < edges.size() && edgeCount != (numOfVertex - 1); i++) {
            Edge e = edges.get(i);
            int s = e.source;
            int d = e.dest;
            int w = e.weight;

            if (unionFind.isSameSet(s, d)) {
                continue;
            }
            edgeCount++;
            totalWeight += w;
            unionFind.unionSet(s, d); // group s and d
            System.out.println(e.toString());
        }

        System.out.println("Total Weight: " + totalWeight);
    }

}
