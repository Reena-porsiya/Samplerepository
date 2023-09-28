class Node {
    private String name;
    private Node next;

    public Node(String name) {
        this.name = name;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class Queue3 {
    private Node headNode;

    public void addNode(String name) {
        Node newNode = new Node(name);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node current = headNode;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void removeNode() {
        if (headNode != null) {
            headNode = headNode.getNext();
        }
    }

    public void insert(String name) {
        Node newNode = new Node(name);
        newNode.setNext(headNode);
        headNode = newNode;
    }

    public void printNodes() {
        Node current = headNode;
        System.out.println("Nodes in the queue:");
        while (current != null) {
            System.out.println(current.getName());
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.addNode("John");
        q1.addNode("Lisa");
        q1.printNodes();

        q1.insert("Reena");
        q1.printNodes();
    }
}
