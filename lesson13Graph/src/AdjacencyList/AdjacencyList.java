package AdjacencyList;

import java.util.*;
import java.io.*;
import GraphInterfaces.*;

public class AdjacencyList implements GraphInterface {
    private int size;
    private int edges;
    private LinkedList<Integer>[] adj; // I think this is an array of linked list

    public AdjacencyList(LinkedList<Integer>[] adj, int size, int edges) {
        this.adj = adj;
        this.size = size;
        this.edges = edges;
    }


    public AdjacencyList() {
        //TODO Auto-generated constructor stub
    }


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

    public LinkedList<Integer>[] getAdj() {
        return this.adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }

    // ######################################################################## //

    @Override
    public void readFile(String dir) {
        File file = null;
        Scanner scan = null;
        String line = "";
        try {
            /* Init */
            file = new File(dir);
            scan = new Scanner(file);
            /*  */
            this.size = scan.nextInt();
            scan.nextLine();
            this.adj = new LinkedList[size];

            int count = 0;

            for (int i = 0; i < size; i++) {
                line = scan.nextLine();
                String[] numbers = line.split(" ");
                int index = Integer.parseInt(numbers[0]);
                adj[index] = new LinkedList<>();

                for (int j = 0; j < numbers.length; j++) {
                    int x = Integer.parseInt(numbers[j]);
                    adj[index].addLast(x);

                    count++;
                }
            }
            this.edges = count / 2;

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
        if (u < 1 || u > size) {
            throw new RuntimeException("Invalid");
        }
        u -= 1;
        LinkedList<Integer> list = adj[u];
        for (int i = 1; i < list.size(); i++) {
            int value = 1 + list.get(i);
            System.out.print(value + " ");
        }
        System.out.println();
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if (u < 1 || u > size || v < 1 || v > size) {
            throw new RuntimeException("Invalid");
        }
        u -= 1;
        v -= 1;
        LinkedList<Integer> list = adj[u];
        return list.contains(v);
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> linkedList = adj[i];
            System.out.print(i + ": ");
            for (int j = 1; j < linkedList.size(); j++) {
                System.out.print(linkedList.get(j) + " ");
            }
            System.out.println();
        }
    }

}
