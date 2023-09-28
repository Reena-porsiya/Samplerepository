class Queue {
    private static final int DEFAULT_CAPACITY = 10;
    private String[] elements;
    private int front; // Index of the front element in the queue
    private int rear;  // Index of the rear element in the queue
    private int size;  // Number of elements in the queue

    public Queue() {
        elements = new String[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add an element to the end of the queue (enqueue operation)
    public void enqueue(String item) {
        if (size == elements.length) {
            resizeArray();
        }

        rear = (rear + 1) % elements.length; // Circular queue
        elements[rear] = item;
        size++;
    }

    // Remove and return the element from the front of the queue (dequeue operation)
    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        String data = elements[front];
        elements[front] = null; // Optional: Set the element to null after dequeueing
        front = (front + 1) % elements.length; // Circular queue
        size--;

        return data;
    }

    // Get the element at the front of the queue without removing it
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return elements[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the queue (number of elements in the queue)
    public int size() {
        return size;
    }

    // Helper method to resize the array if needed
    private void resizeArray() {
        int newCapacity = elements.length * 2;
        String[] newArray = new String[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = elements[front];
            front = (front + 1) % elements.length; // Circular queue
        }

        elements = newArray;
        front = 0;
        rear = size - 1;
    }

    // Print all elements in the queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int current = front;
        for (int i = 0; i < size; i++) {
            System.out.println(elements[current]);
            current = (current + 1) % elements.length; // Circular queue
        }
    }
}

public class QueueExample {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements to the queue
        queue.enqueue("Jas");
        queue.enqueue("Josh");
        queue.enqueue("Malar");

        System.out.println("Queue size: " + queue.size());

        // Print all elements in the queue
        System.out.println("Elements in the queue:");
        queue.printQueue();

        // Dequeue an element from the queue
        System.out.println("Dequeued element: " + queue.dequeue());

        // Print all elements in the queue after dequeuing one element
        System.out.println("Elements in the queue after dequeuing:");
        queue.printQueue();

        // Enqueue more elements
        queue.enqueue("David");
        queue.enqueue("Alice");
     

        //System.out.println("Queue size after enqueuing: " + queue.size());

        // Print all elements in the queue again
        System.out.println("Elements in the queue after enqueuing:");
        queue.printQueue();
    }
}
