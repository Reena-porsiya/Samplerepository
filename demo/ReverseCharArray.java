public class ReverseCharArray {
    public static void main(String[] args) {
        char[] charArray = {'R', 'E', 'E', 'N','A'};

        System.out.println("Original array: " + new String(charArray));
        reverseArray(charArray);
        System.out.println("Reversed array: " + new String(charArray));
    }

    public static void reverseArray(char[] charArray) {
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}