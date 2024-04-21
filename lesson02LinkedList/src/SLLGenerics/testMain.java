package SLLGenerics;

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
            /* Initialized the Integer Linked List: */
            SingleLinkedList<Student> studentList = new SingleLinkedList<Student>();
            /* Using some methods to check whether the Linked List work or not: */
            System.out.println("###########################################");
            System.out.println("Get the Linked List size before data: " + studentList.size());
            System.out.println("Is the Linked List empty before data: " + studentList.isEmpty());
            System.out.println(
                    "Does Linked List contain this value before data: " + studentList.contains(new Student(0, null)));
            /* Adding data to the Linked List: */
            System.out.println("###########################################");
            studentList.push(new Student(1, "One"));
            studentList.push(new Student(2, "Two"));
            studentList.push(new Student(3, "Three"));
            studentList.push(new Student(4, "Four"));
            studentList.append(new Student(5, "Five"));
            studentList.append(new Student(6, "Six"));
            studentList.append(new Student(7, "Seven"));
            studentList.append(new Student(8, "Eight"));
            studentList.push(new Student(9, "Nine"));
            System.out.println("Get the Linked List size after adding data: " + studentList.size());
            System.out.println("Is the Linked List empty after adding data: " + studentList.isEmpty());
            System.out.println("Does Linked List contain this value after adding data: "
                    + studentList.contains(new Student(0, null)));
            System.out.println("Does Linked List contain this value after adding data: "
                    + studentList.contains(new Student(8, "Eight")));
            /*
             * because getHead and getTail return Node, we use getData to return the data of
             * these Node.
             */
            System.out.println("Linked List First: " + studentList.getFirst());
            System.out.println("Linked List Last: " + studentList.getLast());
            System.out.println("Linked List Head (this returns Node): " + studentList.getHead().getData());
            System.out.println("Linked List Tail (this returns Node): " + studentList.getTail().getData());
            System.out.println("Get the data at index 0: " + studentList.get(0));
            System.out.println("Get the data at index 2: " + studentList.get(2));
            System.out.println("Get the data at index 4: " + studentList.get(4));
            System.out.println("###########################################");
            print(studentList);
            System.out.println("###########################################");
            studentList.deleteFront();
            print(studentList);
            System.out.println("###########################################");
            studentList.deleteLast();
            print(studentList);
            System.out.println("###########################################");
            System.out.println("Removed LinkedList Front: " + studentList.removeFront());
            print(studentList);
            System.out.println("###########################################");
            System.out.println("Removed LinkedList Last: " + studentList.removeLast());
            print(studentList);
            System.out.println("###########################################");
            studentList.addAt(2, new Student(4, "Four"));
            print(studentList);
            studentList.addAt(5, new Student(7, "Seven"));
            print(studentList);
            System.out.println("###########################################");
            studentList.deleteAt(2);
            print(studentList);
            System.out.println("###########################################");
            System.out.println("Removed LinkedList At: " + studentList.removeAt(3));
            print(studentList);
            System.out.println("###########################################");
            studentList.deleteValue(new Student(1, "One"));
            print(studentList);
            System.out.println("###########################################");
            System.out.println("Remove value: " + studentList.removeValue(new Student(7, "Seven")));
            print(studentList);
            /*
             * There are a few more but I consider them to be unneeded so...I won't
             * implement them, you can check them out in the SLL Non-Generics version.
             */
        } catch (Exception e) {
            System.err.println("> Got an error: " + e.getMessage());
        }
    }

    public static <E> void print(SingleLinkedList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
