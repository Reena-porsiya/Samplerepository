class Stack {
    private static final int DEFAULT_CAPACITY = 10;
    private String[] elements;
    private int top; // Index of the top element in the stack

    public Stack() {
        elements = new String[DEFAULT_CAPACITY];
        top = -1;
    }

    // Add an element to the top of the stack (push operation)
    public void push(String item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full.");
        }

        top++;
        elements[top] = item;
    }

    // Remove and return the top element from the stack (pop operation)
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        String data = elements[top];
        elements[top] = null; // Optional: Set the element to null after popping
        top--;

        return data;
    }

    // Get the top element without removing it
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return elements[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == elements.length - 1;
    }

    // Get the size of the stack (number of elements in the stack)
    public int size() {
        return top + 1;
    }

    // Print all elements in the stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Elements in the stack:");
            for (int i = top; i >= 0; i--) {
                System.out.println(elements[i]);
            }
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Pushing elements onto the stack
        stack.push("Alice");
        stack.push("Bob");
        stack.push("Charlie");

        // Print all elements in the stack after initial push
        System.out.println("Elements in the stack after initial push:");
        stack.printStack();

        // Pop an element from the stack
        System.out.println("\nPopped element: " + stack.pop());

        // Print all elements in the stack after popping
        System.out.println("Elements in the stack after popping:");
        stack.printStack();

        // Pushing more elements onto the stack
        stack.push("David");
        stack.push("Eva");

        // Print all elements in the stack after pushing more names
        System.out.println("\nElements in the stack after pushing more names:");
        stack.printStack();
    }
}

