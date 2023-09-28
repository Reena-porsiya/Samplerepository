public class AccessModifiersExample {
    public int publicVariable = 10;
    private int privateVariable = 20;
    protected int protectedVariable = 30;
    int defaultVariable = 40;

    public void publicMethod() {
        System.out.println("This is a public method");
    }

    private void privateMethod() {
        System.out.println("This is a private method");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method");
    }

    void defaultMethod() {
        System.out.println("This is a default method");
    }

    public static void main(String[] args) {
        AccessModifiersExample example = new AccessModifiersExample();

        System.out.println("Public variable: " + example.publicVariable);
        System.out.println("Private variable: " + example.privateVariable);
        System.out.println("Protected variable: " + example.protectedVariable);
        System.out.println("Default variable: " + example.defaultVariable);

        example.publicMethod();
        example.privateMethod();
        example.protectedMethod();
        example.defaultMethod();
    }
}