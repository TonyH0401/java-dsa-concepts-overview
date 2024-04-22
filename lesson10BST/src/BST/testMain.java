package BST;

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
        // Testing methods:
        System.out.println("> Check if variable 96 exist: " + bst.contains(96));
        System.out.println("> Check if variable 100 exist: " + bst.contains(100));
        System.out.println("> Get BST Min: " + bst.min());
        System.out.println("> Get BST Max: " + bst.max());
        bst.deleteMin();
        System.out.println("> Display the BST after delete Min:");
        bst.print();
        bst.deleteMax();
        System.out.println("> Display the BST after delete Max:");
        bst.print();
        bst.delete(-100);
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
        // Post order and Pre order:
        System.out.println("> Display the BST Post Order:");
        bst.postOrder();
        System.out.println("> Display the BST Pre Order:");
        bst.preOrder();
    }
}
