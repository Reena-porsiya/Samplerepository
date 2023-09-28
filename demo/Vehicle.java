
class Vehicle {
    void accelerate() {
        System.out.println("The vehicle is accelerating.");
    }
}
class Car extends Vehicle {
    void honk() {
        System.out.println("The car is honking.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.accelerate();
        myCar.honk();
    }
}
