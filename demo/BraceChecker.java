public class Brace {
    public static boolean checkBraces(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '{') {
                count++;
            } else if (ch == '}') {
                count--;
            }

            if (count < 0) {
                
                return false;
            }
        }

        return count == 0; 
    }

    public static void main(String[] args) {
        String testString1 = "{ W }";
        String testString2 = "{ { } }";
        String testString3 = "{ { }";

        System.out.println(checkBraces(testString1)); 
        System.out.println(checkBraces(testString2)); 
        System.out.println(checkBraces(testString3)); 
    }
}
