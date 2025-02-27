package BST;

import java.util.ArrayList;

public class testMain {
    public static void main(String[] args) throws Exception {
        // Initialize BST:
        BST<Integer> bst = new BST<Integer>();
        // Insert data randomly:
        bst.insert(77);
        bst.insert(96);
        bst.insert(41);
        bst.insert(5);
        bst.insert(2);
        bst.insert(100);
        bst.insert(1);
        bst.insert(90);
        bst.insert(7);
        // Display the BST:
        System.out.println("> Display the BST:");
        bst.print();

        // Test `contains()` method:
        System.out.println("> Check if variable 96 exist: " + bst.contains(96));
        System.out.println("> Check if variable 100 exist: " + bst.contains(100));

        // Test `min()` and `max()` method:
        System.out.println("> Get BST Min: " + bst.min());
        System.out.println("> Get BST Max: " + bst.max());

        // Test `deleteMin()` method:
        bst.deleteMin();
        System.out.println("> Display the BST after delete Min:");
        bst.print();

        // Test `deleteMax()` method:
        bst.deleteMax();
        System.out.println("> Display the BST after delete Max:");
        bst.print();

        // Test deleting a non-existence value:
        bst.delete(-100);

        // Test deleting a value:
        bst.delete(96);
        System.out.println("> Display the BST after delete 96:");
        bst.print();
        bst.delete(5);
        System.out.println("> Display the BST after delete 5:");
        bst.print();
        System.out.println("> Get BST Depth: " + bst.getDepth());

        // Right Skewed:
        BST<Integer> bstRS = new BST<Integer>();
        bstRS.insert(1);
        bstRS.insert(2);
        bstRS.insert(3);
        System.out.println("> Display the BST Right Skewed:");
        bstRS.print();

        // Left Skewed:
        BST<Integer> bstLS = new BST<Integer>();
        bstLS.insert(3);
        bstLS.insert(2);
        bstLS.insert(1);
        System.out.println("> Display the BST Left Skewed:");
        bstLS.print();

        // Pre-order + In-order + Post order:
        System.out.println("> Display the BST Pre Order:");
        bst.preOrder();
        System.out.println("> Display the BST In Order:");
        bst.inOrder();
        System.out.println("> Display the BST Post Order:");
        bst.postOrder();

        // Level Order Traversal - BFS Using ArrayList
        System.out.println("> Testing Level Order Traversal - BFS");
        ArrayList<ArrayList<Integer>> result = bst.levelOrderBFS(bst.getRoot());
        for (ArrayList<Integer> level : result) {
            for (int data : level) {
                System.out.print(data + " ");
            }
        }
        System.out.println();

        // Level Order Traversal - BFS Using Queue
        System.out.println("> Testing Level Order Traversal - BFS Using Queue");
        bst.levelOrderBFSUsingQueue(bst.getRoot());

    }
}
