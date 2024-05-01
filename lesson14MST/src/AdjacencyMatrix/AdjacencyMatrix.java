package AdjacencyMatrix;

import java.io.*;
import java.util.*;

import GraphInterface.*;

public class AdjacencyMatrix implements GraphInterface {
    private int[][] adj;
    private int size;
    private int numOfEdge;

    public int[][] getAdj() {
        return this.adj;
    }

    public void setAdj(int[][] adj) {
        this.adj = adj;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumOfEdge() {
        return this.numOfEdge;
    }

    public void setNumOfEdge(int numOfEdge) {
        this.numOfEdge = numOfEdge;
    }

    // ######################################################################## //

    @Override
    public void readFile(String dir) {
        try {

            Scanner scanner = new Scanner(new File(dir));

            size = scanner.nextInt();
            scanner.nextLine();

            adj = new int[size][size];
            int sum = 0;

            for (int i = 0; i < size; i++) {
                String[] items = scanner.nextLine().split(" ");
                for (int j = 0; j < items.length; j++) {
                    adj[i][j] = Integer.parseInt(items[j]);
                    if (adj[i][j] > 0) {
                        // sum += adj[i][j];
                        sum++;
                    }
                }
            }

            numOfEdge = sum / 2;
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int numOfVertex() {
        return size;
    }

    @Override
    public int numOfEdge() {
        return numOfEdge;
    }

    @Override
    public void enumerate(int u) {
        if (u < 1 || u > size) {
            throw new RuntimeException("Invalid Parameter");
        }
        u -= 1;
        for (int i = 0; i < size; i++) {
            if (adj[u][i] == 1) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if (u < 1 || u > size || v < 1 || v > size) {
            throw new RuntimeException("Invalid Parameter");
        }
        return adj[u - 1][v - 1] == 1;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ######################################################################## //

    /* Give is the sorted way + the weight of this way */
    public void prim(int u) {
        List<Integer> visited = new ArrayList<Integer>();
        int totalWeight = 0;

        visited.add(u);

        while (visited.size() < numOfVertex()) {
            int minWeight = Integer.MAX_VALUE;
            int sourceVertex = -1;
            int desertex = -1;

            for (Integer s : visited) {
                for (int d = 0; d < numOfVertex(); d++) {
                    if (visited.contains(d)) {
                        continue;
                    }
                    if (adj[s][d] > 0 && adj[s][d] < minWeight) {
                        minWeight = adj[s][d];
                        sourceVertex = s;
                        desertex = d;
                    }
                }
            }
            System.out.println(sourceVertex + "->" + desertex + ": " + minWeight);
            totalWeight += minWeight;

            visited.add(desertex);
        }
        System.out.println("Total Weight: " + totalWeight);
    }

}
