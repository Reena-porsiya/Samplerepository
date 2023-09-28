class Rectangle {
    int length;
    int width;

    // Multiple-argument constructor
    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate the area of the rectangle
    int calculateArea() {
        return length * width;
    }
}

public class MultipleArgumentConstructor {
    public static void main(String[] args) {
        // Create an instance using the multiple-argument constructor
        Rectangle rectangle = new Rectangle(5, 10);

        // Calculate and display the area of the rectangle
        int area = rectangle.calculateArea();
        System.out.println("Area of the rectangle: " + area);
    }
}