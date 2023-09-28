public class Main01 {
    public static void main(String[] args) {
        int[] input = { /* 1000 input values go here */ };

        for (int i = 0; i < input.length - 2; i++) {
            if (i == 2 || i == 3 || i == 6 || i == 7) {
                continue;
            }

            int sum = input[i] + input[i + 2];
            System.out.println(input[i] + " + " + input[i + 2] + " = " + sum);
        }
    }
}
