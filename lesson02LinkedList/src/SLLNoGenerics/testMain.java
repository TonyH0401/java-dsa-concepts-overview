package SLLNoGenerics;

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
            // Initialized the Integer Linked List:
            SingleLinkedList intList = new SingleLinkedList();
            // Using some methods to check whether the Linked List work or not:
            System.out.println("###########################################");
            System.out.println("Get the Linked List size before data: " + intList.size());
            System.out.println("Is the Linked List empty before data: " + intList.isEmpty());
            System.out.println("Does Linked List contain this value before data: " + intList.contains(0));
            // Adding data to the Linked List:
            System.out.println("###########################################");
            intList.push(1);
            intList.push(10);
            intList.push(100);
            intList.push(1000);
            intList.append(10000);
            intList.append(20);
            intList.append(30);
            intList.append(-10);
            intList.push(144);
            System.out.println("Get the Linked List size after adding data: " + intList.size());
            System.out.println("Is the Linked List empty after adding data: " + intList.isEmpty());
            System.out.println("Does Linked List contain this value: after adding data" + intList.contains(-1));
            System.out.println("Does Linked List contain this value: after adding data" + intList.contains(10));
            // because getHead and getTail return Node, we use getData to return the data of
            // these Node.
            System.out.println("Linked List First: " + intList.getFirst());
            System.out.println("Linked List Last: " + intList.getLast());
            System.out.println("Linked List Head (this returns Node): " + intList.getHead().getData());
            System.out.println("Linked List Tail (this returns Node): " + intList.getTail().getData());
            System.out.println("Get the data at index 0: " + intList.get(0));
            System.out.println("Get the data at index 2: " + intList.get(2));
            System.out.println("###########################################");
            print(intList);
            System.out.println("###########################################");
            intList.deleteFront();
            print(intList);
            System.out.println("###########################################");
            intList.deleteLast();
            print(intList);
            System.out.println("###########################################");
            System.out.println("Removed LinkedList Front: " + intList.removeFront());
            print(intList);
            System.out.println("###########################################");
            System.out.println("Removed LinkedList Last: " + intList.removeLast());
            print(intList);
            System.out.println("###########################################");
            intList.addAt(2, -20);
            print(intList);
            intList.addAt(5, -10);
            print(intList);
            System.out.println("###########################################");
            intList.deleteAt(2);
            print(intList);
            System.out.println("###########################################");
            System.out.println("Removed LinkedList At: " + intList.removeAt(3));
            print(intList);
            System.out.println("###########################################");
            intList.addAt(intList.getHead(), 113);
            print(intList);
            intList.addAt(intList.getHead().getNext().getNext(), 113);
            print(intList);
            intList.addAt(intList.getTail(), 113);
            print(intList);
        } catch (Exception e) {
            System.err.println("> Got an error: " + e.getMessage());
        }
    }

    public static void print(SingleLinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
