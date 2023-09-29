package sample;

public class ArrayMultiplier {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        
        int[] result = new int[array1.length * array2.length];
        
        int index = 0; // Index for the result array
        
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                result[index] = array1[i] * array2[j];
                index++;
            }
        }
        
       
        System.out.print("Result: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
