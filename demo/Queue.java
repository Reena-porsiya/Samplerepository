class Queue {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int front; // Index of the front element in the queue
    private int rear;  // Index of the rear element in the queue
    private int size;  // Number of elements in the queue

    public Queue() {
        elements = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add an element to the end of the queue (enqueue operation)
    public void enqueue(Object item) {
        if (size == elements.length) {
            resizeArray();
        }

        rear = (rear + 1) % elements.length; // Circular queue
        elements[rear] = item;
        size++;
    }

    // Remove and return the element from the front of the queue (dequeue operation)
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        Object data = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length; // Circular queue
        size--;

        return data;
    }

    // Get the element at the front of the queue without removing it
    public Object peek() {
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
        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = elements[front];
            front = (front + 1) % elements.length; // Circular queue
        }

        elements = newArray;
        front = 0;
        rear = size - 1;
    }
}

/*public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue("Item 1");
        queue.enqueue("Item 2");
        queue.enqueue("Item 3");

        System.out.println("Queue size: " + queue.size());

        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Dequeued item: " + queue.dequeue());

        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}*/
