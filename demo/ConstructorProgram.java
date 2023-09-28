class Car {
    String make;
    String model;
    int year;

    // Default constructor
    Car() {
        make = "Unknown";
        model = "Unknown";
        year = 0;
    }

    // Parameterized constructor
    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display the details of the car
    void displayDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

public class ConstructorProgram {
    public static void main(String[] args) {
        // Create an instance using the default constructor
        Car car1 = new Car();
        System.out.println("Details of car1:");
        car1.displayDetails();
        System.out.println();

        // Create an instance using the parameterized constructor
        Car car2 = new Car("Toyota", "Camry", 2021);
        System.out.println("Details of car2:");
        car2.displayDetails();
    }
}

/*Details of car1:
Make: Unknown
Model: Unknown
Year: 0

Details of car2:
Make: Toyota
Model: Camry
Year: 2021
*/