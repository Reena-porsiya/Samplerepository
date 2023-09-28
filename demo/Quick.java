import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] inp = {5, 8, 4, 3, 7, 6, 2, 9, 5};
        Sorting.quicksort(inp, 0, inp.length - 1);
        System.out.println(Arrays.toString(inp));
    }
}

class Sorting {
    public static void quicksort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int start = low;
        int end = high;
        int mid = (start + end) / 2;
        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] < pivot)
                start++;
            while (arr[end] > pivot)
                end--;
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quicksort(arr, low, end);
        quicksort(arr, start, high);
    }
}

