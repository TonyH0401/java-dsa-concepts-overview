public class Square extends Rectangle {
    private double length;

    // Constructor:
    public Square() {
        this.length = 0;
    }

    public Square(double length) {
        this.length = length;
    }

    // Setter and Getter:
    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // ToString:
    @Override
    public String toString() {
        return "{" + " length='" + getLength() + "'" + "}";
    }

}
