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

    /*
     * This is different, this will return the height of the node instead of the
     * tree. I need to change the name to a more suitable one.
     */
    private int height(Node<E> node) {
        if (node == null)
            return 0;
        return node.getDepth();
    }

    // ######################################################################## //

    /* Check if the tree is balanced. Returns boolean values. */
    private boolean isBalance(Node<E> node) {
        int factor = height(node.getLeft()) - height(node.getRight());
        /*
         * The tree is balanced if the depth is -1 or 0 or 1, so if it's larger or
         * lesser than that, the tree is not balanced.
         */
        if (factor > 1 || factor < -1)
            return false;
        return true;
    }

    /*
     * This returns the lean value of the tree, if this value is 1 the tree is
     * leaning right, if this value is -1 the tree is leaning left, if this value is
     * 0 the tree is balanced.
     */
    private int treeLeanValue(Node<E> node) {
        if (node == null)
            return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    // ######################################################################## //

    /*
     * These are the rotations used for making the tree balanced. There are left
     * rotaion and right rotation.
     */

    private Node<E> rotateLeft(Node<E> x) {
        Node<E> y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        x.setDepth(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setDepth(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        return y;
    }

    private Node<E> rotateRight(Node<E> x) {
        Node<E> y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);
        x.setDepth(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setDepth(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        return y;
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
        /* This part is the normal BST */
        if (node == null)
            return new Node<E>(data);
        if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(node.getRight(), data));
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft((insert(node.getLeft(), data)));
        } else
            return node;
        /* This is where AVL starts. */
        node.setDepth(1 + (int) Math.max((double) height(node.getLeft()), (double) height(node.getRight())));
        /* Auto balance the tree at insert. */
        if (isBalance(node))
            return node;
        if ((node.getLeft() != null) && (data.compareTo(node.getLeft().getData()) < 0))
            return rotateRight(node);
        if ((node.getRight() != null) && (data.compareTo(node.getRight().getData()) > 0))
            return rotateLeft(node);
        if ((node.getLeft() != null) && (data.compareTo(node.getLeft().getData()) > 0)) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if ((node.getRight() != null) && (data.compareTo(node.getRight().getData()) < 0)) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
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
            root = delete(root, data);
        }
    }

    private Node<E> delete(Node<E> node, E data) {
        /* This section is from the normal BST */
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), data));
        } else {
            // delete a node with one child a.k.a a leaf
            if (node.getRight() == null)
                return node.getLeft();
            if (node.getLeft() == null)
                return node.getRight();

            // delete a node with two children
            Node<E> t = node;
            node = min(t.getRight());
            node.setRight(deleteMin(t.getRight()));
            node.setLeft(t.getLeft());
        }
        /* This section is the AVL section: */
        // update the height
        node.setDepth(1 + (int) Math.max((double) height(node.getLeft()), (double) height(node.getRight())));
        // check if the tree is balanced
        if (isBalance(node)) {
            return node;
        }
        // if the tree is not balanced, get the tree leaning value. there are 4 cases
        int balance = treeLeanValue(node);
        // Left Left Case
        if (balance > 1 && treeLeanValue(node.getLeft()) >= 0)
            return rotateRight(node);
        // Left Right Case
        if (balance > 1 && treeLeanValue(node.getLeft()) < 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        // Right Right Case
        if (balance < -1 && treeLeanValue(node.getRight()) <= 0)
            return rotateLeft(node);
        // Right Left Case
        if (balance < -1 && treeLeanValue(node.getLeft()) > 0) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        return node;
    }

    // ######################################################################## //

    /*
     * We need to change from getDepth() to getTreeDepth() because Node has another
     * value called getDepth() and we do not want to confuse between the 2.
     */
    public int getTreeDepth() {
        return getTreeDepth(root);
    }

    private int getTreeDepth(Node<E> node) {
        if (node == null)
            return 0;
        int leftHeight = getTreeDepth(node.getLeft());
        int rightHeight = getTreeDepth(node.getRight());
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
