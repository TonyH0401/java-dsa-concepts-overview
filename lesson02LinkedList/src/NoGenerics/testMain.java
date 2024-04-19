package NoGenerics;

public class testMain {
    public static void main(String[] args) throws Exception {
        /*
         * In this section, I'll create a simple link list using "int" as the data for
         * this link list, I will create another that have generics datatype which makes
         * it like the ArrayList.
         * 
         * Java has its LinkedList why do we need to create our own? To understand how
         * it works.
         * 
         * Imagine the Linked List as a train, it will help you.
         * 
         * Use in a try...catch block because I do throw an error.
         */
        try {
            SingleLinkedList intList = new SingleLinkedList();
            System.out.println("Get the Linked List size: " + intList.size());
            System.out.println("Is the Linked List empty: " + intList.isEmpty());
            System.out.println("Linked List contain this value: " + intList.contains(0));
            System.out.println("###########################################");
            intList.push(1);
            intList.push(10);
            intList.push(100);
            intList.push(1000);
            intList.append(10000);
            System.out.println("Get the Linked List size: " + intList.size());
            System.out.println("Is the Linked List empty: " + intList.isEmpty());
            System.out.println("Linked List contain this value: " + intList.contains(-1));
            System.out.println("Linked List contain this value: " + intList.contains(10));
            System.out.println("###########################################");
            // because getHead and getTail return Node, we use getData to return the data of
            // these Node.
            System.out.println("Linked List Head: " + intList.getHead().getData());
            System.out.println("Linked List Tail: " + intList.getTail().getData());
            System.out.println("###########################################");
            System.out.println("Linked List First: " + intList.getFirst());
            System.out.println("Linked List Last: " + intList.getLast());

            // System.out.println("Is the Linked List empty: " + intList.getFirst());
            // System.out.println("Is the Linked List empty: " + intList.getLast());
        } catch (Exception e) {
            System.err.println("> Got an error: " + e.getMessage());
        }
    }
}
