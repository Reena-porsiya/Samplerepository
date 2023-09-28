import java.util.Scanner;

public class Main00 {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        int prevNum = 0;
        int currentNum = 0;
        int nextNum = 0;

        // Input 100 values from the user
        for (int i = 0; i < 100; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            currentNum = scanner.nextInt();

            if (i == 2 || i == 3 || i == 6 || i == 7) {
                prevNum = currentNum;
                continue;
            }

            if (i > 1) {
                int sum = prevNum + currentNum;
                System.out.println(prevNum + " + " + currentNum + " = " + sum);
            }

            prevNum = currentNum;
        }

        // Close the scanner
        scanner.close();
    }
}
