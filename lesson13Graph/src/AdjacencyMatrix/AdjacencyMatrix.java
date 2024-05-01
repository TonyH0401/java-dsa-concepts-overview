package AdjacencyMatrix;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import GraphInterfaces.*;
import AdjacencyList.AdjacencyList;

public class AdjacencyMatrix implements GraphInterface, GraphTraverse {
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
        File file = null;
        Scanner scan = null;
        String line = "";
        int sum = 0;
        try {
            file = new File(dir);
            scan = new Scanner(file);
            // get the row and column of the matrix
            this.size = scan.nextInt();
            // move to the next row
            scan.nextLine();

            adj = new int[size][size];

            for (int i = 0; i < size; i++) {
                line = scan.nextLine();
                String[] numbers = line.split(" ");
                for (int j = 0; j < size; j++) {
                    int x = Integer.parseInt(numbers[j]);
                    sum += x;
                    adj[i][j] = x;
                }
            }
            this.edges = sum / 2;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
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
        if (u < 1 || u > size) {
            throw new RuntimeException(u + " is not valid");
        }
        int row = u - 1;
        for (int i = 0; i < size; i++) {
            if (adj[row][i] == 1) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if (u < 1 || u > size || v < 1 || v > size) {
            throw new RuntimeException("Invalid Input");
        }
        u -= 1;
        v -= 1;
        return adj[u][v] == 1;
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

    @Override
    public void BFS(int s) {
        if (s < 1 || s > size)
            throw new RuntimeException("Invalid Input!");
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print((x + 1) + " ");
            for (int i = 0; i < size; i++) {
                if (adj[x][i] != 0 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void DFS(int s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[size];

        s -= 1;
        visited[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            int x = stack.pop();
            System.out.print(x + 1 + " ");

            for (int i = 0; i < size; i++) {
                if (!visited[i] && adj[x][i] == 1) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    // ######################################################################## //

    public boolean isReachable(int u, int v) {
        if (u < 1 || u > size || v < 1 || v > size) {
            throw new RuntimeException("Invalid Input");
        }
        if (hasEdge(u, v) == true)
            return true;
        return false;
    }

    public AdjacencyList convertToAL() {
        LinkedList<Integer>[] new_adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            new_adj[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < size; i++) {
            new_adj[i].addLast(i);
            for (int j = 0; j < size; j++) {
                if (adj[i][j] != 0) {
                    new_adj[i].addLast(j);
                }
            }
        }
        return new AdjacencyList(new_adj, size, edges);
    }

}
