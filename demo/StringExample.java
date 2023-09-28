public class StringExample {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = new String("Hello, Java!");
        String concatenated = str1 + " " + str2;
        int length = concatenated.length();
        char firstChar = concatenated.charAt(0);
        String upperCase = concatenated.toUpperCase();
        boolean contains = concatenated.contains("World");
        System.out.println("Concatenated string: " + concatenated);
        System.out.println("Length of the string: " + length);
        System.out.println("First character: " + firstChar);
        System.out.println("Uppercase string: " + upperCase);
        System.out.println("Contains 'World'?: " + contains);
    }
}