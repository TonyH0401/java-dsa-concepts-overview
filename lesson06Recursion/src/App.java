public class App {
    public static void main(String[] args) throws Exception {
        /* I will demo recursion by doing a fibonacci */
        int n = 10; // Change the value of n as needed
        System.out.println("Fibonacci sequence up to " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
