package BST;

/* I suggest only import packages which you need in order to save storage. */
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/* Note: 'E extends Comparable<E>' add this to use compareTo() with generics datatype E, I forgot where I took this from. */
public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public BST() {
        this.root = null;
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    // ######################################################################## //

    public void insert(E data) {
        this.root = insert(root, data);
    }

    /*
     * The compareTo() is the same as equals() where it's defined at the Object
     * Class level not the List level, each Object Class will have a different
     * method of comparing.
     */
    private Node<E> insert(Node<E> node, E data) {
        if (node == null)
            return new Node<E>(data);
        if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(node.getRight(), data));
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft((insert(node.getLeft(), data)));
        }
        // I should add something called incretement frequency (at = 0), probably to the
        // Node.
        return node;
    }

    // ######################################################################## //

    public void print() {
        print(root, 0);
    }

    private void print(Node<E> node, int level) {
        if (node == null)
            return;
        // traverse the right side
        print(node.getRight(), level + 1);
        // format the output
        for (int i = 0; i < level; i++)
            System.out.print("\t");
        // print the node
        System.out.println(node.getData());
        // traverse the left side
        print(node.getLeft(), level + 1);
    }

    // ######################################################################## //

    public boolean contains(E data) {
        if (search(root, data) == null)
            return false;
        return true;
    }

    private Node<E> search(Node<E> node, E data) {
        if (node == null)
            return null;
        if (data.compareTo(node.getData()) < 0) {
            return search(node.getLeft(), data);
        } else if (data.compareTo(node.getData()) > 0) {
            return search(node.getRight(), data);
        } else {
            return node;
        }
    }

    // ######################################################################## //

    /* With max data you just need to check for the right side. */
    public E max() {
        return max(root).getData();
    }

    private Node<E> max(Node<E> node) {
        if (node.getRight() == null)
            return node;
        else
            return max(node.getRight());
    }

    // ######################################################################## //

    /* With min data you just need to check for the left side. */
    public E min() {
        return min(root).getData();
    }

    private Node<E> min(Node<E> node) {
        if (node.getLeft() == null)
            return node;
        else
            return min(node.getLeft());
    }

    // ######################################################################## //

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node<E> deleteMax(Node<E> node) {
        if (node.getRight() == null)
            return node.getLeft();
        node.setRight(deleteMax(node.getRight()));
        return node;
    }

    // ######################################################################## //

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node<E> deleteMin(Node<E> node) {
        if (node.getLeft() == null)
            return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

    // ######################################################################## //

    public void delete(E data) {
        if (!contains(data)) {
            System.err.println("> No data to be deleted exist!");
            return;
        } else {
            delete(root, data);
        }
    }

    private Node<E> delete(Node<E> node, E data) {
        if (node == null)
            return null;
        /* These are used to locate the node to be deleted */
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), data));
        } else {
            /* Delete a node with 1 child a.k.a a leaf */
            if (node.getRight() == null)
                return node.getLeft();
            if (node.getLeft() == null)
                return node.getRight();
            /* Delete a node with 2 chidlren */
            Node<E> t = node;
            node = min(t.getRight());
            node.setRight(deleteMin(t.getRight()));
            node.setLeft(t.getLeft());
            /*
             * Usually, we need 3 use-cases (no leaf, a leaf and leafs), but here we only
             * have 2 which are a leaf and leafs.
             * The use-case for no leaf is embedded in the a leaf use-case. If a node has no
             * leaf both the left and right are null. So, we just need to return either one
             * of them and that was what we did.
             */
        }
        return node;
    }

    // ######################################################################## //

    public int getDepth() {
        return getDepth(root);
    }

    private int getDepth(Node<E> node) {
        if (node == null)
            return 0;
        int leftHeight = getDepth(node.getLeft());
        int rightHeight = getDepth(node.getRight());
        return (1 + Math.max(leftHeight, rightHeight));
    }

    // ######################################################################## //

    public void postOrder() {
        postOrder(root, 0);
    }

    public void postOrder(Node<E> node, int level) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft(), level + 1);
        postOrder(node.getRight(), level + 1);
        System.out.println(node.getData());
    }

    // ######################################################################## //

    public void preOrder() {
        preOrder(root, 0);
    }

    public void preOrder(Node<E> node, int level) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preOrder(node.getLeft(), level + 1);
        preOrder(node.getRight(), level + 1);
    }

    // ######################################################################## //

    public void inOrder() {
        inOrder(root, 0);
    }

    public void inOrder(Node<E> root, int level) {
        if (root == null)
            return;
        inOrder(root.getLeft(), level + 1);
        System.out.println(root.getData());
        inOrder(root.getRight(), level + 1);
    }

    // ######################################################################## //

    /*
     * Level Order Traversal or BFS is where the order of traversal is level base,
     * where all nodes present in the same level are traversed completely before
     * traversing the next level.
     */

    /*
     * In this implementation, I used ArrayList. Each ArrayList represents a level
     * within the BST and all of those ArrayList (level) are collected into a bigger
     * ArrayList.
     */

    public ArrayList<ArrayList<E>> levelOrderBFS(Node<E> root) {
        ArrayList<ArrayList<E>> result = new ArrayList<>();
        levelOrderBFS(root, 0, result);
        return result;
    }

    public void levelOrderBFS(Node<E> root, int level, ArrayList<ArrayList<E>> result) {
        if (root == null) {
            return;
        }
        // Add an additional level for safe keeping.
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        // Add data to its corresponding level.
        result.get(level).add(root.getData());
        // Traverse the left and the right of the tree with an increment level of 1.
        levelOrderBFS(root.getLeft(), level + 1, result);
        levelOrderBFS(root.getRight(), level + 1, result);
    }

    // ######################################################################## //

    /*
     * Level Order Traversal or BFS is where the order of traversal is level base,
     * where all nodes present in the same level are traversed completely before
     * traversing the next level.
     */

    /*
     * In this implementation, I used Queue. I will enqueue and dequeue each level
     * of the tree. Enqueue and dequeue the first level. Moving to the next level of
     * left and right, using enqueue and dequeue at the same time.
     */

    public void levelOrderBFSUsingQueue(Node<E> root) {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        // This is where the loop start
        while (!queue.isEmpty()) {
            // Dequeue a node
            Node<E> current = queue.poll();
            System.out.print(current.getData() + " ");
            // Enqueue the left node
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            // Enqueue the right node
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    // ######################################################################## //

    /*
     * DFS doesn't have any other names like BFS (Level Order Traversal). However,
     * it has 3 types being Pre-order, In-order and Post-order. All of which I have
     * implemented above. The key difference between all three and the most
     * important when using DFS is where you put the `print` statement.
     */

    // ######################################################################## //

}
