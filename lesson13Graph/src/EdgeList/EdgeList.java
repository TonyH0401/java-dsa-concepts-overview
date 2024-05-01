package EdgeList;

import java.util.*;
import java.io.*;

import GraphInterfaces.*;

public class EdgeList implements GraphInterface {
    private int size;
    private int edges;
    private int[][] adj;

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEdges() {
        return this.edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public int[][] getAdj() {
        return this.adj;
    }

    public void setAdj(int[][] adj) {
        this.adj = adj;
    }

    // ######################################################################## //

    @Override
    public void readFile(String dir) {
        // init stage
        File file = null;
        Scanner scan = null; // quick tip, don't do this but declare static instead.
        String line = "";
        int height = 0;
        ArrayList<String> list = new ArrayList<String>();
        try {
            file = new File(dir);
            scan = new Scanner(file);
            /*
             * Why did I used hasNextLine(), because it will take the last line whether or
             * not there is a newline at the end.
             */
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                list.add(line);
                height++;
            }
            adj = new int[height][3];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < 3; j++) {
                    String[] numbers = list.get(i).split(" ");
                    adj[i][j] = Integer.parseInt(numbers[j]);
                }
            }
            ArrayList<Integer> intList = new ArrayList<Integer>();
            for (int k = 1; k < 3; k++) {
                for (int l = 0; l < height; l++) {
                    intList.add(adj[l][k]);
                }
            }
            ArrayList<Integer> intList2 = new ArrayList<Integer>();
            for (Integer integer : intList) {
                if (!intList2.contains(integer)) {
                    intList2.add(integer);
                }
            }
            this.size = intList2.size();
            this.edges = height;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            scan.close();
        }
    }

    @Override
    public int numOfVertex() {
        return size;
    }

    @Override
    public int numOfEdge() {
        return edges;
    }

    @Override
    public void enumerateNeighbor(int u) {
        if (u < -1 || u > size) {
            throw new RuntimeException("Invalid Input");
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            if (adj[i][1] == u) {
                list.add(adj[i][2]);
            }
        }
        for (int i = 0; i < edges; i++) {
            if (adj[i][2] == u) {
                list.add(adj[i][1]);
            }
        }
        /* Display the list. */
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if (u < 0 || u > size || v < 0 || v > size) {
            throw new RuntimeException("Invalid Inputs");
        }
        for (int i = 0; i < edges; i++) {
            if ((adj[i][1] == u && adj[i][2] == v) || (adj[i][1] == v && adj[i][2] == u)) {
                return true;
            }
        }
        return false;
    }

    /* The graph is represented as a nx3 matrix. */
    @Override
    public void print() {
        for (int i = 0; i < edges; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ######################################################################## //

}
