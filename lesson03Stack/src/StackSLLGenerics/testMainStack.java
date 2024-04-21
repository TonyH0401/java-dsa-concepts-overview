package StackSLLGenerics;

public class testMainStack {
    public static void main(String[] args) throws Exception {
        try {
            StackSLL<Integer> intStack = new StackSLL<Integer>();
            intStack.push(10);
            intStack.push(100);
            intStack.push(1000);
            System.out.println("> Display the Stack (start from the top to bottom):");
            intStack.print();
            System.out.println("> Peek at the Stack: " + intStack.peek());
            intStack.pop();
            System.out.println("> Peek at the Stack after pop: " + intStack.peek());
            System.out.println("> Display the Stack (start from the top to bottom):");
            intStack.print();
            intStack.push(200);
            intStack.push(20);
            System.out.println("> Display the Stack (start from the top to bottom):");
            intStack.print();
        } catch (Exception e) {
            System.err.println("> Got an error: " + e.getMessage());
        }
    }
}
