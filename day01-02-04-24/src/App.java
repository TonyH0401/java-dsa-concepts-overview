public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, OOP World!");
        // ====================================
        Rectangle rec1 = new Rectangle(2, 1);
        System.out.println("Rec1 information: " + rec1.toString());
        System.out.println("Rec1 Area: " + rec1.getArea());
        System.out.println("Rec1 Perimeter: " + rec1.getPerimeter());
        // ====================================
    }
}
