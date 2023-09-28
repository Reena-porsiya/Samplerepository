class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class MethodOverloadingExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sum1 = calculator.add(5, 10);
        System.out.println("Sum of two integers: " + sum1);

        double sum2 = calculator.add(3.5, 2.5);
        System.out.println("Sum of two doubles: " + sum2);

        int sum3 = calculator.add(2, 4, 6);
        System.out.println("Sum of three integers: " + sum3);
    }
}