class Node{
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front; // Points to the front (head) of the queue
    private Node rear;  // Points to the rear (tail) of the queue

    public Queue() {
        front = null;
        rear = null;
    }

    // Add an element to the end of the queue (enqueue operation)
    public void enqueue(Object item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            // If the queue is empty, both front and rear point to the new node
            front = newNode;
            rear = newNode;
        } else {
            // If the queue is not empty, update the rear node and link the new node
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Remove and return the element from the front of the queue (dequeue operation)
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        Object data = front.data;
        front = front.next;

        // If the queue becomes empty after dequeuing, update rear to null as well
        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Get the element at the front of the queue without removing it
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue (number of elements in the queue)
    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}