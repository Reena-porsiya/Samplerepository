 public class Circle {  
    // Define final static variables for the mathematical constant pi and the default radius of a circle  
    final static double PI = 3.14159;  
    final static int DEFAULT_RADIUS = 5;  
      
    // Instance variable for the radius of the circle  
    int radius;  
  
    // Constructor to create a circle with the default radius  
    public Circle() {  
        this.radius = DEFAULT_RADIUS;  
    }  
  
    // Constructor to create a circle with a specific radius  
    public Circle(int radius) {  
        this.radius = radius;  
    }  
  
    //Method to calculate the area of the circle  
    public double getArea() {  
        return PI * radius * radius;  
    }  
  
    //Method to calculate the circumference of the circle  
    public double getCircumference() {  
        return 2 * PI * radius;  
    }  
  
    public static void main(String[] args) {  
        // Create two circle objects, one with the default radius and one with a radius of 10  
        Circle circle1 = new Circle();  
 
  
        // Print out the properties of each circle, including the radius, area, and circumference  
        System.out.println("Circle 1 - Radius: " + circle1.radius);  
        System.out.println("Circle 1 - Area: " + circle1.getArea());  
        System.out.println("Circle 1 - Circumference: " + circle1.getCircumference());  
  
    }  
}  