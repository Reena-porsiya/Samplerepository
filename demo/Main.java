public class Main{
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
}
