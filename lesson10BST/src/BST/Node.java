package BST;

public class Node<E> {
    private Node<E> left, right;
    private E data;

    public Node(E data) {
        this.left = this.right = null;
        this.data = data;
    }

    public Node<E> getLeft() {
        return this.left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return this.right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
