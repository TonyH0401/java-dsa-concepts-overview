package AVL;

/* 'E extends Comparable<E>' add this to use compareTo() with generics datatype E, I forgot where I took this from. */
public class AVL<E extends Comparable<E>> {
    private Node<E> root;

    public AVL() {
        this.root = null;
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    // ######################################################################## //

    private Node<E> rotateLeft(Node<E> x) {
        Node<E> y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        // x.setRight();
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
            return null;
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


}
