package AVL;

public class testMain {
    public static void main(String[] args) throws Exception {
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(10);
        avl.insert(11);
        avl.insert(12);
        avl.insert(13);
        avl.insert(14);
        avl.insert(15);
        System.out.println("##################################");
        avl.print();
        System.out.println("##################################");
        avl.delete(13);
        avl.print();
    }
}
