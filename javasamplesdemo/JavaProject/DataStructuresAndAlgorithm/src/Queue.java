class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class Queue {
    private Node headNode;

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public void addNode(String data) {
        Node newNode = new Node(data);
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

    public void insertNode(String newData, String afterData) {
        Node newNode = new Node(newData);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node current = headNode;
            while (current != null && !current.getData().equals(afterData)) {
                current = current.getNext();
            }
            if (current != null) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
            } else {
                current = headNode;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }
    }

    public boolean searchNode(String name) {
        Node current = headNode;
        while (current != null) {
            if (current.getData().equals(name)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void removeNode(String data) {
        if (headNode == null) {
            return;
        }

        if (headNode.getData().equals(data)) {
            headNode = headNode.getNext();
            return;
        }

        Node current = headNode;
        Node previous = null;
        while (current != null && !current.getData().equals(data)) {
            previous = current;
            current = current.getNext();
        }

        if (current != null) {
            previous.setNext(current.getNext());
        }
    }

    public void display() {
        Node current = headNode;
        while (current != null) {
            System.out.print(current.getData() + "  ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.addNode("John");
        q1.addNode("Lisa");
        q1.addNode("ram");
        q1.addNode("abi");

        // Inserting the node with data "vimal" after "John" if it exists, otherwise, append to the end
        q1.insertNode("vimal", "John");
        System.out.println("Queue after inserting 'vimal' after 'John':");
        q1.display();

        // Removing the node with data "Lisa"
        q1.removeNode("Lisa");
        System.out.println("\nQueue after removing 'Lisa':");
        q1.display();

        boolean foundNode = q1.searchNode("abi");
        if (foundNode) {
            System.out.println("\nNode found.");
        } else {
            System.out.println("\nNode not found.");
        }
    }
}

