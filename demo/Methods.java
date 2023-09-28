public class Methods {
    public static void printMessage() {
        System.out.println("Hello, World!");
    }
    public static int addNumbers(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        printMessage();
        int result = addNumbers(5, 10);
        System.out.println("Sum: " + result);
    }
}