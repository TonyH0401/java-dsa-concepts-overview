public class Rectangle {
    private double length;
    private double width;

    // Constructor:
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(Rectangle rec) {
        this.length = rec.getLength();
        this.width = rec.getWidth();
    }

    // Setter and Getter:
    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // ToString:
    @Override
    public String toString() {
        return "{" + " length='" + getLength() + "'" + ", width='" + getWidth() + "'" + "}";
    }

    // Rectangle Functions:
    public double getArea() {
        return this.length * this.width;
    }

    public double getPerimeter() {
        return (this.length + this.width) * 2;
    }
}
